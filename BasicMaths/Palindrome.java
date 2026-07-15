package BasicMaths;

public class Palindrome {
    public static boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }

        int rev=0;
        int temp=x;

        while(temp!=0) {
            int d=temp%10;
              if (rev > Integer.MAX_VALUE / 10) {
                return false;
            }

            rev=(rev*10)+d;
            temp=temp/10;
        }
        return rev==x;
    }
    public static void main(String[] args) {
        int x=121;
        System.out.println(isPalindrome(x));
    }
}
