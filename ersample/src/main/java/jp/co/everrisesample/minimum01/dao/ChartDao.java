package jp.co.everrisesample.minimum01.dao;

//import static jp.co.everrisesample.minimum01.entity.Names.*;
//import static org.seasar.extension.jdbc.operation.Operations.*;

import java.util.List;

import jp.co.everrisesample.minimum01.entity.Chart;
public class ChartDao extends AbstractDao<Chart>{

	/**
	 * return all data from Chart Table
	 */
	public List<Chart> getAllChart(){
		return select().getResultList();
	}
}
