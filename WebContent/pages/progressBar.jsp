<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Barra de progresso</title>
	<style type="text/css">
		#myProgress{
			width: 100%;
			background-color: #ddd;
		}		
		#myBar{
			width: 0.5%;
			height: 30px;
			background-color: #4CAF50; 			
		}
	</style>
</head>
<body>
	<h1>Exemplo com java script</h1>
		
	<div id="myProgress">
		<div id="myBar">
		</div>
	</div>
	<br>
	<button onclick="exibirBarra()">Iniciar a barra de progresso</button>
</body>

<script type="text/javascript">
	function exibirBarra() {
		var elem = document.getElementById("myBar");
		var width = 1;
		var id = setInterval(frame, 10);
		
		function frame() {
			if (width >= 100){
				clearInterval(id);
			}
			else{
				width++;
				elem.style.width = width + "%"; 
			}
		}
	}
</script>
</html>