import java.util.Scanner;

public class piramid {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int line = input.nextInt();

        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= line - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
