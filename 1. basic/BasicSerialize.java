
import java.io.*;

public class BasicSerialize {
  public static void main(String [] args) {
    try {
      Planet earth = new Planet(3, "Earth", "Blue planet", 1);
      String fname = "earth.ser";

      // serializing an object
      FileOutputStream fout = new FileOutputStream(fname);
      ObjectOutputStream oout = new ObjectOutputStream(fout);
      oout.writeObject(earth);   // actual serialization
      oout.close();
      fout.close();
      System.out.println("\nThe object was written to " + fname);

      // deserializing an object
      FileInputStream fin = new FileInputStream(fname);
      ObjectInputStream oin = new ObjectInputStream(fin);
      Planet planet = (Planet) oin.readObject();   // actual deserialization
      oin.close();
      fin.close();
      System.out.println("\nThe object was read from " + fname + ":");
      System.out.println(planet);
      System.out.println();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
