public class Sample_5_3 {
    int sum(int a, int b) {
        return a + b;
    }
    String say() {
        return "Hi";
    }

    void v_sum(int a, int b) {
        System.out.println(a+"과 "+b+"의 합은 "+(a+b)+"입니다.");
    }

    void v_say() {
        System.out.println("Hi");
    }

    void sayNick(String nick) {
        if ("바보".equals(nick)) {
            return;
        }
        System.out.println("나의 별명은 "+nick+" 입니다.");
    }

    public static void main(String[] args) {
        Sample_5_3 sample = new Sample_5_3();
        int c = sample.sum(3, 4);

        System.out.println(c);

        Sample_5_3 s_sample = new Sample_5_3();
        String a = s_sample.say();
        System.out.println(a);

        sample.v_sum(3, 4);
        sample.v_say();

        sample.sayNick("야호");
        sample.sayNick("바보");
    }
}
