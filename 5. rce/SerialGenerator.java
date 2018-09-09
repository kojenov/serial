import java.io.*;
import java.util.*;

public class SerialGenerator {

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

    //serializeAnything("Pluto",
    //                  new Planet(9, "; notify-send \"You've been pwned!\"; cat /dev/null",
    //                             "I'm still a planet, muhaha!", 1337));

  }

}
