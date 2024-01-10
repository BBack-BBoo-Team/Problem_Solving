import java.util.ArrayList;
import java.util.Arrays;

public class 심사위원 {

    // i) 평균이 가장 낮은 k개의 수
    // score 오름차순 정렬
    // score 순회
    // 현재수 10을 더한 후 다음 수들 중 이하인 수 2개 체크
    // 없으면 패스
    // 2개 완료되면 현재, 2개 수의 평균을 구하고 break
    public int solution(int[] score, int k){
        int answer = 0;

        Arrays.sort(score);

        for(int i = 0; i < score.length-k; i++) {
            int curr = score[i];
            int maxPoint = curr+10;
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(curr);
            for(int j = i+1; j < score.length; j++) {
                if (score[j] > maxPoint || temp.size()==k) break;
                temp.add(score[j]);
            }


            if(temp.size()==k) {
                answer = (int) temp.stream().mapToInt(Integer::intValue).average().getAsDouble();
                break;
            }

        }

        return answer;
    }

    public static void main(String[] args){
        심사위원 T = new 심사위원();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
