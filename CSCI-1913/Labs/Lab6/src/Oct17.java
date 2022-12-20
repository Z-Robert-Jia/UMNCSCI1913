public class Oct17 {
    public static int num_div(int number){
        int count = 0;
        for (int i = 1; i<= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(num_div(60));
    }
}
