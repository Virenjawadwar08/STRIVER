package Recursion;

public class CountGoodNum {
    static final long MOD=1000000009;
    public int countGoodNumbers(long n) {
        long evenCount=(n+1)/2;
        long oddCount=n/2;

        long evenPart=power(5,evenCount);
        long oddPart=power(4,oddCount);

        return (int)((evenPart*oddPart)%MOD);
    }

    private long power(long x,long n) {
        if(n==0) return 1;

        long half=power(x,n/2);
        long result=(half*half)%MOD;

        if(n%2==1) {
            result=(result*x)%MOD;
        }
        return result;
    }

}


// Let’s take:

// n = 4
// Step 1: countGoodNumbers(4)
// evenCount = (4+1)/2 = 2
// oddCount = 4/2 = 2

// Now calculate:

// 5^2 * 4^2
// Step 2: power(5,2)
// power(5,2)
// → half = power(5,1)
//     → half = power(5,0)
//         → return 1
//     → result = 1*1*5 = 5
// → result = 5*5 = 25

// So:

// 5^2 = 25
// Step 3: power(4,2)
// power(4,2)
// → half = power(4,1)
//     → half = power(4,0)
//         → return 1
//     → result = 1*1*4 = 4
// → result = 4*4 = 16

// So:

// 4^2 = 16
// Final Answer
// 25 * 16 = 400

// Return:

// 400