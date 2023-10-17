import java.util.regex.Pattern;

public class DebuggingHarness {

    static String minimalBugString;
    static int minimalLength;

    public static void main(String[] args) {
        deltaDebug("abcdefG1",1);
        deltaDebug("CCDDEExy",2);
        deltaDebug("234567b",3);
        deltaDebug("8665",4);
    }

    public static void deltaDebug (String str, int index) {
        minimalBugString = null;
        minimalLength = Integer.MAX_VALUE;
        deltaFunction(str);
        System.out.println(index+". original input: \""+str+'"');
        if (minimalBugString != null) {
            System.out.println("   minimal string to reproduce bug: \"" + minimalBugString + '"');
        } else System.out.println("   The string produces no bug");
    }

    public static boolean detectDupeBug (String str) {
        Pattern duplicatedDigits = Pattern.compile("(\\d)\\1");

        return (duplicatedDigits.matcher(str).find());
    }

    public static boolean deltaFunction (String str) {
        if (detectDupeBug(MyStringProcessor.process(str)) && (str.length() < minimalLength)) {
            minimalLength = str.length();
            minimalBugString = str;
            deltaFunction(str.substring(0,str.length()/2));
            deltaFunction(str.substring(str.length()/2));
        }
        return false;
    }
}
