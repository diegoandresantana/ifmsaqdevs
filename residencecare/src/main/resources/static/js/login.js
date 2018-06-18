$(document).ready(function ( ) {
	     var TOKEN_KEY = "jwtToken";
		 function getJwtToken() {
	        return localStorage.getItem(TOKEN_KEY);
	    }

	    function setJwtToken(token) {
	        localStorage.setItem(TOKEN_KEY, token);
	    }

	    function removeJwtToken() {
	        localStorage.removeItem(TOKEN_KEY);
	    }
		$("#loginForm").submit(function (event) {
		        event.preventDefault();
		        var $form = $(this);
		        var formData = {
		            username: $form.find('input[name="username"]').val(),
		            password: $form.find('input[name="password"]').val()
		        };
		        doLogin(formData);
		    });
			 function doLogin(loginData) {
			        $.ajax({
			            url: "/auth",
			            type: "POST",
			            data: JSON.stringify(loginData),
			            contentType: "application/json; charset=utf-8",
			            dataType: "json",
			            success: function (data, textStatus, jqXHR) {
			                console.log(data);
			                setJwtToken(data.token);
			                if(data.token==null ||  data.token==""){
			                	 alert("Login ou senha estão incorretos");
			                }else{
			                	alert("Logado com sucesso!");
			                	window.location="/admin/dashboard.html";
			                	
			                }
			            },
			            error: function (jqXHR, textStatus, errorThrown) {
			                alert("Login ou senha estão incorretos");
			            }
			        });
			    }
		 
});
