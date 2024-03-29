package filter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import connection.ConnectionDataBase;
import user.UserLogado;

@WebFilter(urlPatterns = {"/pages/*"})
public class FilterAutenticacao implements Filter {
	
	private static Connection connection;
	
	//faz alguma coisa quando a aplicacao � derrubada
	@Override
	public void destroy() {		
	}

	// intercepta todas as requisi��es
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		//url que estou tentando acessar
		String urlParaAutenticar = req.getServletPath();
		
		//retorna null caso n�o esteja logado
		UserLogado userLogado = (UserLogado) session.getAttribute("usuario");
		
		//usuario n�o logado
		if (userLogado == null && !urlParaAutenticar.equalsIgnoreCase("/pages/serviletAutenticacao")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/autenticar.jsp?url="+urlParaAutenticar);
			dispatcher.forward(request, response);
			
			return; // para o processo para redirecionar
		}
		
		chain.doFilter(request, response); //executa as acoes do request e response
	}


	// executa alguma coisa quando a aplicacao � iniciada
	@Override
	public void init(FilterConfig arg0) throws ServletException {		
		connection = ConnectionDataBase.getConnection();
	}
	
}
