package D3;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class MovieApiClient {
    static {
        EnvLoader.loadEnv();
    }

    private static final String API_KEY = System.getProperty("API_KEY");
    private static final String BASE_URL = "https://www.omdbapi.com/";

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public MovieResponse fetchMovie(MovieRequest request) throws MovieNotFoundException {
        try {
            String encodedTitle = URLEncoder.encode(request.getTitle(), StandardCharsets.UTF_8);

            StringBuilder urlBuilder = new StringBuilder(BASE_URL)
                    .append("?t=").append(encodedTitle)
                    .append("&apikey=").append(API_KEY)
                    .append("&plot=short");

            if (request.getYear() != null) {
                urlBuilder.append("&y=").append(request.getYear());
            }

            URI uri = URI.create(urlBuilder.toString());

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(uri)
                    .build();

            HttpResponse<String> httpResponse =
                    httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (httpResponse.statusCode() != 200) {
                throw new RuntimeException("HTTP-Fehler: " + httpResponse.statusCode());
            }

            String body = httpResponse.body();

            if (body.contains("\"Response\":\"False\"")) {
                throw new MovieNotFoundException("Film wurde nicht gefunden.");
            }

            String title = extractJsonValue(body, "Title");
            String year = extractJsonValue(body, "Year");
            String genre = extractJsonValue(body, "Genre");
            String imdbRatingStr = extractJsonValue(body, "imdbRating");
            String plot = extractJsonValue(body, "Plot");

            double imdbRating;
            try {
                imdbRating = Double.parseDouble(imdbRatingStr.replace(",", "."));
            } catch (NumberFormatException e) {
                imdbRating = 0.0;
            }

            return new MovieResponse(
                    title != null ? title : request.getTitle(),
                    year != null ? year : (request.getYear() != null ? request.getYear().toString() : "n/a"),
                    genre != null ? genre : "n/a",
                    imdbRating,
                    plot != null ? plot : "Keine Beschreibung verfügbar."
            );

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Fehler beim Zugriff auf die API: " + e.getMessage(), e);
        }
    }

    private String extractJsonValue(String json, String key) {
        String pattern = "\"" + key + "\":\"";
        int startIndex = json.indexOf(pattern);
        if (startIndex == -1) {
            return null;
        }
        startIndex += pattern.length();
        int endIndex = json.indexOf("\"", startIndex);
        if (endIndex == -1) {
            return null;
        }
        return json.substring(startIndex, endIndex);
    }
}
