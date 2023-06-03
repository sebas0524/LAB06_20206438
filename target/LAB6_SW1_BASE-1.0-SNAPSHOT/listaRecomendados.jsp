<%@ page import="Beans.Tour" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  ArrayList <Cancion> listaRecomendadas = (ArrayList<Cancion>) request.getAttribute("listaCancionesRecomendadas");
%>
<html>
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Lista de Canciones Recomendadas"/>
</jsp:include>
<body>
<div class='container'>
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="recomendados"/>
  </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor">
    <div class="col-lg-6">
      <h1 class='text-light'>Lista de Canciones Recomendadas</h1>
    </div>
  </div>
  <div class="tabla">
    <table class="table table-dark table-transparent table-hover">
      <thead>
      <th>ID</th>
      <th>CANCION</th>
      <th>BANDA</th>
      <th>Ver</th>

      </td>
      </thead>
      <%
        for (Cancion cancionRecomendada : listaRecomendadas) {
      %>
      <tr>
        <td><%=cancionRecomendada.getIdCancion()%>
        </td>
        <td><%=cancionRecomendada.getNombre_cancion()%>
        </td>
        <td><%=cancionRecomendada.getBanda()%>
        </td>
        <td><a class="btn btn-success" href="<%=request.getContextPath()%>/listaCanciones?idBanda=<%=cancionRecomendada.getBanda()%>">Más de la banda</a>
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
