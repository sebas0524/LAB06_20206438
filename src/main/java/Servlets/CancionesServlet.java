package Servlets;

import Daos.CancionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CancionesServlet", value = "/listaCanciones")
public class CancionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionDao cancionDao = new CancionDao();
        String id = request.getParameter("idBanda");
        if(id==null) {
            request.setAttribute("listaTodasCanciones", cancionDao.listaTodasCanciones());
            request.getRequestDispatcher("listaCanciones.jsp").forward(request, response);
        }
        else{
            request.setAttribute("listaCancBanda", cancionDao.listaCancionesBanda(id));
            request.getRequestDispatcher("listaCancionesBanda.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
