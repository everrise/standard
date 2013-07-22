package jp.co.everrise.tester;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.seasar.extension.dataset.DataSet;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.framework.unit.ExpectedDataReader;
import org.seasar.framework.unit.TestContext;
import org.seasar.framework.util.ResourceUtil;

public class CsvExpectedDataReader implements ExpectedDataReader {

	/** 期待値が記述されたCsvフォルダパスのリスト */
	protected final List<String> expectedDataPaths = new ArrayList<String>();

	@Binding(bindingType = BindingType.MUST)
	protected DataSource dataSource;

	private String charset = "SHIFT_JIS";
	
	public void addExpectedDataPath(String path) {
		expectedDataPaths.add(path);
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}
	
	@Override
	public DataSet read(TestContext testContext) {
		final String dirPath = testContext.getTestClassPackagePath();
		final boolean trimString = testContext.isTrimString();
		for (final String path : expectedDataPaths) {
			if (ResourceUtil.isExist(path)) {
				return read(path, trimString);
			}
			final String newPath = dirPath + "/" + path;
			if (ResourceUtil.isExist(newPath)) {
				return read(newPath, trimString);
			}
		}
		return null;
	}

	private DataSet read(String path, boolean trimString) {
		return new CsvDataReader(path, trimString, dataSource, charset).read();
	}
}
