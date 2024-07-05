import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String url  = "jdbc:mysql://localhost:3306/basedatosestudiantes";
        String user = "root";
        String password = "123456";

        try (Connection connection= DriverManager.getConnection(url,user,password)){
            System.out.println("CONECTADO A LA BASE DE DATOS");
            String query = "SELECT * FROM estudiantes";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingresa la Provincia a buscar: ");
            String Provincia = sc.nextLine();
            while (resultSet.next()) {
                if (resultSet.getString("idCiudad").equals(Provincia)){
                    System.out.println(resultSet.getString("idNombre"));

                }
            }
        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
        }
    }
}