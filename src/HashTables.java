import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String word : magazine) {
            if (map1.containsKey(word)) {
                map1.put(word, map1.get(word)+1);
            }
            else {
                map1.put(word, 1);
            }
        }

        for (String word : note) {
            if (map2.containsKey(word)) {
                map2.put(word, map2.get(word)+1);
            }
            else {
                map2.put(word, 1);
            }
        }

        boolean isPresent = true;
        for (Map.Entry<String, Integer> set : map2.entrySet()) {
            if(!map1.containsKey(set.getKey()) ||
                    (map1.containsKey(set.getKey()) && map1.get(set.getKey())<map2.get(set.getKey()))) {
                isPresent = false;
            }
        }

        if(isPresent) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}

public class HashTables {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}