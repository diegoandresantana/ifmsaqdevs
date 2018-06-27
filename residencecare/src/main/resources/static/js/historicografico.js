$( document ).ready(function() {
	Highcharts.setOptions({
	    lang: {
	        months: [
	            'Janeiro', 'Fevereiro', 'Março', 'Abril',
	            'Maio', 'Junho', 'Julho', 'Agosto',
	            'Setembro', 'Outubro', 'Novembro', 'Dezembro'
	        ],
	        weekdays: [
	            'Domingo', 'Segunda', 'Terça', 'Quarta',
	            'Quinta', 'Sexta', 'Sábado'
	        ]
	    }
	});
	Highcharts.wrap(Highcharts.Axis.prototype, 'zoom', function (proceed, newMin, newMax) {
		var ret = proceed.call(this, newMin, newMax);
	    
	    delete this.previousZoom;
	    
	    return ret;
	});
setInterval(function () {
	atualizaGraficoTemperatura();
	atualizaGraficoChuva();
	atualizaGraficoUmidade();
	atualizaGraficoLuminosidade();
}, 25000);
 
function atualizaGraficoTemperatura(){	
	$.ajax({
	    type: "GET",
	    url: "/historico/historicoTemperatura",
	    data: "",
	    headers:createAuthorizationTokenHeader(),
	    dataType: "json",
	    success: function(data){		    	     
 	          	  dataVector= [];
		          data.forEach(function(item, valor) {
		        	     cc =(item.dataHora+"").split(' ');		        	    
			    	     data=cc[0].split('-');
			    	     hora=cc[1].split(':');
			             t=Date.UTC( data[2],data[1]-1, data[0], hora[0], hora[1], hora[2]); 
 		        	     dataVector.push([t,item.dado]);	                   
	              });
		          Highcharts.chart('container-temperatura', {
		        	  
		        	 chart: { 
		        		 panKey: 'shift',
		        		 reflow:true,
		        		 panning:true,
		        		 borderWidth: 1,
		                 renderTo: 'container-temperatura',
		                 zoomType: 'xy',
		                 plotBorderWidth: 1,
		                 spacingLeft: 3,
		                 spacingRight: 3,
		                 spacingTop: 45,
		                 spacingBottom : 3,
		                 height : 400,
		                 resetZoomButton: {
		                     relativeTo: 'plot',
		                     position: {
		                         x: 3,
		                         y: 3,
		                         align: 'left'
		                     }
		                 }
			        },
		            title: {
		                text: 'Variação de temperatura'
		            },
		            subtitle: {
		                text: document.ontouchstart === undefined ?  'Clique e arraste para dar ZOOM' : 'Clique no gráfico para aumentar o ZOOM'
		            }, 
		             
		            xAxis: {
		                type: 'datetime',
		                dateTimeLabelFormats: { 		                	 
		                    second: '%H:%M:%S',
		                    minute: '%H:%M',
		                    hour: '%H:%M',
		                    day: '%e. %b',
		                    week: '%e. %b',
		                    month: '%b \'%y',
		                    year: '%Y'
		                },
		                labels: {
			                  format: "{value:%d-%m-%Y %H:%M:%S}" 
			            } 
			            ,crosshair: true
		            }, 
		            yAxis: { 
		                title: {
		                    text: 'Temperatura(°C)' 
		                } ,
			            labels: {
			                format: '{value}°C',
			                style: {
			                		color: Highcharts.getOptions().colors[1]
			                }
			            }
		            }    ,
		            tooltip: {
		            	headerFormat: '<b>{series.name}</b><br>',
		                formatter: function () {
		                    return '<b>' + this.series.name + '</b><br/>' +
		                        Highcharts.dateFormat('%d-%m-%Y %H:%M:%S', this.x) + '<br/>' +
		                        Highcharts.numberFormat(this.y, 1)+'Cº';
		                }
		            } ,
		            plotOptions: { 
		                area: {
		                    fillColor: {
		                        linearGradient: {
		                            x1: 0,
		                            y1: 1,
		                            x2: 0,
		                            y2: 1
		                        },
		                        stops: [
		                            [0, Highcharts.getOptions().colors[0]],
		                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
		                        ]
		                    },
		                    marker: {
		                        radius: 1
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
		            scrollbar: {
		                enabled: true,
		                height: 10,
		                barBorderWidth: 0,
		                buttonBorderWidth: 1,
		                trackBorderWidth: 1,
		                barBorderRadius: 3,
		                buttonBorderRadius: 3,
		                trackBorderRadius: 3
		            },     
		            series: [{ 
		            	 type: 'line',
		            	name: 'Temperatura',
		                data: dataVector,
		                zones: [{
		                	   value: -35,
		                	   color: '#0000FF'
		                	},{
		                	   value: 20,
		                	   color: '#0000FF'
		                	}, {
		                	   value: 35,
		                	   color: '#00FF00'
		                	}, {
		                	   color: '#FF0000'
		                	}]
		            }]
		        });
		    }
	});
	
 }
 atualizaGraficoTemperatura();
 
 function atualizaGraficoChuva(){	
	 $.ajax({
		    type: "GET",
		    url: "/historico/historicoChuva",
		    data: "",
		    headers:createAuthorizationTokenHeader(),
		    dataType: "json",
		    success: function(data){		    	     
	          	  dataVector= [];
		          data.forEach(function(item, valor) {
		        	     cc =(item.dataHora+"").split(' ');		        	    
			    	     data=cc[0].split('-');
			    	     hora=cc[1].split(':');
			             t=Date.UTC( data[2],data[1]-1, data[0], hora[0], hora[1], hora[2]); 
		        	     dataVector.push([t,item.dado]);	                   
	              });
		          Highcharts.chart('container-chuva', {
		        	 chart: { 
		        		 reflow:true,
		        		 panning:true,
		        		 borderWidth: 1,
		                 renderTo: 'container-chuva',
		                 zoomType: 'xy',
		                 plotBorderWidth: 1,
		                 spacingLeft: 3,
		                 spacingRight: 3,
		                 spacingTop: 45,
		                 spacingBottom : 3,
		                 height : 400,
		                 resetZoomButton: {
		                     relativeTo: 'plot',
		                     position: {
		                         x: 3,
		                         y: 3,
		                         align: 'left'
		                     }
		                 }
			        },
		            title: {
		                text: 'Variação da Chuva'
		            },
		            subtitle: {
		                text: document.ontouchstart === undefined ?  'Clique e arraste para dar ZOOM' : 'Clique no gráfico para aumentar o ZOOM'
		            }, 
		             
		            xAxis: {
		                type: 'datetime',
		                dateTimeLabelFormats: { 		                	 
		                    second: '%H:%M:%S',
		                    minute: '%H:%M',
		                    hour: '%H:%M',
		                    day: '%e. %b',
		                    week: '%e. %b',
		                    month: '%b \'%y',
		                    year: '%Y'
		                },
		                labels: {
			                  format: "{value:%d-%m-%Y %H:%M:%S}" 
			            },
			            
		            }, 
		            yAxis: { 
		                title: {
		                    text: 'Chuva(%)' 
		                } ,
			            labels: {
			                format: '{value}%',
			                style: {
			                		color: Highcharts.getOptions().colors[1]
			                }
			            }
		            }    ,
		            tooltip: {
		            	headerFormat: '<b>{series.name}</b><br>',
		                formatter: function () {
		                    return '<b>' + this.series.name + '</b><br/>' +
		                        Highcharts.dateFormat('%d-%m-%Y %H:%M:%S', this.x) + '<br/>' +
		                        Highcharts.numberFormat(this.y, 1)+'%';
		                }
		            } ,
		            plotOptions: { 
		                area: {
		                    fillColor: {
		                        linearGradient: {
		                            x1: 0,
		                            y1: 1,
		                            x2: 0,
		                            y2: 1
		                        },
		                        stops: [
		                            [0, Highcharts.getOptions().colors[0]],
		                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
		                        ]
		                    },
		                    marker: {
		                        radius: 1
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
		            scrollbar: {
		                enabled: true,
		                height: 10,
		                barBorderWidth: 0,
		                buttonBorderWidth: 1,
		                trackBorderWidth: 1,
		                barBorderRadius: 3,
		                buttonBorderRadius: 3,
		                trackBorderRadius: 3
		            },           
		            series: [{ 
		            	 type: 'line',
		            	name: 'Chuva',
		                data: dataVector,
		                zones: [{
		                	   value: -35,
		                	   color: '#0000FF'
		                	},{
		                	   value: 60,
		                	   color: '#0000FF'
		                	}, {
		                	   value: 89,
		                	   color: '#00FF00'
		                	}, {
		                	   color: '#FF0000'
		                	}]
		            }]
		        });
		    }
	});
		
	 }
	 atualizaGraficoChuva();
	 
	 function atualizaGraficoUmidade(){	
		 
		 $.ajax({
			    type: "GET",
			    url: "/historico/historicoUmidade",
			    data: "",
			    headers:createAuthorizationTokenHeader(),
			    dataType: "json",
			    success: function(data){		    	     
		          	  dataVector= [];
			          data.forEach(function(item, valor) {
			        	     cc =(item.dataHora+"").split(' ');		        	    
				    	     data=cc[0].split('-');
				    	     hora=cc[1].split(':');
				             t=Date.UTC( data[2],data[1]-1, data[0], hora[0], hora[1], hora[2]); 
			        	     dataVector.push([t,item.dado]);	                   
		              });
			          Highcharts.chart('container-umidade', {
			        	 chart: { 
			        		 reflow:true,
			        		 panning:true,
			        		 borderWidth: 1,
			                 renderTo: 'container-umidade',
			                 zoomType: 'xy',
			                 plotBorderWidth: 1,
			                 spacingLeft: 3,
			                 spacingRight: 3,
			                 spacingTop: 45,
			                 spacingBottom : 3,
			                 height : 400,
			                 resetZoomButton: {
			                     relativeTo: 'plot',
			                     position: {
			                         x: 3,
			                         y: 3,
			                         align: 'left'
			                     }
			                 }
				        },
			            title: {
			                text: 'Variação da Umidade'
			            },
			            subtitle: {
			                text: document.ontouchstart === undefined ?  'Clique e arraste para dar ZOOM' : 'Clique no gráfico para aumentar o ZOOM'
			            }, 
			             
			            xAxis: {
			                type: 'datetime',
			                dateTimeLabelFormats: { 		                	 
			                    second: '%H:%M:%S',
			                    minute: '%H:%M',
			                    hour: '%H:%M',
			                    day: '%e. %b',
			                    week: '%e. %b',
			                    month: '%b \'%y',
			                    year: '%Y'
			                },
			                labels: {
				                  format: "{value:%d-%m-%Y %H:%M:%S}" 
				            },
				            
			            }, 
			            yAxis: { 
			                title: {
			                    text: 'Umidade(%)' 
			                } ,
				            labels: {
				                format: '{value}%',
				                style: {
				                		color: Highcharts.getOptions().colors[1]
				                }
				            }
			            }    ,
			            tooltip: {
			            	headerFormat: '<b>{series.name}</b><br>',
			                formatter: function () {
			                    return '<b>' + this.series.name + '</b><br/>' +
			                        Highcharts.dateFormat('%d-%m-%Y %H:%M:%S', this.x) + '<br/>' +
			                        Highcharts.numberFormat(this.y, 1)+'%';
			                }
			            } ,
			            plotOptions: { 
			                area: {
			                    fillColor: {
			                        linearGradient: {
			                            x1: 0,
			                            y1: 1,
			                            x2: 0,
			                            y2: 1
			                        },
			                        stops: [
			                            [0, Highcharts.getOptions().colors[0]],
			                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
			                        ]
			                    },
			                    marker: {
			                        radius: 1
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
			            scrollbar: {
			                enabled: true,
			                height: 10,
			                barBorderWidth: 0,
			                buttonBorderWidth: 1,
			                trackBorderWidth: 1,
			                barBorderRadius: 3,
			                buttonBorderRadius: 3,
			                trackBorderRadius: 3
			            },           
			            series: [{ 
			            	 type: 'line',
			            	name: 'Umidade',
			                data: dataVector,
			                zones: [{
			                	   value: -35,
			                	   color: '#0000FF'
			                	},{
			                	   value: 60,
			                	   color: '#0000FF'
			                	}, {
			                	   value: 89,
			                	   color: '#00FF00'
			                	}, {
			                	   color: '#FF0000'
			                	}]
			            }]
			        });
			    }
		});
			
		 }
		 atualizaGraficoUmidade();
		 
		 function atualizaGraficoLuminosidade(){	
			 $.ajax({
				    type: "GET",
				    url: "/historico/historicoLuminosidade",
				    data: "",
				    headers:createAuthorizationTokenHeader(),
				    dataType: "json",
				    success: function(data){		    	     
			          	  dataVector= [];
				          data.forEach(function(item, valor) {
				        	     cc =(item.dataHora+"").split(' ');		        	    
					    	     data=cc[0].split('-');
					    	     hora=cc[1].split(':');
					             t=Date.UTC( data[2],data[1]-1, data[0], hora[0], hora[1], hora[2]); 
				        	     dataVector.push([t,item.dado]);	                   
			              });
				          Highcharts.chart('container-luminosidade', {
				        	 chart: { 
				        		 reflow:true,
				        		 panning:true,
				        		 borderWidth: 1,
				                 renderTo: 'container-luminosidade',
				                 zoomType: 'xy',
				                 plotBorderWidth: 1,
				                 spacingLeft: 3,
				                 spacingRight: 3,
				                 spacingTop: 45,
				                 spacingBottom : 3,
				                 height : 400,
				                 resetZoomButton: {
				                     relativeTo: 'plot',
				                     position: {
				                         x: 3,
				                         y: 3,
				                         align: 'left'
				                     }
				                 }
					        },
				            title: {
				                text: 'Variação da Luminosidade'
				            },
				            subtitle: {
				                text: document.ontouchstart === undefined ?  'Clique e arraste para dar ZOOM' : 'Clique no gráfico para aumentar o ZOOM'
				            }, 
				             
				            xAxis: {
				                type: 'datetime',
				                dateTimeLabelFormats: { 		                	 
				                    second: '%H:%M:%S',
				                    minute: '%H:%M',
				                    hour: '%H:%M',
				                    day: '%e. %b',
				                    week: '%e. %b',
				                    month: '%b \'%y',
				                    year: '%Y'
				                },
				                labels: {
					                  format: "{value:%d-%m-%Y %H:%M:%S}" 
					            },
					            
				            }, 
				            yAxis: { 
				                title: {
				                    text: 'Luminosidade(%)' 
				                } ,
					            labels: {
					                format: '{value}%',
					                style: {
					                		color: Highcharts.getOptions().colors[1]
					                }
					            }
				            }    ,
				            tooltip: {
				            	headerFormat: '<b>{series.name}</b><br>',
				                formatter: function () {
				                    return '<b>' + this.series.name + '</b><br/>' +
				                        Highcharts.dateFormat('%d-%m-%Y %H:%M:%S', this.x) + '<br/>' +
				                        Highcharts.numberFormat(this.y, 1)+'%';
				                }
				            } ,
				            plotOptions: { 
				                area: {
				                    fillColor: {
				                        linearGradient: {
				                            x1: 0,
				                            y1: 1,
				                            x2: 0,
				                            y2: 1
				                        },
				                        stops: [
				                            [0, Highcharts.getOptions().colors[0]],
				                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
				                        ]
				                    },
				                    marker: {
				                        radius: 1
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
				            scrollbar: {
				                enabled: true,
				                height: 10,
				                barBorderWidth: 0,
				                buttonBorderWidth: 1,
				                trackBorderWidth: 1,
				                barBorderRadius: 3,
				                buttonBorderRadius: 3,
				                trackBorderRadius: 3
				            },           
				            series: [{ 
				            	 type: 'line',
				            	name: 'Luminosidade',
				                data: dataVector,
				                zones: [{
				                	   value: -35,
				                	   color: '#0000FF'
				                	},{
				                	   value: 60,
				                	   color: '#0000FF'
				                	}, {
				                	   value: 89,
				                	   color: '#00FF00'
				                	}, {
				                	   color: '#FF0000'
				                	}]
				            }]
				        });
				    }
			});
				
			 }
			 atualizaGraficoLuminosidade();
 
});
