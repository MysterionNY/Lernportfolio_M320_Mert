package D3;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class EnvLoader {
    public static void loadEnv() {
        try (FileInputStream fis = new FileInputStream("src/.env")) {
            Properties props = new Properties();
            props.load(fis);
            props.forEach((k, v) -> System.setProperty(k.toString(), v.toString()));
        } catch (IOException e) {
            System.err.println("Fehler beim Laden der .env Datei: " + e.getMessage());
        }
    }
}
