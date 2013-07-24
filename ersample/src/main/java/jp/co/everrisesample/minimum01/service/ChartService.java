package jp.co.everrisesample.minimum01.service;

import java.util.List;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.dao.ChartDao;
import jp.co.everrisesample.minimum01.entity.Chart;

public class ChartService extends AbstractService{
	@Resource
	protected ChartDao chartDao;

	/**
	 * return all data from Chart Table
	 */
	public List<Chart> getAllChart(){
		return chartDao.getAllChart();
	}
}
