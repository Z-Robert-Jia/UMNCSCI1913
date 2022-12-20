import java.util.Arrays;
import java.util.Scanner;

public class Oct21 {
    public static void main(String[] args) {
        int[] numberPlace = new int[10];
        Scanner intScan = new Scanner(System.in);
        for (int i = 0; i<10;i++) {
            int theNum = intScan.nextInt();
            while (theNum < 1 || theNum > 20) {
                System.out.println("Error");
                theNum = intScan.nextInt();
            }
            numberPlace[i] = theNum;
        }
        System.out.println(Arrays.toString(numberPlace));
    }
}
