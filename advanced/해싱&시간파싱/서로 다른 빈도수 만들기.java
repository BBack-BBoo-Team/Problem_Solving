import java.util.HashMap;
import java.util.HashSet;

public class 서로다른빈도수만들기 {
    public int solution(String s){
        int answer = 0;

        HashMap<Character, Integer> alphaCnt = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        // 1. 문자별로 중복 수 체크
        for(int i = 0; i < s.length(); i++) {
            alphaCnt.put(s.charAt(i), alphaCnt.getOrDefault(s.charAt(i), 0)+1);
        }
        // 2. map을 순회하면서 set에 값 저장
        for(char key : alphaCnt.keySet()) {
            int cnt = alphaCnt.get(key);

            while(set.contains(cnt)) {
                answer++;
                if(cnt!=0) cnt--;
                else break;
            }

            if (cnt!=0) set.add(cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        서로다른빈도수만들기 T = new 서로다른빈도수만들기();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}import java.util.HashMap;
import java.util.HashSet;

public class 서로다른빈도수만들기 {
    public int solution(String s){
        int answer = 0;

        HashMap<Character, Integer> alphaCnt = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        // 1. 문자별로 중복 수 체크
        for(int i = 0; i < s.length(); i++) {
            alphaCnt.put(s.charAt(i), alphaCnt.getOrDefault(s.charAt(i), 0)+1);
        }
        // 2. map을 순회하면서 set에 값 저장
        for(char key : alphaCnt.keySet()) {
            int cnt = alphaCnt.get(key);

            while(set.contains(cnt)) {
                answer++;
                if(cnt!=0) cnt--;
                else break;
            }

            if (cnt!=0) set.add(cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        서로다른빈도수만들기 T = new 서로다른빈도수만들기();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
