<%@ page import="Beans.Tour" %>
<%@ page import="Beans.Cancion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  ArrayList<Cancion> listaCancionesBanda = (ArrayList<Cancion>) request.getAttribute("listaCancBanda");
%>
<html>
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Lista de Canciones por Banda"/>
</jsp:include>
<body>
<div class='container'>
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="canciones"/>
  </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor">
    <div class="col-lg-6">
      <h1 class='text-light'>Lista de Canciones por Banda</h1>
    </div>
    <div style="text-align: right;">
      <a class="btn btn-warning" href="<%=request.getContextPath()%>/listaCanciones">Mostrar todas las canciones</a>
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
        for (Cancion cancion : listaCancionesBanda) {
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
