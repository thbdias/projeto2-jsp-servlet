package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserLogado;

@WebServlet("/pages/serviletAutenticacao")
public class ServiletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServiletAutenticacao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url= request.getParameter("url");
		
		// neste momento pode ser feito uma validação no bando de dados
		if (login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("123")) {
			// se o login foi bem sucedido			

			UserLogado user = new UserLogado();
			user.setLogin(login);
			user.setSenha(senha);
			
			//setar usuario na sessao
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.setAttribute("usuario", user);
			
			//redireciona para o sistema autorizar
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		else {
			//se o login falou redireciona para login novamente
			RequestDispatcher dispatcher = request.getRequestDispatcher("/autenticar.jsp");
			dispatcher.forward(request, response);
		}
	}

}
