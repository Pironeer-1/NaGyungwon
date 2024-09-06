interface Predator {
    String getFood();
    default void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }
}

class Tiger extends Animal implements Predator, Barkable{
    public String getFood() {
        return "apple";
    }
    public void bark() {
        System.out.println("어흥");
    }
}

class Lion extends Animal implements BarkablePredator{
    public String getFood() {
        return "banana";
    }
    public void bark() {
        System.out.println("으르렁");
    }
}

class ZooKeeper {
    void feed(Predator predator) {
        System.out.println("feed "+predator.getFood());
    }
//    void feed(Tiger tiger) {  // 호랑이가 오면 사과를 던져 준다.
//        System.out.println("feed apple");
//    }
//
//    void feed(Lion lion) {  // 사자가 오면 바나나를 던져준다.
//        System.out.println("feed banana");
//    }

//    void feed(Crocodile crocodile) {
//        System.out.println("feed strawberry");
//    }
//
//    void feed(Leopard leopard) {
//        System.out.println("feed orange");
//    }
}

public class Sample_5_7 {
    public static void main(String[] args) {
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        zooKeeper.feed(tiger);
        zooKeeper.feed(lion);
    }
}
