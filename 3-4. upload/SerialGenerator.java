import java.io.*;
import java.util.*;

public class SerialGenerator {

  static Object badObject() {
    Set root = new HashSet();
    Set s1 = root;
    Set s2 = new HashSet();
    for (int i = 0; i < 100; i++) {
      Set t1 = new HashSet();
      Set t2 = new HashSet();
      t1.add("foo");
      s1.add(t1);
      s1.add(t2);
      s2.add(t1);
      s2.add(t2);
      s1 = t1;
      s2 = t2;
    }
    return (Object) root;
  }

  static void serializeAnything(String caption, Object obj) throws IOException {
    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    ObjectOutputStream oOut = new ObjectOutputStream(bOut);
    oOut.writeObject(obj);  // actual serialization
    oOut.close();
    System.out.println(caption + ":");
    System.out.println(new String(Base64.getEncoder().encode(bOut.toByteArray())));
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    System.out.println();

    serializeAnything("Mercury",
                      new Planet(1, "Mercury", "Swift planet", 0.0553));

    serializeAnything("Venus",
                      new Planet(2, "Venus", "Morning star", 0.815));

    serializeAnything("Earth",
                      new Planet(3, "Earth", "Blue planet", 1));

    serializeAnything("a string",
                      new String("Pluto is a planet"));

    //serializeAnything("bad stuff",
    //                  badObject());
  }

}
