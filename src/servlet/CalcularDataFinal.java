package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCalculaDataFinal;

@WebServlet("/pages/calcularDataFinal")
public class CalcularDataFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoCalculaDataFinal daoCalculaDataFinal = new DaoCalculaDataFinal();
       
    public CalcularDataFinal() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//08:00 - 12:00 e 13:30 - 17:30
		//1 dia � igual a 8 horas
		
		try {
			
			int horaDia = 8;
			Double totalDeDias = 0.0;
			Date dataCalculada = null;
			String data = request.getParameter("data");
			int tempo = Integer.parseInt(request.getParameter("tempo"));
			
			if (tempo <= horaDia) {
				dataCalculada = new SimpleDateFormat("dd/MM/yyyy").parse(data);			
			}
			else {				
				totalDeDias = (double) (tempo/horaDia);
				
				if (totalDeDias <= 1) {
					Date dateInformada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
					Calendar calendar = Calendar.getInstance();
					
					calendar.setTime(dateInformada);
					calendar.add(Calendar.DATE, 1);
					
					dataCalculada = calendar.getTime();
					totalDeDias = 1.0;
				}
				else {
					Date dateInformada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
					Calendar calendar = Calendar.getInstance();
					
					calendar.setTime(dateInformada);
					calendar.add(Calendar.DATE, totalDeDias.intValue());
					
					dataCalculada = calendar.getTime();
				}				
			}
			
			daoCalculaDataFinal.gravaDataFinal(new SimpleDateFormat("dd/MM/yyyy").format(dataCalculada));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/datas.jsp");
			request.setAttribute("dataFinal", new SimpleDateFormat("dd/MM/yyyy").format(dataCalculada));
			request.setAttribute("dias", totalDeDias);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
