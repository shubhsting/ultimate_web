import java.lang.reflect.Array;
import java.util.ArrayList;

public class L001 {
    public static void main(String[] args) {
        int[] a = new int[21];
        int[] arr = { 3, 6, 8, 0, 5 };
        System.out.println(nokiakeypad("01", ""));

    }

    public static int power(int number, int powe) {
        // base case
        if (powe == 0)
            return 1;
        // subproblem
        int subprobem = power(number, powe - 1);
        return subprobem * number;
    }

    public static int factorial(int num) {
        if (num == 1)
            return 1;
        int subproblem = factorial(num - 1);
        return subproblem * num;
    }

    public static void print(int[] arr, int index) {
        // basecase
        if (index == arr.length)
            return;

        System.out.print(arr[index] + " ");
        // subproblem
        print(arr, index + 1);
        // for reverse order
        System.out.print(arr[index] + " ");

    }

    public static boolean find(int[] arr, int idx, int num) {
        if (idx == arr.length)
            return false;
        if (arr[idx] == num)
            return true;
        return find(arr, idx + 1, num);

    }

    public static int maximum(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[index];
        int subprobem = maximum(arr, index + 1);
        return Math.max(subprobem, arr[index]);
    }

    public static int minimum(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[index];
        int subprobem = minimum(arr, index + 1);
        return Math.min(subprobem, arr[index]);
    }

    public static int fibonacci(int num) {
        if (num == 0)
            return 0;
        if (num == 1)
            return 1;
        int subprob1 = fibonacci(num - 1);
        int subprob2 = fibonacci(num - 2);
        return subprob1 + subprob2;
    }

    public static int subseq(String question, String ans) {
        if (question.length() == 0) {
            if (ans.length() == 2)
                System.out.print(ans + " ");
            return 1;
        }

        int count = 0;
        // aa rha hai
        count += subseq(question.substring(1), ans + question.charAt(0)); // question[0]
        // nhi aa rha hai
        count += subseq(question.substring(1), ans);
        return count;
    }

    public static ArrayList<String> suseq_02(String ques) {
        if (ques.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }

        char ch = ques.charAt(0);
        ArrayList<String> myAns = new ArrayList<>();
        ArrayList<String> subprob = suseq_02(ques.substring(1));
        for (String str : subprob) {
            myAns.add(str);
            myAns.add(ch + str);
        }
        return myAns;
    }

    public static int permuwithduplicates(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            count += permuwithduplicates(ques.substring(0, i) + ques.substring(i + 1), ans + ch);
        }
        return count;
    }

    public static ArrayList<String> permuwithduplicates_02(String ques) {
        if (ques.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }
        char ch = ques.charAt(0);
        ArrayList<String> myAns = new ArrayList<>();
        ArrayList<String> subprob = permuwithduplicates_02(ques.substring(1));
        for (String str : subprob) {
            for (int i = 0; i <= str.length(); i++)
                myAns.add(str.substring(0, i) + ch + str.substring(i));

        }
        return myAns;
    }

    public static ArrayList<String> permuwithoutduplicates_02(String ques) {
        if (ques.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }
        char ch = ques.charAt(0);
        ArrayList<String> myAns = new ArrayList<>();
        ArrayList<String> subprob = permuwithoutduplicates_02(ques.substring(1));
        for (String str : subprob) {
            for (int i = 0; i <= str.length(); i++) {
                String ans = str.substring(0, i) + ch + str.substring(i);
                if (!myAns.contains(ans))
                    myAns.add(ans);
            }
        }
        return myAns;
    }

    static String[] keypad = { "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vw", "xyz" };

    public static int nokiakeypad(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return 1;
        }
        char ch = str.charAt(0);
        int idx = ch - '0';
        String keyvalues = keypad[idx];
        int count = 0;
        for (int i = 0; i < keyvalues.length(); i++) {
            count += nokiakeypad(str.substring(1), ans + keyvalues.charAt(i));
        }
        return count;
    }

    public static ArrayList<String> nokiaKeypad_02(String ques) {
        if (ques.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }
        char ch = ques.charAt(0);
        int idx = ch - '0';
        String keyvalues = keypad[idx];
        ArrayList<String> myAns = new ArrayList<>();
        ArrayList<String> subproblem = nokiaKeypad_02(ques.substring(1));
        for (String str : subproblem) {
            for (int i = 0; i < keyvalues.length(); i++) {
                char chr = keyvalues.charAt(i);
                myAns.add(chr + str);
            }
        }
        return myAns;
    }



    
}