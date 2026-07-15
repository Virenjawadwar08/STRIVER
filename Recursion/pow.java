package Recursion;

public class pow {
    public double myPow(double x, int n) {
        long N=n;
        if(N<0) {
            x=1/x;
            N=-N;
        }
        return power(x,N);
    }

    private static double power(double x,long n) {
        if(n==0) return 1;

        double half=power(x, n/2);

        if(n%2==0) {
         return half*half;
        } else {
            return half*half*x;
        }
    }
}


// Why private?

// You say:

// Because power() is an internal recursive helper method used only inside the class. To maintain encapsulation and clean API design, it should not be exposed publicly.

/*
Dry Run 1:
Input: x = 2, n = 10

myPow(2, 10)
N = 10 (positive)
Call power(2, 10)

power(2,10)
→ half = power(2,5)

power(2,5)
→ half = power(2,2)

power(2,2)
→ half = power(2,1)

power(2,1)
→ half = power(2,0)

power(2,0) = 1   // base case

Now resolve back:

power(2,1)
= 1 * 1 * 2
= 2

power(2,2)
= 2 * 2
= 4

power(2,5)
= 4 * 4 * 2
= 32

power(2,10)
= 32 * 32
= 1024

Final Output = 1024
*/

/*
Dry Run 2 (Negative Power):
Input: x = 2, n = -3

myPow(2, -3)

N = -3
Since N < 0:
x = 1/2 = 0.5
N = 3

Call power(0.5, 3)

power(0.5,3)
→ half = power(0.5,1)

power(0.5,1)
→ half = power(0.5,0)

power(0.5,0) = 1

Resolve:

power(0.5,1)
= 1 * 1 * 0.5
= 0.5

power(0.5,3)
= 0.5 * 0.5 * 0.5
= 0.125

Final Output = 0.125
*/