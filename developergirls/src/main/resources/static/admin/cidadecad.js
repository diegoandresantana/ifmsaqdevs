$( document ).ready(function() {//documento estiver pronto
	    form="formCidade";//id do formulario
	    controller="cidadecontroller?";//controller que será enviados os dados
	    id="idCidade"; //idEstado
	    dataTableID="dataTableCidade";	
	    
	    
	    function ctrBotoes(incluir){/*função para controlar os botões*/
			$( "#btnIncluir" ).prop( "disabled",!incluir);
			$( "#btnAlterar" ).prop( "disabled", incluir);
			$( "#btnDeletar" ).prop( "disabled", incluir);
			$( "#btnIncluir" ).css( "display", (incluir)?"":"none" );
			$( "#btnAlterar" ).css( "display", (!incluir)?"":"none" );
			$( "#btnDeletar" ).css( "display", (!incluir)?"":"none"  );
			
    	}
	    ctrBotoes(true);
	    $("#btnLimpar").click(function() {
	    	 $("#"+form)[0].reset();//clean	    
	    	 ctrBotoes(true);//controla os botoes
	     });
	    $("#btnAlterar").click(function() {
	    	if(!confirm("Deseja realmente alterar?")) 
	    		return;
	    	parametros="acao=alterar&"+$("#"+form).serialize();			    
		       $.ajax({
		           type: "POST", 
		           url: controller,
		           data:  parametros, // serializes the form's elements.
		           success: function(resultado)
		           { 
		        	   if(resultado=="OK"){
		        		   alert("Alterado com sucesso!!");
		        		   $("#"+form)[0].reset();//clean	
		        		   recarregarDataTable();//recarregar a grid
		        		   ctrBotoes(true);//controle de botoes
		        	   }else if(resultado=="ERRO"){
		        		   alert("Não foi possível alterar!!");
		        	   }		               
		           }
		         });
	    });
	    
	    $("#btnDeletar").click(function() {
	    	if(!confirm("Deseja realmente deletar?")) return;
	    	
	    	parametros="acao=deletar&"+$("#"+form).serialize();			    
		       $.ajax({
		           type: "POST", 
		           url: controller,
		           data:  parametros, // serializes the form's elements.
		           success: function(resultado)
		           { 
		        	   if(resultado=="OK"){
		        		   alert("Deletado com sucesso!!");
		        		   $("#"+form)[0].reset();//clean	
		        		   recarregarDataTable();//recarregar a grid
		        		   ctrBotoes(true);//controle de botoes
		        	   }else if(resultado=="ERRO"){
		        		   alert("Não foi possível deletar!!");
		        	   }		               
		           }
		         });	
	    }); 
		$("#btnIncluir").click(function() {
			parametros="acao=incluir&"+$("#"+form).serialize();
			 
			$.ajax({
		           type: "POST", 
		           url: controller,
		           data:  parametros, // serializes the form's elements.
		           success: function(resultado)
		           { 
		        	   if(resultado=="OK"){
		        		   alert("Incluído com sucesso!!");
		        		   $("#"+form)[0].reset();//clean	
		        		   recarregarDataTable();//recarregar a grid
		        		   ctrBotoes(true);//controle de botoes
		        	   }else if(resultado=="ERRO"){
		        		   alert("Não foi possível incluir!!");
		        	   }		               
		           }
		         });
		});	
	    //datatable
		//Grid datatable
	       //Grid			 
	       // prepare the data
	       var source =
	           {
	               dataType: "json",
	               dataFields: [
	                   { name: 'idCidade', type: 'int' },
	                   { name: 'nomeCidade', type: 'string'  },
	                   { name: 'estado', type: 'string' ,map: 'estado>sigla' }	                 
	               ],
	               id: id,
	               url: controller+"acao=listar"
	           };
	           var dataAdapter = new $.jqx.dataAdapter(source);
	           $("#"+dataTableID).jqxDataTable(
	           {
	               width: "100%" ,
	               pageable: true,
	               sortable: true,
	               pagerButtonsCount: 10,
	               source: dataAdapter,
	               columnsResize: true,
	               columns: [
					  { text: 'ID', dataField: 'idCidade',cellsalign: 'right', width:"25%" },
	                 { text: 'Nome', dataField: 'nomeCidade', width: "50%" },
	                 { text: 'Estado', dataField:  'estado', width:  "25%"}                 
	             ]
	           });	
	           $("#"+dataTableID).on('rowSelect', function (event) {
	              	var args = event.args;// event arguments
	              	//parametros de busca	              	 
	                  parametros="acao=buscarid&"+id+"="+args.row.idCidade;	  //dentro da variavel row tem o idEstado               
	              	//requisição para buscar dados
	                  $.ajax({
	   			           type: "POST",
	   			           url: controller,
	   			           data:  parametros, // serializes the form's elements.
	   			           success: function(data)
	   			           { 
	   			        	   ctrBotoes(false);	
	   			        	   objJson=eval('('+data+')');		   			        	    
	   			        	   $("#"+form).deserialize(objJson)	;
	   			        	  $("#estado\\.idEstado").val(objJson.estado.idEstado).change();
	   			        	   $("#"+form+" #"+id).focus();
	   			           }
	   			         });
	              });
	           
	           //carrega o combo de estado		 
	           $.ajax({
	                type: "GET",
	                url: "estadocontroller?",
	                data: "acao=listar",
	                dataType: "json",
	                success: function(json){
	                   var options = "<option value=''>Selecione....</option>";
	                   $.each(json, function(key, value){
	                	   
	                      options += '<option value="' + value.idEstado + '">' + value.sigla + '</option>';
	                   });
	                   $("#estado\\.idEstado").html(options);
	                }
	             });
	         function  recarregarDataTable(){
					 $("#"+dataTableID).jqxDataTable('updateBoundData');
			 }
});	    