import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Operations {

    static List<Object> outputList = new LinkedList(); // List to store the postfix expression
    static Stack<Character> operatorStack = new Stack<>(); // Stack to store operators

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
    }

    static void shuntingYard(char input) { // Second overloaded function for operators
        if (input == '(') { // If left bracket -> push to stack
            operatorStack.push(input);
        }
        else if (input == ')') { // if right bracket then add everything inside excluding brackets to stack
            while (!operatorStack.isEmpty() && operatorStack.peek() != '(') { // ?
                outputList.add(operatorStack.pop());
            }
            operatorStack.pop();
        }
        else { // else handles operators by checking their precedence and acting accordingly
            while (!operatorStack.isEmpty() && hasGreaterOrEqualPrecedence(operatorStack.peek(), input)) {
                outputList.add(operatorStack.pop());
            }
            operatorStack.push(input);
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
}


