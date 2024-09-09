public class Sample_3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(7 % 3);
        System.out.println(3 % 7);

        int i = 0;
        int j = 10;
        i++;
        j--;

        System.out.println(i);
        System.out.println(j);

        i = 0;
        System.out.println(i++);
        System.out.println(i);

        i = 3;
        boolean isOdd = i % 2 == 1;
        System.out.println(isOdd);

        char a1 = 'a';
        char a2 = 97;
        char a3 = '\u0061';

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        String sa = "Hello Java";
        System.out.println(sa.indexOf("Java"));

        System.out.println(String.format("I eat %d apples.", 3));

        int number = 10;
        String day = "three";
        System.out.println(String.format("I ate %d apples. so I was sick for %s days.", number, day));


        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("jump to java");
        String result = sb.toString();
        System.out.println(result);

        String res = "";
        res += "hello";
        res += " ";
        res += "jump to java";
        System.out.println(res);
    }
}
