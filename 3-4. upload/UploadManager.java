import java.io.*;
import java.util.Base64;
import java.util.Scanner;

public class UploadManager {

  void processUpload(String base64In) throws Exception {
    byte[] planetBytes = Base64.getDecoder().decode(base64In.getBytes());

    ByteArrayInputStream  bIn = new ByteArrayInputStream(planetBytes);
    ObjectInput oIn = new ObjectInputStream(bIn);
    //ObjectInput oIn = new SafeObjectInputStream(bIn);
    Planet planet = (Planet) oIn.readObject();  // actual deserialization
    oIn.close();
    bIn.close();

    System.out.println("\nSuccessfully uploaded:\n" + planet + "\n");
    // TODO: store the planet in the Solar System DB
  }

  public static void main(String[] args) throws Exception {
    UploadManager um = new UploadManager();
    Scanner input = new Scanner(System.in);
    while (input.hasNext()) {
      try {
        String line = input.nextLine();
        if (line.startsWith("rO0AB")) {
          um.processUpload(line);
        }
      }
      catch (Exception e) {
        System.out.println();
        e.printStackTrace();
        System.out.println("\nCaught an exception... Invalid object?\n");
      }
    }
  }

}
