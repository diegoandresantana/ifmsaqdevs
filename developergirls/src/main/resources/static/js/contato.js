$( document ).ready(function() {//documento estiver pronto
	    
	    function validarForm(){			   
			  var form= $("#formMensagem");
			  form.validate({
				   rules: {
					   nome:{
		                     required:true,
		                     minlength:3
		              },
		              email:{
		                     required:true
		              },
		              celular:{
		                     required:true
		              },
		              texto:{
		                     required:true
		              } 
				   },
				   messages: {
					   nome:{
		                     required:"Por favor, informe seu nome.",
							 minlength: "Informe um nome com mais de 3 letras."
		              },
		              email:{
		                     required:"É necessário informar um email."
		              },
		              celular:{
		                     required:"É necessário informar o número do celular."
		              },
		              texto:{
		                     required:"A mensagem não pode ficar em branco."
		              }    
				   },
				   tooltip_options: {
					   nomeCidade: {trigger: 'focus',placement: 'right'}
				   } 
			        
			   });
		  return form.valid(); 
	   }
	    
	  
	    $("#btnEnviar").click(function() {
	    	if(!confirm("Deseja confirmar o envio?")) 
	    		return;
	    	  if(!validarForm())
		    	return ;
	    	  
	    	   parametros=$("#formMensagem").serialize();			    
		       $.ajax({
		           type: "POST", 
		           url:  "/index/mensagem/salvar",
		           data:  parametros, // serializes the form's elements.
		           success: function(resultado)
		           { 
		        	   alert(resultado);
		        	   $("#formMensagem")[0].reset();//clean	
		        	                  
		           }
		         });
	    });
	    
	    $("#celular").mask("(999)99999-9999");
	    
});	    