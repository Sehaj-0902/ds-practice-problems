import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class Result1 {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
        // Write your code here
        Set<Character> set1 = new HashSet<>();
        for (char ch : s1.toCharArray()) {
            set1.add(ch);
        }

        Set<Character> set2 = new HashSet<>();
        for (char ch : s2.toCharArray()) {
            set2.add(ch);
        }

        for (char ch : set1) {
            if (set2.contains(ch)) {
                return "YES";
            }
        }

        return "NO";
    }
}

public class TwoStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result1.twoStrings(s1, s2);

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