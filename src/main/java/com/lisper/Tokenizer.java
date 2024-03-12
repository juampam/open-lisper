package lisper;
import java.util.LinkedList;
import java.util.Queue;

public class Tokenizer {
    public Queue<String> tokenize(String input) {
        Queue<String> tokens = new LinkedList<>();
        StringBuilder tokenBuilder = new StringBuilder();
        boolean insideParentheses = false;

        for (char c : input.toCharArray()) {
            if (c == '(') {
                if (insideParentheses) {
                    // Nested parentheses, treat as part of token
                    tokenBuilder.append(c);
                } else {
                    // Start of a new token
                    insideParentheses = true;
                    tokenBuilder = new StringBuilder();
                    tokenBuilder.append(c);
                }
            } else if (c == ')') {
                if (insideParentheses) {
                    // End of current token
                    insideParentheses = false;
                    tokenBuilder.append(c);
                    tokens.offer(tokenBuilder.toString().trim());
                } else {
                    // Error: Unexpected closing parenthesis
                    throw new RuntimeException("Unexpected closing parenthesis");
                }
            } else if (Character.isWhitespace(c)) {
                // Ignore whitespace if outside parentheses
                if (insideParentheses) {
                    tokenBuilder.append(c);
                }
            } else {
                // Append character to current token
                tokenBuilder.append(c);
            }
        }

        if (insideParentheses) {
            // Error: Unclosed parenthesis
            throw new RuntimeException("Unclosed parenthesis");
        }

        return tokens;
    }
}
