package personallibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface LibraryDAO {

    public static void registerBookDB(LibraryModel libMo){

        Conexion data_connect= new Conexion();

        try(Connection conexion = data_connect.get_connection()){

            PreparedStatement prepStat = null;

            try{

                String query = "INSERT INTO book(book_name, author, isbn, pages, category)VALUES(?,?,?,?,?)";

                prepStat = conexion.prepareStatement(query);
                prepStat.setString(1,libMo.getBookName());
                prepStat.setString(2,libMo.getAuthor());
                prepStat.setString(3,libMo.getIsbn());
                prepStat.setInt(4,libMo.getPages());
                prepStat.setString(5,libMo.getCategory());
                prepStat.execute();
                System.out.println("Registro de Libro Exitoso");


            }catch (SQLException exception){
                System.out.println(exception);


            }

        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }



    }


    public static void updateBookDB(LibraryModel libMod){

        Conexion data_connect= new Conexion();

        try(Connection conexion = data_connect.get_connection()) {

            PreparedStatement prepStat = null;

            try{
                String query = "UPDATE book SET book_name = ?, author = ? WHERE id_book= ?";

                prepStat = conexion.prepareStatement(query);
                prepStat.setString(1,libMod.getBookName());
                prepStat.setString(2, libMod.getAuthor());
                prepStat.setInt(3, libMod.getId_book());
                prepStat.executeUpdate();
                System.out.println("El registro ha sido actualizado exitosamente");

            }catch (SQLException e){
                System.out.println(e);
            }

        }catch (SQLException exception){
            System.out.println(exception);
        }
    }

    public static void deleteBookDB(int id_book){

        Conexion data_connect= new Conexion();

        try(Connection conexion = data_connect.get_connection()) {

            PreparedStatement prepStat = null;

            try{
                String query = "DELETE FROM book WHERE book.id_book = ?";

                prepStat = conexion.prepareStatement(query);
                prepStat.setInt(1,id_book);
                prepStat.executeUpdate();
                System.out.println("El registro ha sido eliminado exitosamente");

            }catch (SQLException e){
                System.out.println(e);


            }

        }catch (SQLException exception){
            System.out.println(exception);
        }





    }

    public static void listBookDB(){

        Conexion data_connect= new Conexion();

        PreparedStatement prepStat = null;

        ResultSet resultSet = null;

        try(Connection conexion = data_connect.get_connection()){

            String query = "SELECT * FROM book";

            prepStat = conexion.prepareStatement(query);
            resultSet = prepStat.executeQuery();

            while(resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id_book"));
                System.out.println("Titulo: "+ resultSet.getString("book_name"));
                System.out.println("Autor: " + resultSet.getString("author"));
                System.out.println("ISBN: " + resultSet.getString("isbn"));
                System.out.println("Número de páginas" + resultSet.getInt("pages"));
                System.out.println("Categoria: " + resultSet.getString("category"));


            }

        }catch (SQLException e){
            System.out.println(e);
        }





    }




}
