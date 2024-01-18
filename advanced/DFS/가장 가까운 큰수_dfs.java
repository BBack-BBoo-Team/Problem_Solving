import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장가까운큰수_dfs {

    String[] split;
    boolean find;
    int answer;
    public int solution(int n){
        answer = 0;
        String toString = String.valueOf(n);

        split = toString.split("");
        Arrays.sort(split);

        find = false;
        dfs(new boolean[split.length],new ArrayList<>(), n);

        if(find) return answer;
        else return -1;
    }

    private void dfs(boolean[] use, ArrayList<String> list, int n) {

        if(list.size()==split.length) {
            int result = Integer.parseInt(list.stream().collect(Collectors.joining()));
            if(result>n) {
                find = true;
                answer = result;
            }
            return;
        }

        for(int i = 0; i < split.length; i++ ) {
            if(find) break;
            if (use[i]) continue;
            list.add(split[i]);
            use[i] = true;
            dfs(use, list, n);
            use[i] = false;
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args){
        가장가까운큰수_dfs T = new 가장가까운큰수_dfs();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
