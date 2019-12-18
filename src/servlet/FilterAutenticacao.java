package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/*"})
public class FilterAutenticacao implements Filter {
	
	//faz alguma coisa quando a aplicacao é derrubada
	@Override
	public void destroy() {		
	}

	// intercepta todas as requisições
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		chain.doFilter(request, response); //executa as acoes do request e response
	}


	// executa alguma coisa quando a aplicacao é iniciada
	@Override
	public void init(FilterConfig arg0) throws ServletException {		
	}
	
}
