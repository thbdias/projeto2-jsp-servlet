<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

	<h1>Upload </h1>
	
	<input type="file" id="file" name="file" onchange="uploadFile();">
	
	<img alt="imagem" src="" id="target" width="200" height="200">

</body>

<script type="text/javascript">
	function uploadFile() {	
		var target = document.querySelector("img");
		var file = document.querySelector("input[type=file]").files[0];
		
		var reader = new FileReader();
		
		reader.onloadend = function () {
			target.src = reader.result;
			
			//upload ajax
			$.ajax({
				method: "POST",
				url: "fileUpload", //para qual servlet? 
				data: { fileUploadParam: reader.result }
			})
			.done(function (response) {
				alert("sucesso: " + response);
			})
			.fail(function (xhr, status, errorThrown) {
				alert("erro: " + xhr.responseText); //mostra resposta do servidor
			});			
			//upload ajax fim
		};
		
		
		if (file){
			reader.readAsDataURL(file);
		}
		else {
			target.src = "";
		}
	}
</script>

</html>