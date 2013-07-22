package jp.co.everrise.tester;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.AssertionFailedError;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.seasar.extension.dataset.ColumnType;
import org.seasar.extension.dataset.DataRow;
import org.seasar.extension.dataset.DataSet;
import org.seasar.extension.dataset.DataTable;
import org.seasar.extension.dataset.types.ColumnTypes;

public class DataSetMatcher extends BaseMatcher<DataSet> {

	private final DataSet expected;

	public DataSetMatcher(DataSet expected) {
		this.expected = expected;
	}

	@Override
	public boolean matches(Object actual) {
		if (actual instanceof DataSet) {
			return areEqual(expected, (DataSet) actual);
		} else {
			return false;
		}
	}

	private boolean areEqual(DataSet expected, DataSet actual) {
		for (int i = 0; i < expected.getTableSize(); ++i) {
			if (!areEqual(expected.getTable(i), actual.getTable(i))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void describeTo(Description description) {
		description.appendValue(expected);
	}

	@Factory
	public static <T> DataSetMatcher dataSetEqualTo(DataSet expected) {
		return new DataSetMatcher(expected);
	}

	public boolean areEqual(DataTable expected, DataTable actual) {
		String message = ":TableName=" + expected.getTableName();
		assertThat(message + ":RowSize", actual.getRowSize(), is(expected.getRowSize()));
		for (int i = 0; i < expected.getRowSize(); ++i) {
			DataRow expectedRow = expected.getRow(i);
			DataRow actualRow = actual.getRow(i);
			List<String> errorMessages = new ArrayList<String>();
			for (int j = 0; j < expected.getColumnSize(); ++j) {
				try {
					String columnName = expected.getColumnName(j);
					Object expectedValue = expectedRow.getValue(columnName);
					ColumnType ct = ColumnTypes.getColumnType(expectedValue);
					Object actualValue = actualRow.getValue(columnName);
					if (!ct.equals(expectedValue, actualValue)) {
						assertThat(message + ":Row=" + i + ":columnName=" + columnName, actualValue, is(expectedValue));
					}
				} catch (AssertionFailedError e) {
					errorMessages.add(e.getMessage());
				}
			}
			if (!errorMessages.isEmpty()) {
				fail(message + errorMessages);
			}
		}
		return true;
	}
}
