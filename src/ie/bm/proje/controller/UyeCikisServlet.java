package ie.bm.proje.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ie.bm.proje.database.Database;
import ie.bm.proje.view.Kullanici;

@WebServlet("/UyeCikisServlet")
public class UyeCikisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.kullaniciOffline(Kullanici.getSkullaniciadi());
		//Kullanici.setSdurum(false);
		request.getSession().invalidate();
		request.getSession().removeAttribute("kullanici");
		response.sendRedirect("login.jsp");
	}

}
