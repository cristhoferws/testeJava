package controle;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import dao.daoProduto;
import dao.daoProduto;
import model.Produto;

/**
 * Servlet implementation class cadastraProduto
 */
@WebServlet("/cadastraProduto")
public class cadastraProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastraProduto() {
        super();
        
     
        
        
        
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		   String nome = request.getParameter("nome");
	      System.out.println(nome); 
	      
		   Produto produto = new Produto();
		   produto.setNome(nome);
		   String msn = "";
		   
		   try {
				daoProduto cdao = new daoProduto();
				msn = cdao.InsereProduto(produto);
			} catch (Exception e) {
				msn = e.getMessage();
			}
			response.sendRedirect("index.jsp?msn="+msn);			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
