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

        String sql = "select c.* \n" +
                "from reproduccion r inner join cancion c ON (c.idcancion=r.cancion_idcancion)\n" +
                "group by cancion_idcancion \n" +
                "having count(*) > 2 \n" +
                "order by count(*) desc;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
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
    public ArrayList<Cancion> listaTodasCanciones(){
            ArrayList<Cancion> listaTodasCan=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM cancion;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Cancion cancion = new Cancion();
                cancion.setIdCancion(resultSet.getInt(1));
                cancion.setNombre_cancion(resultSet.getString(2));
                cancion.setBanda(resultSet.getString(3));
                listaTodasCan.add(cancion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTodasCan;

    }
    public ArrayList<Cancion> listaCancionesBanda (String id) {
        ArrayList<Cancion> listaCancBanda=new ArrayList<>();
        //Cancion cancion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "select * from cancion where banda = ?";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Cancion cancion= new Cancion();
                    cancion.setIdCancion(Integer.parseInt(rs.getString(1)));
                    cancion.setNombre_cancion(rs.getString(2));
                    cancion.setBanda(rs.getString(3));
                    listaCancBanda.add(cancion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCancBanda;
    }
    public ArrayList<Cancion> listarCancionesFavoritas(){
        ArrayList<Cancion> listaCancionesFavoritas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM cancion where cancionesfavoritas=1;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Cancion cancion = new Cancion();
                cancion.setIdCancion(resultSet.getInt(1));
                cancion.setNombre_cancion(resultSet.getString(2));
                cancion.setBanda(resultSet.getString(3));
                listaCancionesFavoritas.add(cancion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCancionesFavoritas;
    }
    //Solo buscamos actualizar las canciones, por lo que creamos el método de modo que reciba un id, que será el id de la canción

    public Object actualizarCancion(String id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        String sql = "UPDATE cancion SET cancionesfavoritas=1 WHERE idcancion = ?";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }







}
