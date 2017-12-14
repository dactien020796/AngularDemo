<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html >

<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<br>
	<h1>DOANH THU THEO HÃNG</h1>
	
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          	['Hãng', 'Doanh số'],
//           	<c:forEach var="a" items="${items}">
  				["${a[0]}", ${a[1]}],
//   			</c:forEach>
        ]);

        var options = {
          title: 'Doanh số bán hàng theo từng hãng'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
    
    <div id="piechart" style="width: 900px; height: 500px;"></div>
	
	
	<table class="table">
		<thead>
			<tr>
				<th>Hãng</th>
				<th>Doanh số</th>
				<th>Số lượng bán</th>
				<th>Gía bán thấp nhất</th>
				<th>Gía bán cao nhất</th>
				<th>Gía bán trung bình</th>
			</tr>
		</thead>
		<tbody>
<!-- 		items la mot list -->
<%-- 			<c:forEach var="a" items="${items}">  --%>
<!-- 			<tr> -->
<%-- 				<td>${a[0]}</td> --%>
<%-- 				<td><f:formatNumber type="number" value="${a[1]}" pattern="###,###,###"/> VND</td> --%>
<%-- 				<td>${a[2]}</td> --%>
<%-- 				<td><f:formatNumber type="number" value="${a[3]}" pattern="###,###,###"/> VND</td> --%>
<%-- 				<td><f:formatNumber type="number" value="${a[4]}" pattern="###,###,###"/> VND</td> --%>
<%-- 				<td><f:formatNumber type="number" value="${a[5]}" pattern="###,###,###"/> VND</td> --%>
<!-- 			</tr> -->
<%-- 			</c:forEach> --%>
		</tbody>
	</table>
</body>
</html>