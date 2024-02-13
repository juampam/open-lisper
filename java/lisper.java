import java.util.*;

public class Main {

    public static void main(String[] args) {

        LispInterpreter interpreter = new LispInterpreter();
        
        String code = "(+ 2 3)";
        
        Object result = interpreter.evaluate(code);
        
        System.out.println(result);
        
    }

}

class LispInterpreter {

    private Stack<Object> stack;
    private Map<String, Object> environment;
    private LispParser parser;
    private LispEvaluator evaluator;

    public LispInterpreter() {
        stack = new Stack<>();
        environment = new HashMap<>();
        parser = new LispParser();
        evaluator = new LispEvaluator();
    }

    public Object evaluate(String code) {
        List<String> tokens = parser.tokenize(code);
        Object result = evaluator.evaluate(tokens, environment);
        return result;
    }

    public void addVariable(String name, Object value) {
        environment.put(name, value);
    }
    
    public Object getVariable(String name) {
        return environment.get(name);
    }
    
    public Stack<Object> getStack() {
        return stack;
    }
}

class LispParser {

    public List<String> tokenize(String code) {
        return Arrays.asList(code.split("\\\\s+"));
    }
    
}

class LispEvaluator {

    public Object evaluate(List<String> tokens, Map<String, Object> environment) {
        
        for(String token : tokens) {
            // chequear si es número, variable, u operación para evaluar
        }
        
        return null;
    }

}

class SymbolTable {
    Map<String, Object> symbols = new HashMap<>();  
}

class ErrorManager {
    void handleError(Exception error) {
        // manejo de errores
    }
}
