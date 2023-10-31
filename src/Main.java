import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Write a number or 'random' : ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        System.out.println("Proccessing ...");

        if(name.equals("random")) {
            Punk punk = new Punk(true);
            punk.setEndpoint();
            punk.getRequest();
        }

        else {
            try {
                Punk punk = new Punk(false);
                punk.setBeerId(Integer.parseInt(name));
                punk.setEndpoint();
                punk.getRequest();
            }
            catch(Exception e) {
                System.out.println("Error");
            }
        }
    }
}