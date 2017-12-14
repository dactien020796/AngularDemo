app.controller('DoanhThuQuyCtrl', function ($rootScope, $scope, $location, $http) {
    console.log("Doanh Thu Quy controller");
    $scope.doanhthuquy = [];
    
	$http.get("admin/revenue/byquarter.php").success(function(data) {
		$scope.doanhthuquy = data;
		
		var object = new Array(30);
		 for(i=0; i< object.length; i++) {
			 object[i] = ["a",     0];
		 }
		 
		 for(i=0; i< data.length; i++) {
			 var ten = "" + data[i][0];
			 var so = data[i][1];
//			 temp += "['" + ten + "'," + so + "],";
			 object[i] = [ten,     so];
		 }
		 
		 google.charts.load('current', {'packages':['corechart']});
		 google.charts.setOnLoadCallback(drawChart);
		 
		 function drawChart() {
			 var data = google.visualization.arrayToDataTable([
				 ['Tháng', 'Doanh số'],
				 //temp
				 
				 object[0],
				 object[1],
				 object[2],
				 object[3],
				 object[4],
				 object[5],
				 object[6],
				 object[7],
				 object[8],
				 object[9],
				 object[10],
				 object[11],
				 object[12],
				 object[13],
				 object[14],
				 object[15],
				 object[16],
				 object[17],
				 object[18],
				 object[19],
				 object[20],
				 object[21],
				 object[22],
				 object[23],
				 object[24],
				 object[25],
				 object[26],
				 object[27],
				 object[28],
				 object[29],
				 ]);
			 var options = {
					 title: 'My Daily Activities'
			 	};

			 var chart = new google.visualization.PieChart(document.getElementById('piechart'));

			 chart.draw(data, options);
		 }
	});
});