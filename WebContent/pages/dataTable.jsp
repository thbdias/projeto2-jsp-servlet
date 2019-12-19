<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	
	<link rel="stylesheet" href="http://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="http://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	
			
</head>
<body>
	<h1>DataTable jQuery</h1>
	<br> <br>
	
	<table id="minhatabela" class="display" style="width:100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Login</th>
            </tr>
        </thead>
                
    </table>
</body>

<script type="text/javascript">
	$(document).ready(function() {
	    $('#minhatabela').DataTable( {
	        "processing": true,
	        "serverSide": true,
	        "ajax": "carregarDadosDataTableServlet" // URL retorno dos dados do servidor (Resposta do servidor)
	    } );
	} );
</script>

</html>














