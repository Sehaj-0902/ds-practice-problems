import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Result {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
        // Write your code here
        Set<Character> uniqueCharacters = new HashSet<>();
        for (char ch : s.toCharArray()) {
            uniqueCharacters.add(ch);
        }

        List<Character> list = new ArrayList<>();
        list.addAll(uniqueCharacters);

        int maxLength = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                char ch1 = list.get(i);
                char ch2 = list.get(j);

                String str = "";
                boolean isValid = true;

                for (char c : s.toCharArray()) {
                    if (c == ch1 || c == ch2) {
                        int len = str.length();
                        if (len > 0 && str.charAt(len - 1) == c) {
                            isValid = false;
                            break;
                        }
                        str += c;
                    }
                }

                if (isValid && str.length() >= 2) {
                    maxLength = Math.max(maxLength, str.length());
                }
            }
        }
        return maxLength;
    }
}

public class TwoCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}