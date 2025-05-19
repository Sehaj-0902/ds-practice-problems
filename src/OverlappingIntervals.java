public class OverlappingIntervals {
    public boolean checkOverlap (int[] meet1, int[] meet2) {
        return meet1[0] >= meet2[0] && meet1[0] < meet2[1] || meet2[0] >= meet1[0] && meet2[0] < meet1[1];
    }

    public static void main(String[] args) {
//        int[][] arr = {{0,10}, {5,10}, {15,20}};
        int[][] arr = {{7,10}, {2,4}};

        OverlappingIntervals res = new OverlappingIntervals();

        boolean overlap = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (res.checkOverlap(arr[i], arr[j])) {
                    overlap = true;
                }
            }
        }

        if (overlap) {
            System.out.println("Cannot attend all meetings");
        }
        else {
            System.out.println("Can attend all meetings");
        }
    }
}
