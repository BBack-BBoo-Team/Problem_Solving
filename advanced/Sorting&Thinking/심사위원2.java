import java.util.Arrays;

// k개의 숫자를 고르는 과정 개선
public class 심사위원2 {

    // i) 평균이 가장 낮은 k개의 수
    public int solution(int[] score, int k){
        int answer = 0;

        Arrays.sort(score);
        int start = 0, end = 0;
        for(; start < score.length-k; start++) {
            int curr = score[start];
            int maxPoint = curr+10;
            end = start+k;
            if (score[end] <= maxPoint) break;
        }

        answer = (int) Arrays.stream(score,start,end).average().getAsDouble();

        return answer;
    }

    public static void main(String[] args){
        심사위원2 T = new 심사위원2();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
