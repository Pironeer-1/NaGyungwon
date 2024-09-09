import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Sample_3_7 {
    public static void main(String[] args) {
        ArrayList pitches = new ArrayList();
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");

        pitches.add(0, "133");
        pitches.add(1, "133");

        System.out.println(pitches.get(1));
        System.out.println(pitches.size());
        System.out.println(pitches.contains("142"));
        System.out.println(pitches.remove("129"));
        System.out.println(pitches.remove(0));

        ArrayList<String> generic = new ArrayList<>();
        generic.add("138");
        generic.add("129");

        String one = generic.get(0);
        String two = generic.get(1);

        System.out.println(pitches);

        String[] data = {"138", "129", "142"};  // 이미 투구수 데이터 배열이 있다.
        ArrayList<String> ary = new ArrayList<>(Arrays.asList(data));
        System.out.println(ary);  // [138, 129, 142] 출력

        ArrayList<String> pch = new ArrayList<>(Arrays.asList("138", "129", "142"));
        System.out.println(pch);

        String result = "";
        for (int i = 0; i < pch.size(); i++) {
            result += pch.get(i);
            result += ",";
        }
        result = result.substring(0, result.length() - 1);
        System.out.println(result);

//        String result = String.join(",", pitches);

        pitches.sort(Comparator.naturalOrder());  // 오름차순으로 정렬
        System.out.println(pitches);
    }
}
