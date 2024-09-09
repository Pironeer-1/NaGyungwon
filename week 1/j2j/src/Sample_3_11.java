public class Sample_3_11 {
    public static void main(String[] args) {
        String num = "123";
        int n = Integer.parseInt(num);
        System.out.println(n);

        num = "" + n;
        System.out.println(num);

        String num1 = String.valueOf(n);
        String num2 = Integer.toString(n);
        System.out.println(num1);
        System.out.println(num2);

        num = "123.456";
        double d = Double.parseDouble(num);
        System.out.println(d);

        int n1 = 123;
        double d1 = n1;
        System.out.println(d1);

        double d2 = 123.456;
        int n2 = (int) d2; // 실수를 정수로 바꿀때에는 반드시 정수형으로 캐스팅
        System.out.println(n2);

        final int n_fin = 123;  // final로 설정하면 값을 바꿀 수 없음
    }
}
