package lisper;
import java.util.Queue;

public class Parser {
    public void parse(Queue<String> tokens) {
        while (!tokens.isEmpty()) {
            String token = tokens.poll();
            System.out.println("Token: " + token);
        }
    }
}
