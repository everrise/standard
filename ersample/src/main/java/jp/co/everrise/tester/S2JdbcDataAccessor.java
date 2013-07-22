package jp.co.everrise.tester;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.unit.impl.SimpleDataAccessor;

public class S2JdbcDataAccessor extends SimpleDataAccessor {

	@Resource
	protected JdbcManager jdbcManager;

	@Override
	public void deleteTable(String tableName) {
		jdbcManager.updateBySql("DELETE FROM " + tableName).execute();
	}
}
