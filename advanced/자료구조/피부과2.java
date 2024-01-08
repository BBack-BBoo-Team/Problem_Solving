import java.util.LinkedList;
import java.util.Queue;

// 최대시간 1200(20:00)
public class 피부과_sol {
    public int solution(int[] laser, String[] enter) {

        int t = toMin(enter[0].split(" ")[0]),
                ft = t + laser[Integer.parseInt(enter[0].split(" ")[1])],
                answer = 0, idx = 1, exit = 1;

        Queue<Integer> waiting = new LinkedList<>();

        for (; t <= 1200; t++) {

            if (exit == enter.length) break;

            if(idx < enter.length) {
                int enterTime = toMin(enter[idx].split(" ")[0]);
                int laserIdx = Integer.parseInt(enter[idx].split(" ")[1]);

                if (t == enterTime) {
                    waiting.add(laserIdx);
                    idx++;
                }
            }

            if (t >= ft) {
                if(waiting.isEmpty()) continue;
                ft = t + laser[waiting.poll()];
                exit++;
            }

            answer = Math.max(answer, waiting.size());

        }

        return answer;
    }

    private int toMin(String s) {
        return Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
    }

    public static void main(String[] args) {
        피부과2 T = new 피부과2();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
