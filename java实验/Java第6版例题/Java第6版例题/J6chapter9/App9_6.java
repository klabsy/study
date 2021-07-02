//filename£ºApp9_6.java
import java.io.*;

public class App9_6 {

    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("ÇëÊäÈë×Ö·û´®£º");
                str = buf.readLine();
                if (str.length() > 0) {
                    break;
                } else {
                    throw new IOException();
                }
            } catch (IOException e) {
                System.out.println("±ØÐëÊäÈë×Ö·û´®!!");
                continue;
            }
        }
        String s = str.toUpperCase();
        System.out.println("×ª»»ºóµÄ×Ö·û´®Îª£º" + s);
    }
}
