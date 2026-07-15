package BasicMaths;

public class Reverse {
    public static int reverse(int x) {
        int rev=0;

        while(x!=0) {
            int d=x%10;

            if(x>Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && d>7)) {
                return 0;
            }
            if(x<Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE/10 && d<-8)) {
                return 0;
            }

            rev=(rev*10)+d;
            x=x/10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int rev=123;
        System.out.println(reverse(rev));
    }
}
