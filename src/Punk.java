import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Punk {
    private int beerId;
    private boolean isRandom;
    private String endpoint;
    private static String url = "https://api.punkapi.com/v2/beers/";

    Punk(boolean isRandom) {
        this.isRandom = isRandom;
    }

    public void setBeerId(int id) {
        this.beerId = id;
    }

    public String setEndpoint() {
        if(this.isRandom) {
            this.endpoint = "random";
        }

        if(!this.isRandom) {
            this.endpoint = Integer.toString(this.beerId);
        }

        return this.endpoint;
    }

    public void getRequest() throws IOException {
        URL urlObj = new URL(url + this.endpoint);
        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if(responseCode == HttpsURLConnection.HTTP_OK) {
            StringBuilder sb = new StringBuilder();
            Scanner scan = new Scanner(connection.getInputStream());

            while(scan.hasNext()) {
                sb.append(scan.nextLine());
            }

            System.out.println(sb);
        }

        else {
            System.out.println("Error");
        }
    }
}
