class Animal {
    String name;

    public void setName(String name) {
        this.name = name;
    }
}

public class Sample_5_2 {
    public static void main(String[] args) {
        Animal cat = new Animal();
        cat.setName("boby");  // 메서드 호출

        Animal dog = new Animal();
        dog.setName("happy");

        System.out.println(cat.name);
        System.out.println(dog.name);
    }
}