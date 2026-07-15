package StringsE;

public class largestOddNumStr {

    public String largestOddNumber(String num) {

        // Traverse the string from right to left
        for (int i = num.length() - 1; i >= 0; i--) {

            // Convert the current character to its integer digit value
            int digit = num.charAt(i) - '0';

            // Check if the digit is odd
            if (digit % 2 == 1) {

                // Return the substring from start till this index (inclusive)
                // This forms the largest possible odd number
                return num.substring(0, i + 1);
            }
        }

        // If no odd digit is found, return empty string
        return "";
    }
}
