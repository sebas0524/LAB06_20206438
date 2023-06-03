package Servlets;

import Beans.Cancion;
import Daos.CancionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AgregarCancionesFavoritasServlet", value = "/AgregarCancionesFavoritasServlet")
public class AgregarCancionesFavoritasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionDao cancion=new CancionDao();
        String idCancion=request.getParameter("idCancion");
        cancion.actualizarCancion(idCancion);
        response.sendRedirect(request.getContextPath() + "listaCanciones");
    }
}
