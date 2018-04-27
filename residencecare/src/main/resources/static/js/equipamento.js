$( document ).ready(function() {
	
	function atualizarStatus(){
		$.ajax({
		    type: "GET",
		    url: "/equipamento/status",
		    data: "",
		    dataType: "json",
		    success: function(json){
		    	
		    	  obj=eval(json);
		    	  $("#rele1").prop("checked", obj.porta1);
		    	  $("#rele2").prop("checked", obj.porta2);
		    	  $("#rele3").prop("checked", obj.porta3);
		    	  $("#rele4").prop("checked", obj.porta4);
		    	  $("#rele5").prop("checked", obj.porta5);
		    	  $("#rele6").prop("checked", obj.porta6);
		    	  $("#rele7").prop("checked", obj.porta7);
		          $("#rele8").prop("checked", obj.porta8);		            
		        }
		     
		 });	 
	}
	atualizarStatus();
	$("#rele1").click(function() {
		//if(!confirm("Deseja realmente desligar o equipamento?")) return;
		//valor botao
		//confirm
		//requisição
		 
		$.ajax({
		    type: "POST",
		    url: "/equipamento/alterarRele",
		    data: "idControleEstado=1&numeroRele=1&valor="+$("#rele1").prop( "checked" ),
		    dataType: "json",
		    success: function(json){
		    	  atualizarStatus();		    	              
		        }		     
		 });	 
		
	});
});