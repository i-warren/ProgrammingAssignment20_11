import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class MatchSymbols {
    public static void main(String[] args) {

        // Check for command line argument
        if (args.length != 1) {
            System.out.println("Usage: java MatchSymbols fileName");
            System.exit(0);
        }
        File file = new File(args[0]);  // Create file obj from args
        // if file does not exist then exit
        if (!file.exists()) {
            System.out.println("File: " +
                    args[0] +
                    "does not exist. ");
            System.exit(1);
        }

        // Create a stack
        Stack<Character> symbols =  new Stack<>();

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNext()) {
                String line = myReader.nextLine();
                // loop through chars
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    // push first match to stack
                    if (ch == '(' || ch == '{' || ch == '[') {
                        symbols.push(ch);
                    } // process stack
                    else if (ch == ')' || ch == '}' || ch == ']'){
                        processSymbols(symbols, ch);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        System.out.println("The file scanned " +
                (symbols.isEmpty() ? "has" : "does not have")
                + " matching pairs of symbols");
    }

    /** Method matches grouped symbols*/
    private static void processSymbols(Stack<Character> stack, Character ch){
        // if stack peek and ch match remove from stack
        if ((stack.peek() == '(' && ch == ')') ||
                (stack.peek() == '{' && ch == '}') ||
                (stack.peek() == '[' && ch == ']')){
            stack.pop();
        } // if ch is symbol and stack peek doesn't match print and exit
        else if ((stack.peek() != '(' && ch == ')') ||
                (stack.peek() != '{' && ch == '}') ||
                (stack.peek() != '[' && ch == ']')){
            System.out.println("Java code does not have matching pairs");
            System.exit(1);
        }
    }
}
