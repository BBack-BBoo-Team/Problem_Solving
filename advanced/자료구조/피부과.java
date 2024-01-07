import java.util.LinkedList;
import java.util.Queue;

public class 피부과 {
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        Queue<Integer> wait = new LinkedList<>();
        int time = toMin(enter[0].split(" ")[0]);
        wait.add(0);
        int idx = 1;
        while(!wait.isEmpty() || idx<enter.length) {

            if (wait.isEmpty()) {
              time = toMin(enter[idx].split(" ")[0]) + laser[Integer.parseInt(enter[idx].split(" ")[1])];
              idx++;
            } else {
                int curr = wait.poll();
                time += laser[Integer.parseInt(enter[curr].split(" ")[1])];
            }

            while(idx < enter.length && time > toMin(enter[idx].split(" ")[0])) {
                wait.add(idx);
                idx++;
            }

            answer = Math.max(answer, wait.size());
        }

        return answer;
    }

    int toMin(String s) {
        return Integer.parseInt(s.split(":")[0])*60 + Integer.parseInt(s.split(":")[1]);
    }

    public static void main(String[] args){
        피부과 T = new 피부과();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
