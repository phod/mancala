/**
 * MancalaApp is the entry point of the application. 
 *
 * @author Philip Hodder
 * @since 2015-08-23
 */

public class MancalaApp {

    /**
     * Prints out usage information for the application. As of
     * this version, the output is mainly composed of command line
     * information.
     * After the output is printed, the application exits. 
     */
    public static void printUsage() {
	System.out.println("Mancala");
	System.out.println("A basic Mancala application, " +
			   "launches a GUI for the user to play on.");
	System.out.println("\nCommand line arguments:");
	System.out.println("\t-h: prints out usage information.");
	System.out.println("\nFor more information on Mancala " +
			   "consult Google or Wikipedia.");
	System.out.println("\nIN PROGRESS.");
	System.exit(0);
    }
    
    /**
     * Currently, prints out "Hello, World!"
     * Later, will instantiate necessary classes. May handle
     * some command line arguments too (unsure as of now). 
     *
     * @param args: Currently unused.
     */
    public static void main(String [] args) {
	if (args.length > 0) {
	    if (args[0].equals("-h")) {
		printUsage();
	    } else {
		System.out.println("Invalid CLI arguments supplied.\n");
		printUsage();
	    }
	}
	System.out.println("Hello, World!");
	System.out.println(args.length);
    }
    
}
