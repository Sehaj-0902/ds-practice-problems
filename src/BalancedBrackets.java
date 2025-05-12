import java.io.*;
import java.util.Stack;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch == ')' && !stk.isEmpty() && stk.peek() == '(') ||
                    (ch == ']' && !stk.isEmpty() && stk.peek() == '[') ||
                    (ch == '}' && !stk.isEmpty() && stk.peek() == '{')) {
                stk.pop();
            }
            else if (ch == ')' || ch == ']' || ch == '}') {
                return "NO";
            }
            else {
                stk.push(ch);
            }
        }
        return stk.isEmpty() ? "YES" : "NO";
    }
}

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}