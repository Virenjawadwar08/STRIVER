package StringsE;
// public class Validparenthesis {
// public String removeOuterParentheses(String s) {
//     StringBuilder result=new StringBuilder();
//     int depth=0;

//     for(char ch:s.toCharArray()) {
//         if(ch=='(') {
//             if(depth>0) {
//                 result.append(ch);
//             }
//             depth++;
//         }
//         else {
//             depth--;
//             if(depth>0) {
//                 result.append(ch);
//             }
//         }
//     }
//     return result.toString();
// }
// }


//another approach

public class Validparenthesis {
    public String removeOuterParentheses(String s) {
        int count=0;

        StringBuilder str=new StringBuilder();

        for(char ch:s.toCharArray()) {
            if(ch==')') count--;
            if(count!=0) str.append(ch);
            if(ch=='(') count++;
        }
        return str.toString();
    }
}