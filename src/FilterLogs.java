import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterLogs {
    public List<List<String>> extractErrorLogs(List<List<String>> logs) {
        List<List<String>> filteredLogs = new ArrayList<>();

        for (List<String> list : logs) {
            if (list.get(2).equals("ERROR") || list.get(2).equals("CRITICAL")) {
                filteredLogs.add(list);
            }
        }

        // Using custom comparator and lambda expression to sort filtered logs
        filteredLogs.sort((a, b) -> {
            String date1 = a.get(0);
            String date2 = b.get(0);
            String time1 = a.get(1);
            String time2 = b.get(1);

            if (date1.compareTo(date2) != 0) {
                return date1.compareTo(date2);
            } else {
                return time1.compareTo(time2);
            }
        });

        // Using DateTimeFormatter and Comparator to compare each sublist in filteredLogs with other sublist
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//        filteredLogs.sort(Comparator.comparing(subList ->
//                LocalDateTime.parse(subList.get(0) + " " + subList.get(1), formatter)));

        return filteredLogs;
    }

    public static void main (String[] args) {
        List<List<String>> logs = new ArrayList<>();
        logs.add(Arrays.asList("01-01-2023","02:30","ERROR","failed"));
        logs.add(Arrays.asList("01-01-2022","14:00","ERROR","failed"));
        logs.add(Arrays.asList("01-01-2023","15:00","INFO","established"));

        FilterLogs log = new FilterLogs();
        System.out.println(log.extractErrorLogs(logs));
    }
}