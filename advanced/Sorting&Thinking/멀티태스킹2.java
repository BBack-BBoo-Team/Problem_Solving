import java.util.Arrays;

// int = 2,147,483,647
// 1 <= k <= 2*10^13 -> 14자리 -> int 넘어 (long)
// 자칫하면 time limit
public class 멀티태스킹2 {

    // 작은 수 부터 제거되기 때문에 정렬 후 제거될 작업 찾는다.
    // 찾고 남은 시간에 해당하는 인덱스 출력
    public int solution(int[] tasks, long k) {

        int length = tasks.length;
        int[] temp = Arrays.copyOf(tasks,length+1);
        Arrays.sort(temp);

        // 제거되는 작업 찾기
        int rest = length;
        int last = 0;
        for(int i = 1; i < length+1; i++) {
            int useTime = (temp[i]-temp[i-1]) * rest;
            last = temp[i];
            if(k < useTime) break;
            k-=useTime;
            rest--;
        }

        if(rest==0) return -1;
        k%=rest; // 회전수 줄이기
        for(int i = 0; i < length; i++) {
            int curr = tasks[i];
            if(curr < last) continue;
            if(k-- == 0) return i+1;
        }

        return 0;
    }

    public static void main(String[] args){
        멀티태스킹2 T = new 멀티태스킹2();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
