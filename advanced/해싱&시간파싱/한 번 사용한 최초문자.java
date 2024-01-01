
import java.util.HashMap;

public class 한번사용한최초문자 {
    public int solution(String s){

        HashMap<Character, Integer> idxOfChar = new HashMap<>();
        boolean[] isDouble = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if(!idxOfChar.containsKey(curr) && !isDouble[curr-'a']) {
                idxOfChar.put(curr,i+1);
            } else {
                if(isDouble[curr-'a']) continue;
                idxOfChar.remove(curr);
                isDouble[curr-'a'] = true;
            }
        }

        if(idxOfChar.isEmpty()) return -1;
        int min = Integer.MAX_VALUE;
        for(char ch : idxOfChar.keySet()) {
            int idx = idxOfChar.get(ch);
            min = Math.min(min, idx);
        }

        return min;
    }

    public static void main(String[] args){
        한번사용한최초문자 T = new 한번사용한최초문자();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
