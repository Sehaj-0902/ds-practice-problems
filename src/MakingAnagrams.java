import java.io.*;

class Result3 {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
        // Write your code here
        int[] freq = new int[26];
        for (int i=0;i<s1.length();i++) {
            char ch = s1.charAt(i);
            freq[ch - 'a']++;
        }
        for (int i=0;i<s2.length();i++) {
            char ch = s2.charAt(i);
            freq[ch - 'a']--;
        }
        int deletions = 0;
        for (int i=0;i<26;i++) {
            deletions += Math.abs(freq[i]);
        }
        return deletions;
    }
}

public class MakingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result3.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}