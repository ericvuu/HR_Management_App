
$(document).ready(function() {
	
	Chart.defaults.global.defaultFontSize = 20;
	
	var ctx = document.getElementById("myChart").getContext('2d');


	$.get('http://localhost:8080/charts/department', function(departments) {

		let dArr = [];
		let sArr = [];

		$.each(departments, function(d, size) {
			dArr.push(d);
			sArr.push(size);
		});

		var chart = new Chart(ctx, {

			// The type of chart we want to create
			type: 'bar',

			// The data for our dataset
			data: {
				labels: dArr,
				datasets: [{
					label: 'Number of Employees in Each Department',
					backgroundColor: 'rgb(255, 99, 132)',
					borderColor: 'rgb(255, 99, 132)',
					data: sArr,
				}]
			},

			// Configuration options go here
			options: {
				title: {
					display: true,
					text: 'Employees in Departments',
					fontSize: 25
				},
				
				
			}
		});

	});




});
