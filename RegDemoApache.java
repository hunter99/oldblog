import org.apache.regexp.*;

/**
 * -----------------------------------------------------------------------------
 * Used to provide an example of how to utilize the Apache Regular Expression 
 * Implementation.
 * -----------------------------------------------------------------------------
 */
 
public class RegDemoApache {

    private static void doRegDemo() throws RESyntaxException {

        RE r;
        boolean found;

        String pattern1 = "^A[^b]-\\d+ - ";
        String input1   = "AU-120 - Network Cable.";

        String pattern2 = "^A[^U]\\d+ - ";
        String input2   = "AU-130 - Network Cable.";

        System.out.println();

        r = new RE(pattern1);
        found = r.match(input1);
        System.out.println(
            pattern1 + 
            (found ? "  [ MATCHES ]  " : "  [ DOES NOT MATCH ]  ") + 
            input1 + "\n");

        r = new RE(pattern2);
        found = r.match(input2);
        System.out.println(
            pattern2 + 
            (found ? "  [ MATCHES ]  " : "  [ DOES NOT MATCH ]  ") + 
            input2 + "\n");

    }


    /**
     * Sole entry point to the class and application.
     * @param args Array of String arguments.
     */
    public static void main(String[] args) throws RESyntaxException  {
        doRegDemo();
    }

}