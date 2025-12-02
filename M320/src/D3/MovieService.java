package D3;

public class MovieService {

    private final MovieApiClient apiClient;

    public MovieService(MovieApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public MovieResponse findMovie(MovieRequest request) throws MovieNotFoundException {
        return apiClient.fetchMovie(request);
    }

    public String createRecommendationText(MovieResponse movie) {
        double rating = movie.getImdbRating();

        if (rating >= 8.0) {
            return "Klares Must-Watch!";
        } else if (rating >= 6.0) {
            return "Kann man schauen.";
        } else if (rating > 0) {
            return "Nur für Hardcore-Fans.";
        } else {
            return "Keine Bewertung vorhanden.";
        }
    }
}
