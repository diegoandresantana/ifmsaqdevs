$( document ).ready(function() {
	 
// Bring life to the dials
setInterval(function () {
	atualizaGraficoTemperatura();
//	atualizaGraficoChuva();
//	atualizaGraficoUmidade();
//	atualizaGraficoLuminosidade();
}, 2000);

function atualizaGraficoTemperatura(){	
	$.ajax({
	    type: "GET",
	    url: "/historico/historicoTemperatura",
	    data: "",
	    dataType: "json",
	    success: function(json){
	        var temp;        
	        if (chartTemperatura) {
	            temp = chartTemperatura.series[0].points[0];
	            obj=eval(json);
	            if(isNaN(obj.dado)){
	            	temp.update(obj.dado);
	            }else{
	            	temp.update(obj.dado);	            	
	            }
	        }
	    }
	 });
	
	$.getJSON(
		    '/historico/historicoTemperatura',
		    function (data) {
               
		        Highcharts.chart('container-temperatura', {
		            chart: {
		                zoomType: 'x'
		            },
		            title: {
		                text: 'Variação de temperatura'
		            },
		            subtitle: {
		                text: document.ontouchstart === undefined ?
		                        'Click and drag in the plot area to zoom in' : 'Pinch the chart to zoom in'
		            },
		            xAxis: {
		                type: 'datetime'
		            },
		            yAxis: {
		                title: {
		                    text: 'Temperatura'
		                }
		            },
		            legend: {
		                enabled: false
		            },
		            plotOptions: {
		                area: {
		                    fillColor: {
		                        linearGradient: {
		                            x1: 0,
		                            y1: 0,
		                            x2: 0,
		                            y2: 1
		                        },
		                        stops: [
		                            [0, Highcharts.getOptions().colors[0]],
		                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
		                        ]
		                    },
		                    marker: {
		                        radius: 2
		                    },
		                    lineWidth: 1,
		                    states: {
		                        hover: {
		                            lineWidth: 1
		                        }
		                    },
		                    threshold: null
		                }
		            },

		            series: [{
		                type: 'area',
		                name: 'dado',
		                data: data
		            },{
		                type: 'area',
		                name: 'dataHora',
		                data: data
		            }]
		        });
		    }
		);
	
}
 // 
//function atualizaGraficoChuva(){
//	$.ajax({
//	    type: "GET",
//	    url: "/historico/historicoChuva",
//	    data: "",
//	    dataType: "json",
//	    success: function(json){
//	        var chuv;        
//	        if (chartChuva) {
//	            chuv = chartChuva.series[0].points[0];
//	            obj=eval(json);
//	            if(isNaN(obj.dado)){
//	            	chuv.update(obj.dado);
//	            }else{
//	            	chuv.update(obj.dado);	            	
//	            }
//	        }
//	    }
//	 });
//}
//
//function atualizaGraficoUmidade(){
//	$.ajax({
//	    type: "GET",
//	    url: "/historico/historicoUmidade",
//	    data: "",
//	    dataType: "json",
//	    success: function(json){
//	        var umi;        
//	        if (chartUmidade) {
//	            umi = chartUmidade.series[0].points[0];
//	            obj=eval(json);
//	            if(isNaN(obj.dado)){
//	            	umi.update(obj.dado);
//	            }else{
//	            umi.update(obj.dado);	            	
//	            }
//	        }
//	    }
//	 });	
//}
// 
//function atualizaGraficoLuminosidade(){
//		$.ajax({
//		    type: "GET",
//		    url: "/historico/historicoLuminosidade",
//		    data: "",
//		    dataType: "json",
//		    success: function(json){
//		        var lum;        
//		        if (chartLuminosidade) {
//		            lum = chartLuminosidade.series[0].points[0];
//		            obj=eval(json);
//		            if(isNaN(lum.dado)){
//		            	lum.update(obj.dado);
//		            }else{
//		            lum.update(obj.dado);	            	
//		            }
//		        }
//		    }
//		 });		
//}
//

});
 