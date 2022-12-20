public class Cat {

    private int age;
    private String name;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private void birthday() {
        age++;
        if (age == 10) {
            // at 10 "Willow" becomes "Old Willow"
            name = "Old " + name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        } else if (o instanceof Cat) {
            Cat apple = (Cat) o;
            return this.age == apple.age && this.name.equals(apple.name);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Cat a1 = new Cat(8, "Willow");
        Cat a2 = a1;
        Cat a3 = new Cat(8, "Willow");
        Cat a4 = new Cat(10, "Old Willow");
        System.out.println(a1 == a2);
        System.out.println(a1 == a3);
        System.out.println(a1 == a4);

        System.out.println(a1.equals(a2));
        System.out.println(a1.equals(a3));
        System.out.println(a1.equals(a4));

        a1.birthday();
        a2.birthday();
        a3.birthday();
        System.out.println(a1.equals(a2));

        System.out.println(a1.equals(a3));


        System.out.println(a1.equals("asdf"));


    }
}
