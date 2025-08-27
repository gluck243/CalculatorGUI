import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class MismatchedParenthesesException extends Exception {
    public MismatchedParenthesesException(String message) {
        super(message);
    }
}

public class Operations {
    public static List<Object> outputList = new LinkedList(); // List to store the postfix expression
    public static Stack<Character> operatorStack = new Stack<>(); // Stack to store operators

    static int getPrecedence(char operator) { // checking precedence/priority
        switch (operator) {
            case '+':
            case '-':
                return 1; // Low precedence
            case '*':
            case '/':
            case '%':
                return 2; // High precedence
            default:
                return 0; // Not a recognized operator
        }
    }

    static boolean hasGreaterOrEqualPrecedence(char operatorFromStack, char currentOperator) {
        int stackPrecedence = getPrecedence(operatorFromStack);
        int currentPrecedence = getPrecedence(currentOperator);

        if (stackPrecedence == 0) { // not recognised
            return false;
        }

        return stackPrecedence >= currentPrecedence; // if precedence is same or higher - start the procedure
    }

    static void shuntingYard(double input) { // First overloaded function for numbers
        outputList.add(input);
        // System.out.println("Pushed " + input); // debug
    }

    static void shuntingYard(char input) { // Second overloaded function for operators
        if (input == '(') { // If left bracket -> push to stack
            operatorStack.push(input);
            // System.out.println("Pushed left bracket"); // debug
        }
        else if (input == ')') { // if right bracket then add everything inside excluding brackets to stack
            while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                outputList.add(operatorStack.pop());
            }
            operatorStack.pop();
            // System.out.println("Pushed everything before and the right bracket"); // debug
        }
        else { // else handles operators by checking their precedence and acting accordingly
            while (!operatorStack.isEmpty() && hasGreaterOrEqualPrecedence(operatorStack.peek(), input)) {
                outputList.add(operatorStack.pop());
            }
            operatorStack.push(input);
            // System.out.println("Pushed " + input); // debug
        }
    }

    static void finalCleanup() { // important final cleanup emptying the rest of the stack into the list
        while (!operatorStack.isEmpty()) {
            outputList.add(operatorStack.pop());
        }
    }

    static double calculate(List<Object> inputList) { // Postfix evaluation
        Stack<Double> loader = new Stack<>(); // stack to hold numbers and results
        double operand1 = 0, operand2 = 0;
        for (Object input : inputList) { // cycle through outputList
            if (input instanceof Double) { // or the outdated input.getClass().equals(Double.class)
                loader.push((Double) input);
            }
            else {
                // Before popping, check if the stack has enough operands
                if (loader.size() < 2) {
                    // Throw an exception
                    throw new IllegalArgumentException("Invalid postfix expression: not enough operands.");
                }
                operand2 = loader.pop();
                operand1 = loader.pop();
                switch ((Character) input) {
                    case '+' :
                        loader.push(operand1 + operand2);
                        break;
                    case  '-' :
                        loader.push(operand1 - operand2);
                        break;
                    case '*' :
                        loader.push(operand1 * operand2);
                        break;
                    case  '/' :
                        loader.push(operand1 / operand2);
                        break;
                    case '%' :
                        loader.push(operand1 % operand2);
                        break;
                    default:
                        break;
                }
            }
        }
        return loader.pop(); // return the last item on the stack = result
    }

    // Clears the List and Stack
    static void allClear() {
        Operations.outputList.clear();
        Operations.operatorStack.clear();
    }

    // Removes zeros at the end of a whole number
    static Number unnecessaryDouble(double result) {
        if (result % 1 == 0) {
            return (int) result;
        }
        else {
            return result;
        }
    }

    // Tokenizer - Utility that reads the input and distributes it to the necessary collections
    static String tokenizer3000(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == ')' || c == '+' || c == '*' || c == '/' || c == '%') { // If operator met (all except '-'), use shuntingYard(char)
                    shuntingYard(c);
            }
            else if (Character.isDigit(c) || (c == '-' && (i == 0 || isOperator(input.charAt(i - 1)) || input.charAt(i - 1) == '('))) { // If positive or negative number is met, wait until the end
                int first = i;                                                                                                          // of it and then use shuntingYard(double)
                while (i + 1 < input.length() && (Character.isDigit(input.charAt(i + 1)) || input.charAt(i + 1) == '.')) {
                    i++;
                }
                String fullNumber = input.substring(first, i + 1);
                Operations.shuntingYard(Double.parseDouble(fullNumber));
            }

            else if (c == '-') { // if it is just '-', the use shuntingYard(char)
                shuntingYard(c);
            }
        }
        finalCleanup(); // Push the rest of the operatorStack to the output list
        double finalResult = calculate(outputList);
        if (Double.isInfinite(finalResult) || Double.isNaN(finalResult)) { // Check for division by zero (could be
            return "Cannot divide by zero!";                               // implemented through try catch, but I
        }                                                                  // chose this method)
        else {
            return String.valueOf(Operations.unnecessaryDouble(finalResult)); // Check for unnecessary zeros
        }
    }

    // Check if the char is an operator
    static boolean isOperator(char o) {
        return o == '+' || o == '-' || o == '*' || o == '/' || o == '%';
    }
}