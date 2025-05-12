import java.io.*;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        Stack<Integer> stk3 = new Stack<>();

        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i = h1.size() - 1; i >= 0; i--) {
            stk1.push(h1.get(i));
            sum1 += h1.get(i);
        }

        for (int i = h2.size() - 1; i >= 0; i--) {
            stk2.push(h2.get(i));
            sum2 += h2.get(i);
        }

        for (int i = h3.size() - 1; i >= 0; i--) {
            stk3.push(h3.get(i));
            sum3 += h3.get(i);
        }

        while (sum1 != sum2 || sum2 != sum3) {
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= stk1.pop();
            }
            else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= stk2.pop();
            }
            else {
                sum3 -= stk3.pop();
            }
        }
        return sum1;
    }
}

public class EqualStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result2.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}