package D3;

public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public String searchMovie(String titleInput, String yearInput)
            throws InvalidUserInputException, MovieNotFoundException {

        // Validierung Titel
        if (titleInput == null || titleInput.isBlank()) {
            throw new InvalidUserInputException("Der Filmtitel darf nicht leer sein.");
        }
        String title = titleInput.trim();
        if (title.length() < 2) {
            throw new InvalidUserInputException("Der Filmtitel muss mindestens 2 Zeichen lang sein.");
        }

        // Jahr optional validieren
        Integer year = null;
        if (yearInput != null && !yearInput.isBlank()) {
            try {
                year = Integer.parseInt(yearInput.trim());
                if (year < 1900 || year > 2100) {
                    throw new InvalidUserInputException("Bitte ein plausibles Jahr zwischen 1900 und 2100 eingeben.");
                }
            } catch (NumberFormatException e) {
                throw new InvalidUserInputException("Das Jahr muss eine Zahl sein.");
            }
        }

        MovieRequest request = new MovieRequest(title, year);
        MovieResponse response = movieService.findMovie(request);

        // Textausgabe
        return String.format(
                "Titel: %s (%s)%nGenre: %s%nIMDb-Rating: %.1f%n%nPlot: %s%n%nEmpfehlung: %s",
                response.getTitle(),
                response.getYear(),
                response.getGenre(),
                response.getImdbRating(),
                response.getPlot(),
                movieService.createRecommendationText(response)
        );
    }
}
