package Recursion;

import java.util.List;
import java.util.ArrayList;

public class BinaryStringsWoutConOnes {
    public static List<String> generateBinaryStrings(int n) {
        List<String> result=new ArrayList<>();
        backtrack(result,"",n);
        return result;
    }

    private static void backtrack(List<String> result,String curr,int n) {
        if(curr.length()==n) {
            result.add(curr);
            return;
        }

        backtrack(result, curr+"0", n);

        if(curr.length() == 0 || curr.charAt(curr.length() - 1) != '1') {
            backtrack(result, curr+"1", n);
        }
    }
    public static void main(String[] args) {
      int n=3;
      System.out.println(generateBinaryStrings(n));
    }
}


/*
========================================
CALL STACK DRY RUN
generateBinaryStrings(n = 3)
========================================

Initial Call:
backtrack("", n=3)

----------------------------------------
1) backtrack("")
   -> add "0"
2) backtrack("0")
   -> add "0"
3) backtrack("00")
   -> add "0"
4) backtrack("000")
   -> length == 3
   -> add "000"
   -> return (pop)

   -> add "1"
5) backtrack("001")
   -> length == 3
   -> add "001"
   -> return

----------------------------------------
Back to backtrack("0")
   -> add "1"
6) backtrack("01")
   -> add "0"
7) backtrack("010")
   -> length == 3
   -> add "010"
   -> return
   -> cannot add "1" (previous is 1)

----------------------------------------
Back to backtrack("")
   -> add "1"
8) backtrack("1")
   -> add "0"
9) backtrack("10")
   -> add "0"
10) backtrack("100")
    -> add "100"
    -> return

    -> add "1"
11) backtrack("101")
    -> add "101"
    -> return

----------------------------------------
FINAL RESULT:
["000", "001", "010", "100", "101"]

----------------------------------------
CALL STACK RULES:

Push when recursive call happens
Pop when function returns
Max recursion depth = n
Time Complexity = O(2^n)
Space Complexity = O(n)
========================================
*/




// 🔥 Why Lexicographical Order?

// Because:

// backtrack(result, curr + "0", n);

// is called before

// backtrack(result, curr + "1", n);

// So:

// 0 comes before 1

// Hence sorted automatically.