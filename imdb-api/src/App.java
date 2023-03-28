
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class App {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[45m";
    public static void main(String[] args) throws Exception {
        // Creating the connection
        String url = "https://gist.githubusercontent.com/lucasfugisawa/cbb0d10ee3901bd0541468e431c629b3/raw/1fe1f3340dfe5b5876a209c0e8226d090f6aef10/Top250Movies.json";
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(url)).GET().build();
        HttpResponse<String> response = client.send(request,BodyHandlers.ofString()); // this line could be turned into "var" as wells as the lines above, but it would make the code less understandable
        String body = response.body();

        // Extracting the movies
        var parser = new JsonParser();
        List<Map<String,String>> moviesList = parser.parse(body);

        // Printing the movies
        var stickerMaker = new StickerFactory();

        for (Map<String,String> movie : moviesList) {
            var urlImagem = movie.get("image");
            var title = movie.get("title");
            // var movieRate = Float.parseFloat(movie.get("imDbRating"));
            // var stars = " ";

            InputStream inputStream = new URL(urlImagem).openStream();
            var fileName = title + ".png";

            stickerMaker.create(inputStream, fileName);


            // System.out.println("\nTitle: " + movie.get("title"));
            // System.out.println("Image: " + movie.get("image"));
            
            // switch ((int) movieRate) {
            //     case 10:
            //         stars += "⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐";
            //         break;
            //     case 9:
            //         stars += "⭐⭐⭐⭐⭐⭐⭐⭐⭐";
            //         break;
            //     case 8:
            //         stars += "⭐⭐⭐⭐⭐⭐⭐⭐";
            //         break;
            //     case 7:
            //         stars += "⭐⭐⭐⭐⭐⭐⭐";
            //         break;
            //     case 6:
            //         stars += "⭐⭐⭐⭐⭐⭐";
            //         break;
            //     case 5:
            //         stars += "⭐⭐⭐⭐⭐";
            //         break;
            //     case 4:
            //         stars += "⭐⭐⭐⭐";
            //         break;
            //     case 3:
            //         stars += "⭐⭐⭐";
            //         break;
            //     case 2:
            //         stars += "⭐⭐";
            //         break;
            //     case 1:
            //         stars += "⭐";
            //         break;
            // }
            // System.out.println(ANSI_PURPLE+"Rating: " + (int)movieRate + stars +" " + ANSI_RESET);  
        }

    }
}
