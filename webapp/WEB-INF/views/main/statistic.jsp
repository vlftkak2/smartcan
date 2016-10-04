<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/smartcan/assets/css/statistic.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/mysite5/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>
	//스트립트 로딩과 차트 초기화
	google.charts.load('current', {packages:['corechart']});
	
	// 로딩 완료시 함수 실행하여 차트 생성 
	google.charts.setOnLoadCallback(drawChart);
	function drawChart(){
		
		// 차트 데이터 설정
		var data = google.visualization.arrayToDataTable([
		    ['항목','통계량'], //항목정의
		    ['안양',${map.anyang}],
		    ['서울',${map.seoul}],
		    ['인천',${map.incheon}]
		  ]);
		
		
		// 그래프 옵션
		var options = {
			title : '일일 쓰레기 통계량 (단위:t)', // 제목
			width: 450, // 가로 px
			height: 400, // 세로px
			bar : {
				groupWidth: '80%' // 그래프 너비 설정 %
			},
			legend: {
				position : 'none' // 항목 표시 여부 (현재 설정 안함)
			}
		};
		
		var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>
<script>
//스트립트 로딩과 차트 초기화
  google.charts.load("current", {packages:["corechart"]});
  
	// 로딩 완료시 함수 실행하여 차트 생성 
  google.charts.setOnLoadCallback(drawChart);
	
  function drawChart() {
	  
	// 차트 데이터 설정
    var data = google.visualization.arrayToDataTable([
      ['항목', '통계량'],
      ['안양',${map.anyangCount}],
      ['인천',${map.incheonCount}],
      ['서울', ${map.seoulCount}]
    ]);
    var options = {
      title: '스마트 쓰레기통 설치 수',
      is3D: true,
    };
    var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
    chart.draw(data, options);
  }
  
  </script>
</head>
<body>

<div id="container">
<jsp:include page="/WEB-INF/views/include/header.jsp" />
<div id="content">
<div id="main_chart">
<div id="sub_chart">
	<div id="brand_main">
		<h1>통계량</h1>
	</div>
	<div id="txt_header">
<p>전국 지역 통계량을 보여주는 화면입니다</p>
<p></p>
</div>
	<div id="chart_wrap">
		<div id="chart_left">
			<div id="chart_div"></div> <!-- 여기에 차트가 생성됩니다. div id="chart_div" 건들이지 말 것 -->
		</div>
		<div id="chart_right">
			<div id="piechart_3d" style="width: 600px; height: 500px;"></div> <!-- piechart_3d 건들이지 말 것 -->
		</div>
	</div>
	</div>
</div>
</div>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</div>

</body>
</html>