import java.io.File;
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
                    "does not exist.");
            System.exit(1);
        }

        // Create a stack
        Stack<Character> symbols =  new Stack<>();


        System.out.println("The file scanned " +
                (symbols.isEmpty() ? "has" : "does not have")
                + " matching pairs of symbols");
    }

    /** Method matches grouped symbols*/
    private static void processSymbols(Stack<Character> stack, Character ch){
        // if stack peek and ch match remove from stack

    }
}
