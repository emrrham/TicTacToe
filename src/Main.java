import java.util.Scanner;

public class TicTacToe. {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("Kaç adet sayı gireceksiniz?: ");
        n = input.nextInt();

        int max = 0;
        int min = 0;

        boolean first = true;

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ". sayıyı giriniz: ");
            int num = input.nextInt();

            if (first) {
                max = num;
                min = num;
                first = false;
            } else {
                if (num > max) {
                    max = num;
                }

                if (num < min) {
                    min = num;
                }
            }
        }

        System.out.println("En büyük sayı: " + max);
        System.out.println("En küçük sayı: " + min);
    }
}
