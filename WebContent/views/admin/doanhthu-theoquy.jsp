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
	<h1>DOANH THU THEO QUÝ</h1>
	
	
    <div id="piechart" style="width: 900px; height: 500px;"></div>
	
	
	<table class="table">
		<thead>
			<tr>
				<th>Qúy</th>
				<th>Doanh số</th>
				<th>Số lượng bán</th>
				<th>Gía bán thấp nhất</th>
				<th>Gía bán cao nhất</th>
				<th>Gía bán trung bình</th>
			</tr>
		</thead>
		<tbody>
<!-- 		items la mot list -->
			<tr ng-repeat="a in doanhthuquy">
				<td>{{a[0]}}</td>
				<td>{{a[1] | number:0}} VND</td>
				<td>{{a[2]}}</td>
				<td>{{a[3] | number:0}} VND VND</td>
				<td>{{a[4] | number:0}} VND VND</td>
				<td>{{a[5] | number:0}} VND VND</td>
			</tr>
		</tbody>
	</table>
</body>
</html>