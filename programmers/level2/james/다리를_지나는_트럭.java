package level2.james;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {

    public static void main(String[] args) {

        다리를_지나는_트럭 test = new 다리를_지나는_트럭();
        int result = test.solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(result);

        int result2 = test.solution(100, 100, new int[]{10});
        System.out.println(result2);

        int result3 = test.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        System.out.println(result3);

        int result4 = test.solution(5, 5, new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1});
        System.out.println(result4);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int index = 0;

        while (index < truck_weights.length) {
            int currTruck = truck_weights[index];

            if (bridge.isEmpty()) {
                bridge.add(currTruck);
                index++;
                time++;
            } else if (bridge.size() < bridge_length) {

                if (isPermitWeight(getCurrWeightInBridge(bridge), currTruck, weight)) {
                    bridge.add(currTruck);
                    index++;
                    time++;
                } else {
                    bridge.add(0);
                    time++;
                }
            } else {
                bridge.poll();
            }
        }
        return time + bridge_length;
    }

    public int getCurrWeightInBridge(Queue<Integer> bridge) {
        return bridge.stream().mapToInt(a -> a).sum();
    }

    public boolean isPermitWeight(int currWeightInBridge, int currTruckWeight, int limit) {
        return currWeightInBridge + currTruckWeight <= limit;
    }
}
