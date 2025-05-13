public class RotateImage {
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] arr = new int[r][c];

        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                arr[j][c-1-i] = matrix[i][j];
            }
        }

        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                matrix[i][j] = arr[i][j];
            }
        }
    }
}