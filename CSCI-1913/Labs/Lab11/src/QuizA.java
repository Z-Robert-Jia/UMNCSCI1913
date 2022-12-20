public class QuizA implements Comparable<QuizA>{
    public static void main(String[] args) {
        Grub gg = new Grub();
        Grub gd = new Dob();
        Grub gk = new Krob();
        Dob dk = new Krob();

        System.out.println(gg.app());
        // What would this return


        System.out.println(gg.bowl());
        // What would this return


        System.out.println(gd.app());
        // What would this return


        System.out.println(gd.bowl());
        // What would this return

        System.out.println(gk.app()+gk.bowl()+dk.cc());

    }

    @Override
    public int compareTo(QuizA o) {
        return 0;
    }
}
