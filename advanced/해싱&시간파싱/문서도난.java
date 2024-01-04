
import java.util.Arrays;
import java.util.PriorityQueue;

public class 문서도난 {

    class Informant implements Comparable<Informant> {
        String name;
        int time;

        public Informant(String name, int time) {
            this.name = name;
            this.time = time;
        }


        @Override
        public int compareTo(Informant o) {
            return this.time - o.time;
        }
    }
    int timeFrom, timeTo;
    public String[] solution(String[] reports, String times){
        String[] answer = {};

        timeFrom = toMinute(times.split(" ")[0]);
        timeTo = toMinute(times.split(" ")[1]);

        PriorityQueue<Informant> pq = new PriorityQueue<>();

        for(String data : reports) {
            String name = data.split(" ")[0];
            String time = data.split(" ")[1];
            int timeToMin = toMinute(time);

            if(isInTime(timeToMin)) pq.add(new Informant(name, timeToMin));
        }

        answer = new String[pq.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll().name;
        }
        return answer;
    }

    // 시간 체크 메서드
    boolean isInTime(int curr) {
        return timeFrom <= curr && timeTo >= curr;
    }

    // 시간 format을 분으로 치환
    int toMinute(String time) {

        String h = time.split(":")[0];
        String m = time.split(":")[1];

        return (Integer.parseInt(h)*60)+Integer.parseInt(m);
    }

    public static void main(String[] args){
        문서도난 T = new 문서도난();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
