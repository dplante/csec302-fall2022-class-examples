package magic;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * See: http://thecodersbreakfast.net/index.php?post/2011/05/12/Serialization-and-magic-methods
 * 
 * Show serialization magic methods order called
 */
public class Test {
 
    public static void main(String[] args) throws Exception {
        Pojo pojo = new Pojo("Hello world");
        byte[] bytes = serialize(pojo); // Serialization        
        Pojo p = (Pojo) deserialize(bytes); // De-serialization
        System.out.println(p.getMsg());
    }
 
    private static byte[] serialize(Object o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.flush();
        oos.close();
        return baos.toByteArray();
    }
 
    private static Object deserialize(byte[] bytes) throws ClassNotFoundException, IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object o = ois.readObject();
        ois.close();
        return o;
    }
 
}