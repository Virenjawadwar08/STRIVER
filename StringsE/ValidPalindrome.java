package StringsE;

public class ValidPalindrome {
     public boolean isPalindrome(String s) {
        
        // Initialize two pointers
        int left = 0;
        int right = s.length() - 1;

        // Traverse while left pointer is before right pointer
        while (left < right) {

            // Skip non-alphanumeric characters from left side
            while (left < right && 
                   !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from right side
            while (left < right && 
                   !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters after converting to lowercase
            // to make comparison case-insensitive
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;   // If mismatch found, not a palindrome
            }

            // Move both pointers inward
            left++;
            right--;
        }

        // If no mismatches found, it is a palindrome
        return true;
    }
}
