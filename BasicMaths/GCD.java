package BasicMaths;

public class GCD {
    public static int gcd(int n1, int n2) {
        while(n2!=0) {
            int rem=n1%n2;
            n1=n2;
            n2=rem;
        }
        return n1;
    }

    public static void main(String[] args) {
        System.out.println(gcd(9, 6));
    }
}
