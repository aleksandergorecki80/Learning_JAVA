import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigData {
    public static void main(String[] args) {
        try {
            Files.lines(Path.of("C:/Users/justy/Desktop/JAVA/UDEMY__Java_Foundations/Hr5m.csv"))
                    .limit(2)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


