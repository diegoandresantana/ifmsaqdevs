$( document ).ready(function() {//documento estiver pronto
	    form="formMensagem";//id do formulario
	    
	    $("#btnEnviar").click(function() {
	    	if(!confirm("Deseja confirmar o envio?")) 
	    		return;
	    	 
	    	  parametros=$("#"+form).serialize();			    
		       $.ajax({
		           type: "POST", 
		           url:  "/index/mensagem/salvar",
		           data:  parametros, // serializes the form's elements.
		           success: function(resultado)
		           { 
		        	   alert(resultado);
		        	   $("#"+form)[0].reset();//clean	
		        	                  
		           }
		         });
	    });
	    
	    $("#celular").mask("(999)99999-9999");
	    
});	    