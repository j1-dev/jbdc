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

    System.out.println("Introduzca el DNI del usuario que quiere ver");
    String dni = sc.nextLine();

    dniQ += "'" + dni + "'";
    try {
      connection = DriverManager.getConnection(url, user, pass);
      System.out.println("Connection success.");
      Statement st = connection.createStatement();
      ResultSet rs;
      rs = st.executeQuery(dniQ);
      rs.next();
      System.out.println(rs.getString("apellidos"));
      connection.close();
      System.out.println("Connection closed.");
    } catch (SQLException sqle) {
      System.out.println(sqle.getMessage());
    }
  }
}
