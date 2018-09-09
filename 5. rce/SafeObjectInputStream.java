import java.io.*;

public class SafeObjectInputStream extends ObjectInputStream {

  public SafeObjectInputStream(InputStream inputStream) throws IOException {
    super(inputStream);
  }

  @Override
  protected Class<?> resolveClass(ObjectStreamClass input)
                                  throws IOException, ClassNotFoundException
  {
    System.out.println(input.getName());
    if (!input.getName().equals(Planet.class.getName())) {
      throw new InvalidClassException("Unsupported class", input.getName());
    }
    return super.resolveClass(input);
  }
}
