package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuario;
import entidades.Usuario;

@WebServlet("/pages/carregarDadosDataTableServlet")
public class ServletCarregarDadosDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoUsuario daoUsuario = new DaoUsuario();
       
    public ServletCarregarDadosDataTable() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Usuario> usuarios = daoUsuario.getUsuarios();
			
			if (!usuarios.isEmpty()) {
				
				String data = "";
				int totalUsuarios = usuarios.size();
				int index = 1;
				
				for (Usuario usuario: usuarios) {
					
					data += "[ " +
						      "\""+usuario.getId()+"\", " +
						      "\""+usuario.getLogin()+"\" " +
						    "]" ;
					
					if (index < totalUsuarios) {
						data += ", ";
					}
					
					index++;
					
				}//end for
				
				
				String json = "{" + 
							  "\"draw\": 1, " +
							  "\"recordsTotal\": "+usuarios.size()+", " +
							  "\"recordsFiltered\": "+usuarios.size()+", " +
							  "\"data\": [ " +
							  
							  	//inicio - processa a lisata de dados						  							    							      
							    data +							    
							    //fim  
							      
							  "] " +
							"} ";
			
				response.setStatus(200); //resposta completa ok
				response.getWriter().write(json); //json de resposta (escreve a resposta Http)
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
