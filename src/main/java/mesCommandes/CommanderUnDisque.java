package mesCommandes;

import java.io.IOException;
import  java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.parser.Cookie;

/**
 * Servlet implementation class CommanderUnDisque
 */
@WebServlet("/commande")
public class CommanderUnDisque extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
			String nom = null;
			int nbreProduit = 0;
			javax.servlet.http.Cookie[] cookies = request.getCookies();
			nom = Identification.chercheNom(cookies);
			 response.setContentType("text/html");
			 PrintWriter out = response.getWriter();
			 out.println("<html>");
			 out.println("<body>");
			 out.println("<head>");
			 out.println("<title> votre commande </title>");
			 out.println("</head>");
			 out.println("<body bgcolor=\"white\">");
			 out.println("<h3>" + "Bonjour "+ nom + " voici votre commande" + "</h3>");
			 
			// affichage de tous les disques pr�sents dans le panier (�l�ments de la session)
			// si parametre ordre == ajouter affichage du disque � ajouter au panier
			// ajout du nouveau disque dans le panier
			 HttpSession session = request.getSession();
			 Enumeration names = session.getAttributeNames();
			 if(!names.hasMoreElements()) {
				 out.println("<p> Panier vide</p>");
			 }
			 while (names.hasMoreElements()) {
			 nbreProduit++;
			 String name = (String) names.nextElement();
			 String value = session.getAttribute(name).toString();
			 out.println(name + " = " + value + "<br>");}
			 
			 out.println("<p>code :"+request.getParameter("code")+ "</p><br>");
				
			 if(request.getParameter("ordre").equals("ajouter")) {
				 out.println("<p>code :"+request.getParameter("code")+ "</p><br>");}
				 session.setAttribute("produit_"+nbreProduit, request.getParameter("code"));
				 
			out.println("<A HREF=achat> Vous pouvez commandez un autre disque </A><br> ");
			 out.println("<A HREF=enregistre> Vous pouvez enregistrer votre commande </A><br> ");
			 out.println("</body>");
			 out.println("</html>");
			}
			public void doPost(HttpServletRequest request,
			 HttpServletResponse response)
			throws IOException, ServletException
			 {
			 doGet(request, response);
			 }
	
}
