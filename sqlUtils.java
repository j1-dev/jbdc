import java.sql.*;

public class sqlUtils {
  String url;
  String user;
  String pass;
  Connection c;
  Statement s;

  public sqlUtils(String url, String user, String pass) throws SQLException {
    this.url = url;
    this.user = user;
    this.pass = pass;
    c = DriverManager.getConnection(url, user, pass);
    s = c.createStatement();
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public Connection getConnection() {
    return c;
  }

  public void setConnection(Connection c) {
    this.c = c;
  }

  public Statement getStatemnt() {
    return s;
  }

  public void setStatement(Statement s) {
    this.s = s;
  }

  public ResultSet query();

  public void insert();

  public void update();

  public void delete();
}
