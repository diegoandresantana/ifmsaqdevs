  $( document ).ready(function() {
	
	function atualizarStatus(){
		$.ajax({
		    type: "GET",
		    url: "/arduino/status",
		    data: "",
		    dataType: "json",
		    headers:createAuthorizationTokenHeader(),
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
		          $("#prevencaoAtiva").prop("checked", obj.prevencaoAtiva);	
		          
		        }
		     
		 });	 
	}
	atualizarStatus();
	$("#rele1").click(function() {
		 
		$.ajax({
		    type: "POST",
		    url: "/equipamento/alterarRele",
		    data: "idControleEstado=1&numeroRele=1&valor="+$("#rele1").prop( "checked" ),
		    headers:createAuthorizationTokenHeader(),
		    dataType: "json",
		    success: function(json){
		    	  atualizarStatus();		    	              
		        }		     
		 });	 
		
	});
	$("#rele2").click(function() {
		 
		 
		$.ajax({
		    type: "POST",
		    url: "/equipamento/alterarRele",
		    data: "idControleEstado=1&numeroRele=2&valor="+$("#rele2").prop( "checked" ),
		    headers:createAuthorizationTokenHeader(),
		    dataType: "json",
		    success: function(json){
		    	  atualizarStatus();		    	              
		        }		     
		 });	 
		
	});
	$("#rele3").click(function() {
	 
		 
		$.ajax({
		    type: "POST",
		    url: "/equipamento/alterarRele",
		    data: "idControleEstado=1&numeroRele=3&valor="+$("#rele3").prop( "checked" ),
		    dataType: "json",
		    headers:createAuthorizationTokenHeader(),
		    success: function(json){
		    	  atualizarStatus();		    	              
		        }		     
		 });	 
		
	});
	$("#rele4").click(function() {
		 
		$.ajax({
		    type: "POST",
		    url: "/equipamento/alterarRele",
		    data: "idControleEstado=1&numeroRele=4&valor="+$("#rele4").prop( "checked" ),
		    dataType: "json",
		    headers:createAuthorizationTokenHeader(),
		    success: function(json){
		    	  atualizarStatus();		    	              
		        }		     
		 });	 
		
	});
	$("#rele5").click(function() {
		 
		 
		$.ajax({
		    type: "POST",
		    url: "/equipamento/alterarRele",
		    data: "idControleEstado=1&numeroRele=5&valor="+$("#rele5").prop( "checked" ),
		    dataType: "json",
		    headers:createAuthorizationTokenHeader(),
		    success: function(json){
		    	  atualizarStatus();		    	              
		        }		     
		 });	 
		
	});
	$("#rele6").click(function() {
		 
		 
		$.ajax({
		    type: "POST",
		    url: "/equipamento/alterarRele",
		    data: "idControleEstado=1&numeroRele=6&valor="+$("#rele6").prop( "checked" ),
		    dataType: "json",
		    headers:createAuthorizationTokenHeader(),
		    success: function(json){
		    	  atualizarStatus();		    	              
		        }		     
		 });	 
		
	});
	$("#rele7").click(function() {
		 
		 
		$.ajax({
		    type: "POST",
		    url: "/equipamento/alterarRele",
		    data: "idControleEstado=1&numeroRele=7&valor="+$("#rele7").prop( "checked" ),
		    dataType: "json",
		    headers:createAuthorizationTokenHeader(),
		    success: function(json){
		    	  atualizarStatus();		    	              
		        }		     
		 });	 
		
	});
	$("#rele8").click(function() { 
		 
		$.ajax({
		    type: "POST",
		    url: "/equipamento/alterarRele",
		    data: "idControleEstado=1&numeroRele=8&valor="+$("#rele8").prop( "checked" ),
		    dataType: "json",
		    headers:createAuthorizationTokenHeader(),
		    success: function(json){
		    	  atualizarStatus();		    	              
		        }		     
		 });	 
		
	});
	$("#prevencaoAtiva").click(function() { 
		 
		$.ajax({
		    type: "POST",
		    url: "/equipamento/ativarDesativarPrevencao",
		    data: "idControleEstado=1&prevencaoAtiva="+$("#prevencaoAtiva").prop( "checked" ),
		    dataType: "json",
		    headers:createAuthorizationTokenHeader(),
		    success: function(json){
		    	  atualizarStatus();		    	              
		        }		     
		 });	 
		
	});
});