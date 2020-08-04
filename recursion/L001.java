public class L001 {
    public static void main(String[] args) {
        int[] a = new int[21];
        int[] arr = { 3, 6, 8, 0, 5 };
        System.out.println(minimum(arr, 0));
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
        count += subseq(question.substring(1), ans + question.charAt(0));  //question[0]
        // nhi aa rha hai
        count += subseq(question.substring(1), ans);
        return count;
    }

}