package string.class_problems;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256]; // Extended ASCII coverage

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0'; // Null character if no non-repeating char exists
    }

    public static void checkAndPrint(String input) {
        char result = findFirstNonRepeatingChar(input);
        if (result != '\0') {
            System.out.println("Input: \"" + input + "\" -> First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("Input: \"" + input + "\" -> No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        checkAndPrint("swiss");
        checkAndPrint("aabbcc");
    }
}