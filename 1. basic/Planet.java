
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

  public String toString() {
    return order + ". " + name + " (" + nickname + "): " + mass;
  }
}
