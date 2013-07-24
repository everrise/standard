<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="top.title" /></tiles:put>
<tiles:put name="style" value="chart/index" />
<tiles:put name="content" type="string">
	<h2>Data get from Chart Table, it's just a sample</h2>
	<table border="1">
		<tr>
			<c:forEach var="item" items="${chart}">
				<td>${item.chart }</td>
			</c:forEach>
		</tr>
		<c:forEach var="item" items="${chart}">
			<tr>
				<td>${item.chartCountry }</td>
				<td>${item.chartId }</td>
				<td>${item.id }</td>
				<td>${item.chartQuantity }</td>
				<td>2</td>
				<td>5</td>
			</tr>
		</c:forEach>
	</table>

	<!-- Step 1: import libs -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load('visualization', '1', {packages: ['corechart']});
    </script>
    <script type="text/javascript">
      function drawVisualization() {

    <!-- Step 2: preparing data -->
        var data = google.visualization.arrayToDataTable(${data});

	<!-- Step 3: customizing with options -->
        var options = {
          title : 'Title Chart',
          vAxis: {title: "vAxis of Chart"},
          hAxis: {title: "hAxis of Chart"},
        };

    <!-- Step 4: drawing chart -->
        var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }

    <!-- Note: use setOnLoadCallback to draw chart after web page is load done -->
      google.setOnLoadCallback(drawVisualization);
    </script>
    <!-- Show chart on web -->
    <div id="chart_div" style="height: 500px;"></div>
</tiles:put>
</tiles:insert>