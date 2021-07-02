//filename£ºApp9_7.java
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class App9_7 {

    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(Paths.get("chapter9\\t.txt"))) {
            while (in.hasNext()) {
                System.out.println(in.nextLine());
            }
        }
    }
}
