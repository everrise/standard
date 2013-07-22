package jp.co.everrise.tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import jp.co.everrise.io.CsvReader;
import jp.co.everrise.utils.ErIoUtil;

import org.seasar.extension.dataset.ColumnType;
import org.seasar.extension.dataset.DataColumn;
import org.seasar.extension.dataset.DataReader;
import org.seasar.extension.dataset.DataRow;
import org.seasar.extension.dataset.DataSet;
import org.seasar.extension.dataset.DataSetConstants;
import org.seasar.extension.dataset.DataTable;
import org.seasar.extension.dataset.impl.DataSetImpl;
import org.seasar.extension.dataset.types.ColumnTypes;
import org.seasar.extension.dataset.types.TimestampType;
import org.seasar.extension.jdbc.util.ConnectionUtil;
import org.seasar.extension.jdbc.util.DataSourceUtil;
import org.seasar.framework.exception.IORuntimeException;
import org.seasar.framework.exception.SQLRuntimeException;
import org.seasar.framework.util.ResourceUtil;
import org.seasar.framework.util.StringUtil;

public class CsvDataReader implements DataReader, DataSetConstants {

	private static final String datePattern = "yyyy-MM-dd";
	private static final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	private static final String timestampPattern = "yyyy-MM-dd HH:mm:ss.SSS";

	private static final int DATE_PATTERN_LENGTH = datePattern.length();
	private static final int DATE_TIME_PATTERN_LENGTH = dateTimePattern.length();
	private static final int TIMESTAMP_PATTERN_LENGTH = timestampPattern.length();

	private String charset;

	private DataSource dataSource;

	private DataSetImpl dataSet;

	public CsvDataReader(String dir, boolean trimString, DataSource dataSource) {
		this(dir, trimString, dataSource, "SHIFT_JIS");
	}

	public CsvDataReader(String dir, boolean trimString, DataSource dataSource, String charset) {
		this.charset = charset;
		this.dataSource = dataSource;
		BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceUtil.getResourceAsStream(dir
				+ "/table-ordering.txt")));
		dataSet = new DataSetImpl();
		try {
			for (String tableName; (tableName = reader.readLine()) != null;){
			    String[] params = tableName.split(" ");
			    if(params.length == 1){
			        createTable(dir, tableName, trimString);
			    }else{
                    createTableWithFilePath(dir + "/" + params[1], params[0], trimString);
			    }
			}
		} catch (IOException e) {
			throw new IORuntimeException(e);
		} finally {
			ErIoUtil.close(reader);
		}
	}

	protected DataTable createTable(String dir, String tableName, boolean trimString) throws IOException {
		String path = dir + "/" + tableName + ".csv";
		CsvReader csv = new CsvReader(new InputStreamReader(ResourceUtil.getResourceAsStream(path), charset));

		Map<String, ColumnType> columnTypeMap = getColumnTypeMap(tableName);

		try {
			DataTable dataTable = dataSet.addTable(tableName);
			String[] header = csv.readRow();
			DataColumn[] columns = new DataColumn[header.length];
			for (int i = 0; i < columns.length; i++) {
				String columnName = header[i];
				columns[i] = dataTable.addColumn(columnName, columnTypeMap.get(columnName));
			}

			int rowNum = 1;
			for (String[] row; (row = csv.readRow()) != null;) {
				DataRow dataRow = dataTable.addRow();
				for (int i = 0; i < row.length; ++i) {
					if (trimString && StringUtil.isEmpty(row[i])) {
						dataRow.setValue(i, null);
					} else {
						ColumnType columnType = columns[i].getColumnType();
						try {
							if (columnType instanceof TimestampType) {
								int length = row[i].length();
								if (length == DATE_PATTERN_LENGTH) {
									dataRow.setValue(i, columnType.convert(row[i], datePattern));
								} else if (length == DATE_TIME_PATTERN_LENGTH) {
									dataRow.setValue(i, columnType.convert(row[i], dateTimePattern));
								} else if (length == TIMESTAMP_PATTERN_LENGTH) {
									dataRow.setValue(i, columnType.convert(row[i], timestampPattern));
								}
							} else {
								dataRow.setValue(i, row[i]);
							}
						} catch (Exception e) {
							throw new RuntimeException(e.getClass().getName() + ": " + e.getMessage() + " (" + dir
									+ "/" + tableName + ".csv " + rowNum + " : " + i + " " + columns[i].getColumnName()
									+ " )", e);
						}
					}
				}
				rowNum++;
			}
			return dataTable;
		} finally {
			csv.close();
		}
	}
    protected DataTable createTableWithFilePath(String filePath, String tableName, boolean trimString) throws IOException {
        String path = filePath;
        CsvReader csv = new CsvReader(new InputStreamReader(ResourceUtil.getResourceAsStream(path), charset));

        Map<String, ColumnType> columnTypeMap = getColumnTypeMap(tableName);

        try {
            DataTable dataTable = dataSet.addTable(tableName);
            String[] header = csv.readRow();
            DataColumn[] columns = new DataColumn[header.length];
            for (int i = 0; i < columns.length; i++) {
                String columnName = header[i];
                columns[i] = dataTable.addColumn(columnName, columnTypeMap.get(columnName));
            }

            int rowNum = 1;
            for (String[] row; (row = csv.readRow()) != null;) {
                DataRow dataRow = dataTable.addRow();
                for (int i = 0; i < row.length; ++i) {
                    if (trimString && StringUtil.isEmpty(row[i])) {
                        dataRow.setValue(i, null);
                    } else {
                        ColumnType columnType = columns[i].getColumnType();
                        try {
                            if (columnType instanceof TimestampType) {
                                int length = row[i].length();
                                if (length == DATE_PATTERN_LENGTH) {
                                    dataRow.setValue(i, columnType.convert(row[i], datePattern));
                                } else if (length == DATE_TIME_PATTERN_LENGTH) {
                                    dataRow.setValue(i, columnType.convert(row[i], dateTimePattern));
                                } else if (length == TIMESTAMP_PATTERN_LENGTH) {
                                    dataRow.setValue(i, columnType.convert(row[i], timestampPattern));
                                }
                            } else {
                                dataRow.setValue(i, row[i]);
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e.getClass().getName() + ": " + e.getMessage() + " (" + path
                                    + " " + rowNum + " : " + i + " " + columns[i].getColumnName()
                                    + " )", e);
                        }
                    }
                }
                rowNum++;
            }
            return dataTable;
        } finally {
            csv.close();
        }
    }

	
	private Map<String, ColumnType> getColumnTypeMap(String tableName) {
		Map<String, ColumnType> columnTypeMap = new HashMap<String, ColumnType>();
		Connection connection = DataSourceUtil.getConnection(dataSource);
		try {
			DatabaseMetaData metaData = ConnectionUtil.getMetaData(connection);
			ResultSet columnMetas = metaData.getColumns(connection.getCatalog(), metaData.getUserName(), tableName.toUpperCase(), null);
//			if (columnMetas.getFetchSize() == 0) {
//				throw new RuntimeException(tableName + " table not found.");
//			}
			while (columnMetas.next()) {
				int type = columnMetas.getInt("DATA_TYPE");
				ColumnType columnType = ColumnTypes.getColumnType(type);
				columnTypeMap.put(columnMetas.getString("COLUMN_NAME"), columnType);
			}
			return columnTypeMap;
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		} finally {
			ConnectionUtil.close(connection);
		}
	}

	@Override
	public DataSet read() {
		return dataSet;
	}
}
