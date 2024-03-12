package lisper;
import java.io.*;

public class Interpreter {
    public static void main(String[] args) {
        // File path to the input file
        String filePath = "input.txt";
        
        // Create instances of Tokenizer and Parser
        Tokenizer tokenizer = new Tokenizer();
        Parser parser = new Parser();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Tokenize and parse each line
                Queue<String> tokens = tokenizer.tokenize(line);
                parser.parse(tokens);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
