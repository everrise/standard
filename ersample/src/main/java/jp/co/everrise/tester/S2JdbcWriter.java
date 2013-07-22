package jp.co.everrise.tester;

import javax.annotation.Resource;

import org.seasar.extension.dataset.DataColumn;
import org.seasar.extension.dataset.DataRow;
import org.seasar.extension.dataset.DataSet;
import org.seasar.extension.dataset.DataTable;
import org.seasar.extension.dataset.impl.SqlWriter;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.SqlBatchUpdate;

public class S2JdbcWriter extends SqlWriter {

	@Resource
	protected JdbcManager jdbcManager;

	public S2JdbcWriter() {
		super(null);
	}

	@Override
	public void write(DataSet dataSet) {
		for (int i = 0; i < dataSet.getTableSize(); i++) {
			insertTable(dataSet.getTable(i));
		}
	}

	private void insertTable(DataTable table) {
		String tableName = table.getTableName();
		StringBuilder sql = new StringBuilder(100);
		sql.append("INSERT INTO ").append(tableName).append(" (");
		Class<?>[] paramClasses = new Class<?>[table.getColumnSize()];
		for (int i = 0; i < table.getColumnSize(); i++) {
			DataColumn column = table.getColumn(i);
			String columnName = column.getColumnName();
			sql.append(columnName).append(", ");
			paramClasses[i] = column.getColumnType().getType();
		}
		sql.setLength(sql.length() - 2);
		sql.append(") VALUES (");
		for (int i = 0; i < paramClasses.length; i++) {
			sql.append("?, ");
		}
		sql.setLength(sql.length() - 2);
		sql.append(")");

		SqlBatchUpdate batchUpdate = jdbcManager.updateBatchBySql(sql.toString(), paramClasses);
		for (int rowNum = 0; rowNum < table.getRowSize(); rowNum++) {
			DataRow row = table.getRow(rowNum);
			Object[] params = new Object[paramClasses.length];
			for (int i = 0; i < params.length; i++) {
				params[i] = row.getValue(i);
			}
			batchUpdate.params(params);
		}
		batchUpdate.execute();
	}
}
