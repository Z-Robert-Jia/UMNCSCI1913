public class test {
    public static void main(String[] args) {
        String[] temp = new String[10];
        temp[1] = "1";
        for (String ele : temp){
            ele += "1";
        }
        System.out.println(temp[1]);
    }
}
