public class MatrixUtilities {
    public static void show(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean isMatrix(int[][] matrix) {
        boolean boleano = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length == matrix.length) {
                boleano = true;
            } else {
                boleano = false;
                break;
            }
        }
        return boleano;
    }

    public static boolean isIdentity(int[][] matrix) {
        boolean booleano = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    if (matrix[i][j] == 1) {
                        booleano = true;
                    } else {
                        booleano = false;

                    }
                }
            }
        }
        return booleano;
    }

    public static void multipleBy(int[][] matrix, int valor) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] * valor;
            }
        }
        show(matrix);
    }

    public static boolean areCompatibleForSum(int[][] matrix1, int[][] matrix2) {
        boolean boleano;
        if (isMatrix(matrix1) && isMatrix(matrix2)) {
            boleano = true;
        } else {
            boleano = false;
        }
        return boleano;
    }

    public static void sumOf(int[][] matrix1, int[][] matrix2) {
        if (areCompatibleForSum(matrix1, matrix2)) {
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[i].length; j++) {
                    matrix1[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            show(matrix1);
        }
    }
}
