<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>P�gina Pai</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<h1>P�gina Pai load jQuery</h1>
	
	<input type="button" value="Carregar p�gina filha" onclick="carregar();">
	
	<div id="mostrarPaginaFilha"></div> <!-- local de carregamento da pagina filha -->
	
</body>


<script type="text/javascript">
	function carregar() {
		$("#mostrarPaginaFilha").load('paginaFilha.jsp'); //load p�gina em jQuery
	}
</script>

</html>