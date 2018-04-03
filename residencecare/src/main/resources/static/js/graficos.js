$( document ).ready(function() {
	var gaugeOptions = {
		chart: {
			type: 'solidgauge'
		},
		title: null,
		pane: {
			center: ['50%', '85%'],
			size: '140%',
			startAngle: -90,
			endAngle: 90,
			background: {
				backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || '#EEE',
				innerRadius: '60%',
				outerRadius: '100%',
				shape: 'arc'
			}
		},

		tooltip: {
			enabled: false
		},

		// the value axis
		yAxis: {
			stops: [
				[0.1, '#55BF3B'], // green
				[0.5, '#DDDF0D'], // yellow
				[0.9, '#DF5353'] // red
			],
			lineWidth: 0,
			minorTickInterval: null,
			tickAmount: 2,
			title: {
				y: -70
			},
			labels: {
				y: 16
			}
		},
		plotOptions: {
			solidgauge: {
				dataLabels: {
					y: 5,
					borderWidth: 0,
					useHTML: true
				}
			}
		}
	};

// Bring life to the dials
setInterval(function () {
	atualizaGraficoTemperatura();

   
}, 2000);
function atualizaGraficoTemperatura(){
	
	$.ajax({
	    type: "GET",
	    url: "/dashboard/temperaturaAtual",
	    data: "",
	    dataType: "json",
	    success: function(json){
	        var temp;        
	        if (chartTemperatura) {
	            temp = chartTemperatura.series[0].points[0];
	            obj=eval(json);
	            if(isNaN(temp.dado)){
	            	temp.update(obj.dado);
	            }else{
	            	temp.update(obj.dado);	            	
	            }
	        }
	    }
	 });
}


// The temperatura gauge
var chartTemperatura = Highcharts.chart('container-temperatura', Highcharts.merge(gaugeOptions, {
    yAxis: {
        min: 0,
        max: 100,
        title: {
            text: 'Temperatura'
        }
    },

    credits: {
        enabled: false
    },

    series: [{
        name: 'temperatura',
        data: [0],
        dataLabels: {
            format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span><br/>' +
                   '<span style="font-size:12px;color:silver">Cº</span></div>'
        },
        tooltip: {
            valueSuffix: ' cº'
        }
    }]

}));


// The umidade gauge
var chartUmidade = Highcharts.chart('container-umidade', Highcharts.merge(gaugeOptions, {
    yAxis: {
        min: 0,
        max: 100,
        title: {
            text: 'Umidade'
        }
    },

    credits: {
        enabled: false
    },

    series: [{
        name: 'umidade',
        data: [0],
        dataLabels: {
            format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span><br/>' +
                   '<span style="font-size:12px;color:silver">U%</span></div>'
        },
        tooltip: {
            valueSuffix: ' u%'
        }
    }]

}));


// The umidade gauge
var chartLuminosidade = Highcharts.chart('container-luminosidade', Highcharts.merge(gaugeOptions, {
    yAxis: {
        min: 0,
        max: 100,
        title: {
            text: 'Luminosidade'
        }
    },

    credits: {
        enabled: false
    },

    series: [{
        name: 'luminosidade',
        data: [0],
        dataLabels: {
            format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span><br/>' +
                   '<span style="font-size:12px;color:silver">L%</span></div>'
        },
        tooltip: {
            valueSuffix: ' l%'
        }
    }]

}));


// The umidade gauge
var chartChuva = Highcharts.chart('container-chuva', Highcharts.merge(gaugeOptions, {
    yAxis: {
        min: 0,
        max: 100,
        title: {
            text: 'Chuva'
        }
    },

    credits: {
        enabled: false
    },

    series: [{
        name: 'chuva',
        data: [0],
        dataLabels: {
            format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span><br/>' +
                   '<span style="font-size:12px;color:silver">C%</span></div>'
        },
        tooltip: {
            valueSuffix: ' c%'
        }
    }]

}));

});
 