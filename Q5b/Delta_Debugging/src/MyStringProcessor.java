public class MyStringProcessor {
    public static String process(String input_str) {
        String output_str = "";

        for (char c : input_str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                output_str = output_str + Character.toLowerCase(c);
            } else if (Character.isDigit(c)) {
                output_str = output_str + c + c;
            } else {
                output_str = output_str + Character.toUpperCase(c);
            }
        }

        return output_str;
    }
}
