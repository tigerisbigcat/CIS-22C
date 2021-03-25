
/**
 * A class that has a methond to recursively replaces characters in a String.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class RecursiveStringReplace
{

    /**
     * replace - Replace all instances of one character by another.
     * 
     * @param  s   The string to do the replacement on.
     * @param  from   The character to be replaced.
     * @param  to   the character to change to.
     * @return     A new string with the appropriate characters replaced.
     */
    public String replace(String s, char from, char to) {
        String result = null;

        // IMPLEMENT THIS RECURSIVE METHOD
        result = helper(s, from, to, 0);
        return result;
    }

    public String helper(String s, char from, char to, int index) {
        if(index >= s.length()) {
            return s;
        }
        if(s.charAt(index) == from) {
            return helper(s.substring(0, index) + to +
                    s.substring(index + 1, s.length()), from, to, index + 1);
        }
        else {
            return helper(s, from, to, index + 1);
        }
    }
}

