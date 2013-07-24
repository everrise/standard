package jp.co.everrisesample.minimum01.action;

import java.util.List;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.entity.Chart;
import jp.co.everrisesample.minimum01.service.ChartService;

import org.seasar.struts.annotation.Execute;

public class ChartAction {

	public List<Chart> chart;
	@Resource
	public ChartService chartService;

	public String data;

	@Execute(validator = false)
	public String index() {
		chart = chartService.getAllChart();
		//shape data follow [[patern1,partern2],[patern1,partern2]]
		String chartData = "";
		String header = "[[";
		for (int i = 0; i < chart.size() ; i++) {
			Chart c = chart.get(i);
			String content = "[";
			header += "'"+chart.get(i).chart+"'"+(chart.size()-1 > i ? "," : "");
			content += c.toString();
			content += "]";
			if(i<chart.size()-1){
				content+=",";
			}
			chartData += content;
		}
		header += "],";
		header += chartData;
		header+="]";
		data = header;
		return "index.jsp";
	}

}

