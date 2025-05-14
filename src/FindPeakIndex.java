public class FindPeakIndex {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        return findPeakElement(arr, start, end);

        // Using Binary Search
        // while (start < end) {
        //     int mid = start + (end - start) / 2;

        //     if (arr[mid] > arr[mid + 1]) {
        //         end = mid;
        //     }
        //     else {
        //         start = mid + 1;
        //     }
        // }
        // return start;
    }

    // Using Binary Search and Recursion
    public int findPeakElement(int[] arr, int start, int end) {
        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] > arr[mid + 1]) {
            return findPeakElement(arr, start, mid);
        }
        else {
            return findPeakElement(arr, mid + 1, end);
        }
    }
}