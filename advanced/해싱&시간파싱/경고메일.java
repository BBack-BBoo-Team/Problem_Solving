import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 경고메일 {

    public String[] solution(String[] reports, int time){
        String[] answer = {};
        // pq 문자 사전순 정렬 초기 설정
        PriorityQueue<String> pq = new PriorityQueue<>(String::compareTo);

        HashMap<String, Integer> temp = new HashMap<>();
        HashMap<String,Integer> resultMap = new HashMap<>();

        // reports 순회
        for(String data : reports) {
            String name = data.split(" ")[0];
            int times = toMin(data.split(" ")[1]);
            String position = data.split(" ")[2];

            // in일 경우 hashMap에 이름과 시간 무조건 저장
            if(isEnter(position)) temp.put(name, times);
            else resultMap.put(name, resultMap.getOrDefault(name, 0) + (times - temp.get(name)));
        }

        for(String key : resultMap.keySet()) {
            if (resultMap.get(key) > time) pq.add(key);
        }

        answer = new String[pq.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }

    int toMin(String s) {
        return (Integer.parseInt(s.split(":")[0])*60) + Integer.parseInt(s.split(":")[1]);
    }

    // 출입여부 체크, 입장시 true
    boolean isEnter(String s) {
        return s.equals("in");
    }

    public static void main(String[] args){
        경고메일 T = new 경고메일();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
