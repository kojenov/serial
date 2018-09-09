import java.io.*;

public class Planet implements java.io.Serializable {
  int    order;
  String name;
  String nickname;
  double mass;

  public Planet(int order, String name, String nickname, double mass) {
    this.order    = order;
    this.name     = name;
    this.nickname = nickname;
    this.mass     = mass;
  }

  private void writeObject(java.io.ObjectOutputStream oOut)
               throws IOException
  {
    oOut.writeObject(name);
    oOut.writeObject(nickname);
  }

  private void readObject(ObjectInputStream oIn)
               throws java.io.IOException, ClassNotFoundException
  {
    name     = (String) oIn.readObject();
    nickname = (String) oIn.readObject();

    String command = "echo `date`: received " + name + " >> /var/log/planets/app.log";
    Runtime.getRuntime().exec(new String[] {"bash", "-c", command});
  }

  public String toString() {
    return order + ". " + name + " (" + nickname + "): " + mass;
  }
}
