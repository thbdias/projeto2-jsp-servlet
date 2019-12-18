<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Barra de progresso</title>
	
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css">
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
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
		.ui-progressbar{
			position: relative;
		}
		.progress-label{
			position: relative;
			left: 50%;
			top: 4px;
			font-weight: bold;
			text-shadow: 1px 1px 0 #fff; 
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
	
	<br> <br> <br> <br>
	<h1>Barra de progresso com jQuery</h1>
	
	<div id="progressbar">
		<div class="progress-label">
			Carregando...
		</div>
	</div>
	
</body>

<script type="text/javascript">
	//script para barra de progresso por javascript
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
	
	//script para barra de progresso por jQuery
	$(function () {
		var progressbar = $("#progressbar");
		var progresslabel = $(".progress-label");
		
		progressbar.progressbar({ //cria a barra no div
			value : false,
			change : function () {
				progresslabel.text(progressbar.progressbar('value') + "%");
			},
			complete: function () {
				progresslabel.text('Completo!');
			}
		});
		
		function progress() {
			var val = progressbar.progressbar("value") || 0;
			
			progressbar.progressbar("value", val + 2);
			
			if (val < 99){
				setTimeout(progress, 80);
			}
		}
		
		setTimeout(progress, 2000); //chamado ao abrir a tela
	});
</script>
</html>