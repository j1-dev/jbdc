import java.sql.*;
import java.util.Scanner;

public class people {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Connection connection;
    System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/people";
    String user = "juan";
    String pass = "Password1234.";
    String dniQ = "select nombre, apellidos, telefono from people where dni = ";

    System.out.println("Inserta los datos de un nuevo usuario");
    System.out.print("dni: ");
    String dni = sc.nextLine();
    System.out.print("nombre: ");
    String nombre = sc.nextLine();
    System.out.println("apellidos: ");
    String apellidos = sc.nextLine();
    System.out.println("telefono: ");
    int tlf = sc.nextInt();
    sc.nextLine();

    String insert = "insert into people values ('" + dni + "', '" + nombre + "','" + apellidos + "','" + tlf + "' )";

    dniQ += "'" + dni + "'";
    try {
      connection = DriverManager.getConnection(url, user, pass);
      System.out.println("Connection success.");
      Statement st = connection.createStatement();

      st.executeUpdate(insert);

      connection.close();
      System.out.println("Connection closed.");
    } catch (SQLException sqle) {
      System.out.println(sqle.getMessage());
    }

    sc.close();
  }
}
