//abstract class Predator extends Animal {
//    abstract String getFood();
//
//    void printFood() {  // default 를 제거한다.
//        System.out.printf("my food is %s\n", getFood());
//    }
//}
//
//interface Predator {
//    String getFood();
//
//    default void printFood() {
//        System.out.printf("my food is %s\n", getFood());
//    }
//}
//
//interface Barkable {
//    void bark();
//}
//
//interface BarkablePredator extends Predator, Barkable {
//}
//
//
//class Animal {
//    String name;
//
//    void setName(String name) {
//        this.name = name;
//    }
//}
//
//class Tiger extends Predator implements Barkable {
//    public String getFood() {
//        return "apple";
//    }
//
//    public void bark() {
//        System.out.println("어흥");
//    }
//}
//
//class Lion extends Predator implements Barkable {
//    public String getFood() {
//        return "banana";
//    }
//
//    public void bark() {
//        System.out.println("으르렁");
//    }
//}
//
//class ZooKeeper {
//    void feed(Predator predator) {
//        System.out.println("feed " + predator.getFood());
//    }
//}
//
//class Bouncer {
//    void barkAnimal(Barkable animal) {
//        animal.bark();
//    }
//}
//
//
//public class Sample_5_9 {
//    public static void main(String[] args) {
//        Tiger tiger = new Tiger();
//        Lion lion = new Lion();
//
//        Bouncer bouncer = new Bouncer();
//        bouncer.barkAnimal(tiger);
//        bouncer.barkAnimal(lion);
//    }
//}
