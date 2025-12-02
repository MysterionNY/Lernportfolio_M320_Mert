package D3;

public class MovieRequest {

    private final String title;
    private final Integer year; // optional

    public MovieRequest(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }
}
