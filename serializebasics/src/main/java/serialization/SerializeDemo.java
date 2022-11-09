package serialization;
import java.io.*;
/**
 *  See: https://www.tutorialspoint.com/java/java_serialization.htm
 *
 *  Also see: http://tutorials.jenkov.com/java-io/serializable.html
 *       and: https://www.baeldung.com/java-serialization
 */
public class SerializeDemo {

   public static void main(String [] args) {
      Employee e = new Employee("Daniel Plante", "Computer Science", 12300456, 80012345);
      
      try {
         final FileOutputStream fileOut =
        		 new FileOutputStream("data/employee.serialized");
         final ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in data/employee.serialized");
      } catch (IOException i) {
         i.printStackTrace();
      }
   }
}
