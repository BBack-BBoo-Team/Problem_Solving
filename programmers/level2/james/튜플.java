import java.util.Arrays;
import java.util.HashSet;

public class 튜플 {

    public static void main(String[] args) {

        튜플 test = new 튜플();
        System.out.println(Arrays.toString(test.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))); // 2,1,3,4

        System.out.println(Arrays.toString(test.solution("{{20,111},{111}}"))); // 111, 20

        System.out.println(Arrays.toString(test.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }

    public int[] solution(String s) {
        // 1. s를 문자열 배열로 변환, [{,}] 공백으로 변환 후, 공백+쉼표(,)+공백 으로 구분
        String[] stringToSplit = s.replaceAll("[{]", " ").replaceAll("[}]"," ").trim().split(" , ");

        // 2. 배열 내의 문자열 길이로 오름차순 정렬
        Arrays.sort(stringToSplit, (o1, o2) -> o1.length() - o2.length());

        int[] result = new int[stringToSplit.length];
        HashSet<String> set = new HashSet<>();
        // 3. 정렬한 배열을 순회
        for(int i = 0; i < result.length; i++) {

            String[] arr = stringToSplit[i].split(",");
            for(String curr : arr) {
                // 4. 배열에 값이 HashSet에 있는지 체크
                if(!set.contains(curr)) {
                    // 5. 없으면 결과 배열과 HashSet에 저장
                    result[i] = Integer.parseInt(curr);
                    set.add(curr);
                    break;
                }
            }
        }
        return result;
    }
}
