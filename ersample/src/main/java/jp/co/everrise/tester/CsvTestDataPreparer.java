package jp.co.everrise.tester;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.seasar.extension.dataset.DataSet;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.framework.unit.DataAccessor;
import org.seasar.framework.unit.PreparationType;
import org.seasar.framework.unit.TestContext;
import org.seasar.framework.unit.TestDataPreparer;
import org.seasar.framework.unit.impl.TestDataPreparerImpl;
import org.seasar.framework.util.ResourceUtil;

public class CsvTestDataPreparer implements TestDataPreparer {

	/** テストデータを持つCsvフォルダのパスのリスト */
	protected final List<String> testDataPaths = new ArrayList<String>();

	/** データアクセッサー */
	@Binding(bindingType = BindingType.MUST)
	protected DataAccessor dataAccessor;

	@Binding(bindingType = BindingType.MUST)
	protected DataSource dataSource;

	private String charset = "SHIFT_JIS";

	/**
	 * テストデータを持つExcelのパスを登録します。
	 *
	 * @param path
	 *            テストデータを持つExcelのパス
	 */
	public void addTestDataPath(final String path) {
		testDataPaths.add(path);
	}
	
	public void setCharset(String charset) {
		this.charset = charset;
	}

	@Override
	public void prepare(TestContext testContext) {
		final PreparationType preparationType = testContext.getPreparationType();
		final String dirPath = testContext.getTestClassPackagePath();
		final boolean trimString = testContext.isTrimString();
		for (final String path : testDataPaths) {
			if (ResourceUtil.isExist(path)) {
				prepare(preparationType, path, trimString);
				return;
			}
			final String newPath = dirPath + "/" + path;
			if (ResourceUtil.isExist(newPath)) {
				prepare(preparationType, newPath, trimString);
				return;
			}
		}
	}

	private void prepare(PreparationType preparationType, String path, boolean trimString) {
		if (preparationType == PreparationType.NONE) {
			return;
		}

		DataSet dataSet = new CsvDataReader(path, trimString, dataSource, charset).read();
		switch (preparationType) {
		case WRITE:
			//logger.debug("CSVファイルフォルダ({})の値をデータベースに書き込みます", path);
			break;
		case REPLACE:
			//logger.debug("CSVファイルフォルダ({})の値でデータベースを置き換えます", path);
			dataAccessor.deleteDb(dataSet);
			break;
		case ALL_REPLACE:
			//logger.debug("CSVファイルフォルダ({})の値でデータベースをすべて置き換えます", path);
			for (int i = 0; i < dataSet.getTableSize(); i++) {
				dataAccessor.deleteTable(dataSet.getTable(i).getTableName());
			}
			break;
		}
		dataAccessor.writeDb(dataSet);
	}
}
