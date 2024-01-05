
import java.util.Stack;

// 괄호, 짝궁찾, 동일 숫자 제거 등의 문제는 거의 스택 활용
public class 겹쳐진압축해제 {

    public String solution(String s){
        String answer = "";
        Stack<String> st = new Stack<>();

        for(Character ch : s.toCharArray()) {

            if(ch==')') {
                String temp = "";
                while(!st.empty()) {
                    String d = st.pop();
                    if(d.equals("(")) break;
                    temp = d+temp;
                }
                if(Character.isDigit(st.peek().charAt(0))) {
                    temp = temp.repeat(Integer.parseInt(st.pop()));
                }
                st.push(temp);
            } else {
                st.push(String.valueOf(ch));
            }
        }

        while(!st.empty()) {
            answer = st.pop()+answer;
        }
        return answer;
    }

    public static void main(String[] args){
        겹쳐진압축해제 T = new 겹쳐진압축해제();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
