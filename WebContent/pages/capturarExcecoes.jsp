<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Capturando Exce��es</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<h3>Capturando Exce��es com JQuery</h3>
	
	<input type="text" value="valor informado" id="txtvalor">
	<input type="button" onclick="testarExcecao();" value="Testar Exce��o">
</body>

<script type="text/javascript">
	function testarExcecao() {
		alert($('#txtvalor').val());
	}
</script>
</html>