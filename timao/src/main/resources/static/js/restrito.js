 token=localStorage.getItem("jwtToken") ; 
			 if(token==null || token==""){
				 window.location="/login.html";	 	 
			 }
 function createAuthorizationTokenHeader() {    
	 if (token) {
		return {"Authorization": "Bearer " + token};
	 } else {
		return {};
	}
  }
 function removeJwtToken() {
     localStorage.removeItem("jwtToken");
     window.location="/login.html";	 
 }		 
 function showUserInformation() {
     $.ajax({
         url: "/user",
         type: "GET",
         contentType: "application/json; charset=utf-8",
         dataType: "json",
         headers: createAuthorizationTokenHeader(),
         success: function (data, textStatus, jqXHR) {
              $("#usuario").text(data.nome+" "+data.sobrenome);
 
         }
     });
 }