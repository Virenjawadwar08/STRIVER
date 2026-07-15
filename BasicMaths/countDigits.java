package BasicMaths;

public class countDigits {
    public static int countD(int n) {
        if(n==0) {
            return 1;
        }
        int count=0;

        while(n!=0) {
            n=n/10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
       int n=54325;
    
    System.out.println(countD(n));
    }
}
