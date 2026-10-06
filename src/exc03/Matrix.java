package exc03;

public class Matrix {
    int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90};

    int[][] matrix = new int[3][3];

    void main() {
        int index = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = array[index];
                index++;
            }

        for (int[] raw : matrix) {
            for (int column : raw)
                IO.print(column + " ");
            IO.println();
        }

    }



}
