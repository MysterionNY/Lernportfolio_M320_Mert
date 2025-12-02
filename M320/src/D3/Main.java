package D3;

public class Main {
    public static void main(String[] args) {
        MovieApiClient apiClient = new MovieApiClient();
        MovieService movieService = new MovieService(apiClient);
        MovieController controller = new MovieController(movieService);
        ConsoleApp app = new ConsoleApp(controller);
        app.run();
    }
}
