package Daos;

import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class CancionDao {

    public ArrayList<Cancion> listaCancionesRecomendadas(){
        ArrayList<Cancion> listaCancion=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select count(*),cancion_idcancion from lab6sw1.reproduccion\n" +
                "        group by cancion_idcancion\n" +
                "        having count(*) > 2\n" +
                "        order by count(*) desc";
        String url = "jdbc:mysql://localhost:3306/lab6sw1";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Cancion cancion = new Cancion();
                cancion.setIdCancion(resultSet.getInt(1));
                cancion.setNombre_cancion(resultSet.getString(2));
                cancion.setBanda(resultSet.getString(3));
                listaCancion.add(cancion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCancion;

    }

}
