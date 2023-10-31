import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

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

    public void getRequest() {

    }
}
