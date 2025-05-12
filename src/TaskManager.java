import java.util.*;

public class TaskManager {
    private HashMap<Integer, Integer> taskPriority = new HashMap<>();
    private HashMap<Integer, Integer> taskUser = new HashMap<>();
    private PriorityQueue<int[]> pq;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            else {
                return b[0] - a[0];
            }
        });

        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);

            taskPriority.put(taskId, priority);
            taskUser.put(taskId, userId);
            pq.offer(new int[]{priority, taskId});
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskPriority.put(taskId, priority);
        taskUser.put(taskId, userId);
        pq.offer(new int[]{priority, taskId});
    }

    public void edit(int taskId, int newPriority) {
        taskPriority.put(taskId, newPriority);
        pq.offer(new int[]{newPriority, taskId});
    }

    public void rmv(int taskId) {
        taskPriority.remove(taskId);
        taskUser.remove(taskId);
    }

    public int execTop() {
        while(!pq.isEmpty()) {
            int[] task = pq.poll();
            int taskId = task[1];
            int priority = task[0];

            if (taskPriority.getOrDefault(taskId,-1) == priority) {
                int userId = taskUser.remove(taskId);
                taskPriority.remove(taskId);
                return userId;
            }
        }
        return -1;
    }
}

/*
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */