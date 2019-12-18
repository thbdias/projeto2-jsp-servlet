<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Página Pai</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<h1>Página Pai load jQuery</h1>
	
	<input type="button" value="Carregar página filha" onclick="carregar();">
	
	<div id="mostrarPaginaFilha"></div> <!-- local de carregamento da pagina filha -->
	
</body>


<script type="text/javascript">
	function carregar() {
		$("#mostrarPaginaFilha").load('paginaFilha.jsp'); //load página em jQuery
	}
</script>

</html>