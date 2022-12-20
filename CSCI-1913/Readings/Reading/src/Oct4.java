import java.util.Scanner;
public class Oct4 {
    public static void main(String [] args) {
        int wage;
        Scanner scnr = new Scanner(System.in);

        wage = scnr.nextInt();

        System.out.print("Salary is ");
        System.out.println(wage * 40 * 52);
    }
}
