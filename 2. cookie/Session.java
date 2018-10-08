
import java.io.*;
import java.util.Base64;

public class Session {
  private User user;

  // log in and print the session cookie
  public Session(String username, String password) {
    user = authenticate(username, password);
    if (user != null) {
      log("Hello " + user.username + ", here is your SESSION cookie:");
      log(serialize(user));
    }
  }

  // handle valid user session via the session cookie
  public Session(String cookie) {
    user = deserialize(cookie);
    log("Welcome back, " + user.username + "!");
    if (user.isAdmin()) {
      log("You are an administrator, be careful!");
    }
  }

  // authentication
  private User authenticate(String username, String password) {

    if (username.equals("copernicus") && password.equals("Poland")) {
      return new User(username, "regular");

    } else if (username.equals("galileo") && password.equals("Italy")) {
      return new User(username, "administrator");

    } else {
      return null;
    }
  }

  // serialize and encode with Base64
  public String serialize(User user) {
    byte[] userBytes = {};
    try {
      ByteArrayOutputStream bOut = new ByteArrayOutputStream();
      ObjectOutput oOut = new ObjectOutputStream(bOut);
      oOut.writeObject(user);
      oOut.flush();
      userBytes = bOut.toByteArray();  // actual serialization
      oOut.close();
      bOut.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    return new String(Base64.getEncoder().encode(userBytes));
  }

  // decode from Base64 and deserialize
  public User deserialize(String base64In) {
    byte[] userBytes = Base64.getDecoder().decode(base64In.getBytes());
    User userTo = null;
    try {
      ByteArrayInputStream bIn = new ByteArrayInputStream(userBytes);
      ObjectInput oIn = new ObjectInputStream(bIn);
      user = (User) oIn.readObject();  // actual deserialization
      oIn.close();
      bIn.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    return user;
  }

  // logging
  static void log(String msg) {
    System.out.println(msg);
  }

  // ...
  public static void main(String [] args) {
    log("");
    if (args.length == 2) {
      Session session = new Session(args[0], args[1]);
    }
    else {
      Session session = new Session(args[0]);
    }
    log("");
  }
}
