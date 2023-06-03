<%@ page import="Beans.Tour" %>
<%@ page import="Beans.Cancion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  ArrayList<Cancion> listaCanciones = (ArrayList<Cancion>) request.getAttribute("listaTodasCanciones");
%>
<html>
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Lista de Canciones"/>
</jsp:include>
<body>
<div class='container'>
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="canciones"/>
  </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor">
    <div class="col-lg-6">
      <h1 class='text-light'>Lista de Canciones</h1>
    </div>
  </div>
  <div class="tabla">
    <table class="table table-dark table-transparent table-hover">
      <thead>
      <th>ID</th>
      <th>CANCION</th>
      <th>BANDA</th>
      </thead>
      <%
        for (Cancion cancion : listaCanciones) {
      %>
      <tr>
        <td><%=cancion.getIdCancion()%>
        </td>
        <td><%=cancion.getNombre_cancion()%>
        </td>
        <td><%=cancion.getBanda()%>
        </td>
        <!--<td>
        //Con este comando tendria que haberme mostrado las canciones favoritas
          if(cancion.getCancionesFavoritas() == false){
          <form action="<request.getContextPath()%>/AgregarCancionesFavoritasServlet" method="POST">
            <input type="hidden" name="idCancion" value="<cancion.getCancionesFavoritas()%>">
            <input class="btn btn-warning" type="submit" value="Agregar a Canciones favoritas">
          </form>
          }else {
          <form action="listaCancionesFavoritas.jsp" method="POST">
            <input type="hidden" name="idCancion" value="<cancion.getCancionesFavoritas()%>">
            <input class="btn btn-light" type="submit" value="Favoritas">
          </form>
          }%>
        </td>
        -->


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
