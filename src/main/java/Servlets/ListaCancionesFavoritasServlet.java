package Servlets;

import Daos.CancionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ListaCancionesFavoritasServlet", value = "/ListaCancionesFavoritasServlet")
public class ListaCancionesFavoritasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CancionDao cancion =new CancionDao();
        request.setAttribute("listaFavoritas", cancion.listarCancionesFavoritas());
        request.getRequestDispatcher("listaCancionesFavoritas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
