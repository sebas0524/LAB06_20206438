<%--
  Created by IntelliJ IDEA.
  User: sebas
  Date: 3/06/2023
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.Tour" %>
<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaFavoritas"/>
<html>
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista de Canciones Favoritas"/>
</jsp:include>
<body>
<div class='container'>
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="favoritos"/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor">
        <div class="col-lg-6">
            <h1 class='text-light'>Canciones Favoritas</h1>
        </div>
    </div>
    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <th>ID</th>
            <th>TOUR</th>
            <th>BANDA</th>
            </thead>
            <%
                for (Cancion cancion : listaFavoritas) {
            %>
            <tr>
                <td><%=cancion.getIdCancion()%>
                </td>
                <td><%=cancion.getNombre_cancion()%>
                </td>
                <td><%=cancion.getBanda()%>
                </td>

            </tr>
            <%
                }
            %>
        </table>
    </div>

</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
