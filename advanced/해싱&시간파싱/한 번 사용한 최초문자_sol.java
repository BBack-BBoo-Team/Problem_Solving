
public class 한번사용한최초문자_sol {

    public int solution(String s){

        HashMap<Character, Integer> cntChar = new HashMap<>();

        // 문자별 cnt 저장
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cntChar.put(ch, cntChar.getOrDefault(ch, 0)+1);
        }

        // 문자 순회하면서 1에 해당하는 key의 index return
        for(int i = 0 ; i < s.length(); i++) {
            if(cntChar.get(s.charAt(i)) == 1) return i+1;
        }

        return -1;
    }
    public static void main(String[] args){
        한번사용한최초문자_2 T = new 한번사용한최초문자_2();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
