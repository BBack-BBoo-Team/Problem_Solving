import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장가까운큰수 {
    public int solution(int n){
        int answer = 0;
        String[] toString = String.valueOf(n).split("");

        // n의 끝자리부 한칸 앞자리와 비교했을때 오름차순이면 자리교체 break
        // 끝까지 도는동안 자리를 교체하지 않았다면 -1 반환
        int i = toString.length-1;
        boolean change = false;
        for(; i > 0; i--) {
            if (toString[i].compareTo(toString[i-1]) <= 0) continue;
            String temp = "";
            temp = toString[i];
            toString[i] = toString[i-1];
            toString[i-1] = temp;
            change = true;
            break;
        }
        if(!change) return -1;

        // 교체했을때의 자리부터 마지막까지 오름차순 정렬
        Arrays.sort(toString,i,toString.length);

        return Integer.parseInt(Arrays.stream(toString).collect(Collectors.joining()));
    }

    public static void main(String[] args){
        가장가까운큰수 T = new 가장가까운큰수();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
