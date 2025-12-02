package D3;

public class MovieResponse {

    private final String title;
    private final String year;
    private final String genre;
    private final double imdbRating;
    private final String plot;

    public MovieResponse(String title, String year, String genre, double imdbRating, String plot) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.imdbRating = imdbRating;
        this.plot = plot;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public String getPlot() {
        return plot;
    }
}
