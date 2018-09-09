
public class User implements java.io.Serializable {
  String username;
  String role;

  public User(String username, String role) {
    this.username = username;
    this.role     = role;
  }

  public boolean isAdmin() {
    return role.equals("administrator");
  }
}
