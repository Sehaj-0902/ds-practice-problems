import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'downToZero' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int downToZero(int n) {
        // Write your code here
        if (n <= 0) return 0;

        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(new int[]{n, 0});
        visited.add(n);

        while (!q.isEmpty()) {
            int[] current = q.poll();

            int num = current[0];
            int moves = current[1];

            if (num == 0) return moves;

            if (num - 1 >= 0 && !visited.contains(num - 1)) {
                q.add(new int[]{num - 1, moves + 1});
                visited.add(num - 1);
            }

            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    int a = j;
                    int b = num / j;

                    int max = Math.max(a, b);

                    if (!visited.contains(max)) {
                        q.add(new int[]{max, moves + 1});
                        visited.add(max);
                    }
                }
            }
        }
        return -1;
    }
}

public class DownToZero {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.downToZero(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}