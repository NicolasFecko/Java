public class CinemaSeating {
    public static void main(String[] args) {
        int[][] matrix = {{1,0,1,1,0}, {0,0,0,1,1},{1,1,1,1,1},{0,1,0,0,0}};
        zobrazKinoSalu(matrix);
        System.out.println("Free seats: " + spocitajVolneSedadla(matrix));
    }

    static void zobrazKinoSalu(int[][] matrix) {
        for (int[] row : matrix) {
            for (int seat : row) {
                System.out.print(seat == 1 ? "X " : "0 ");
            }
            System.out.println();
        }
    }
    static int spocitajVolneSedadla(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            for (int seat : row) {
                if (seat == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean rezervujSedadlo(int[][] matrix, int riadok, int stlpec) {
        if (riadok < 0 || riadok >= matrix.length
                || stlpec < 0 || stlpec >= matrix[riadok].length) {
            return false;
        }

        if (matrix[riadok][stlpec] == 0) {
            matrix[riadok][stlpec] = 1;
            return true;
        }
        return false;
    }
}
