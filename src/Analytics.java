import java.util.*;

class AnalyticsStore {
    public void storeActions(Queue<ActionEnum> q) {
        System.out.println(q);
    }
}

enum ActionEnum { feature1Button, feature2Button, feature3Button }

public class Analytics {
    AnalyticsStore analyticsStore;
    int k = 3;
    Queue<ActionEnum> registeredActions = new LinkedList<>();
    int totalLoggedActions;
    HashMap<ActionEnum, Integer> frequencyMap = new HashMap<>();

    Analytics(AnalyticsStore analyticsStore, int k) {
        this.analyticsStore = analyticsStore;
        this.k = k;
    }

    public void registerAction(ActionEnum actionEnum) {
        registeredActions.add(actionEnum);
        totalLoggedActions++;
        frequencyMap.put(actionEnum, frequencyMap.getOrDefault(actionEnum, 0) + 1);

        if (registeredActions.size() == k) {
            analyticsStore.storeActions(registeredActions);
            registeredActions.clear();
        }
    }

    public int getNumberOfActionRegisteredButNotSentToAnalyticsStore() {
        return registeredActions.size();
    }

    public int getTotalNumberOfLoggedActions() {
        return totalLoggedActions;
    }

    public List<ActionEnum> getMostFrequentlyUsedActions() {
        List<ActionEnum> mostFrequentlyUsedActions = new ArrayList<>();
        int maxFrequency = 0;

        for (Map.Entry<ActionEnum, Integer> freq : frequencyMap.entrySet()) {
            if (freq.getValue() > maxFrequency) {
                mostFrequentlyUsedActions.clear();
                mostFrequentlyUsedActions.add(freq.getKey());
                maxFrequency = freq.getValue();
            }
            else if (freq.getValue() == maxFrequency) {
                mostFrequentlyUsedActions.add(freq.getKey());
            }
        }

        Comparator<ActionEnum> comparator = (a,b) -> a.name().compareTo(b.name());
        mostFrequentlyUsedActions.sort(comparator);
        return mostFrequentlyUsedActions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalNumberOfRequests = 8;
        int k = 3;

        AnalyticsStore analyticsStore = new AnalyticsStore();
        Analytics analytics = new Analytics(analyticsStore, k);

        for (int i = 0; i < totalNumberOfRequests; i++) {
            String[] action = sc.nextLine().split(" ");

            switch (action[0]) {
                case "registerAction":
                    ActionEnum actionEnum = ActionEnum.valueOf(action[1]);
                    analytics.registerAction(actionEnum);
                    break;
                case "getNumberOfActionRegisteredButNotSentToAnalyticsStore":
                    System.out.println(analytics.getNumberOfActionRegisteredButNotSentToAnalyticsStore());
                    break;
                case "getTotalNumberOfLoggedActions":
                    System.out.println(analytics.getTotalNumberOfLoggedActions());
                    break;
                case "getMostFrequentlyUsedActions":
                    System.out.println(analytics.getMostFrequentlyUsedActions());
                    break;
                default:
                    System.out.println("Invalid action");
                    break;
            }
        }
    }
}