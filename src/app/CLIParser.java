/**
 * CLIParser handles reading command line flags.
 * 
 *
 * @author Philip Hodder
 * @since 2015-08-26
 */

public class CLIParser {

    /**
     * Checks if arg and val are the same string value.
     *
     * @param arg The CLI argument to check
     * @param val The value to check arg against.
     * @return Returns true if arg and val are the same.
     * @throws NullPointerException arg or val are null.
     */
    public static boolean checkMatch(String arg, String val) {
	if (arg == null || val == null) {
	    throw new NullPointerException();
	}
	return arg.equals(val);
    } 
    
}
