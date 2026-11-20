public class CinemaSeating {
    public static void main(String[] args) {
        int[][] matrix = {{1,0,1,1,0}, {0,0,0,1,1},{1,1,1,1,1},{0,1,0,0,0}};
        zobrazKinoSalu(matrix);
    }

    static void zobrazKinoSalu(int[][] matrix) {
        for (int[] row : matrix) {
            for (int seat : row) {
                System.out.print(seat == 1 ? "X " : "0 ");
            }
            System.out.println();
        }
    }
}
