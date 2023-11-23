import java.io.*;
import java.util.*;

public class 최단경로 {

    static int vertex, edge, start, from, to, cost;

    static int[] dist; // 거리 배열
    static ArrayList[] graph;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        // 1. 거리 배열 최대값 초기화
        dist = new int[vertex+1];
        for (int i = 1; i <= vertex; i++) dist[i] = Integer.MAX_VALUE;

        // 2. graph 배열 내부 ArrayList로 초기화
        graph = new ArrayList[vertex+1];
        for (int i = 0; i <= vertex; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // 3. from, to, weight 를 받고 graph 에 저장
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
        }

        // 4. start 부터 다익스트라 시작
        dijkstra(start);

        // 5. 거리배열에 저장된 데이터들을 StringBuilder 로 append
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < dist.length; i++) {
            int curr = dist[i];
            if(curr==Integer.MAX_VALUE) {
                sb.append("INF\n");
                continue;
            }
            sb.append(curr).append("\n");
        }
        // 6. 출력
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge(start,0));

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();

            // 이미 저장된 가중치 체크
            if(curr.cost > dist[curr.target]) continue;

            int nextCnt = graph[curr.target].size();

            for(int i = 0; i < nextCnt; i++) {
                Edge next = (Edge) graph[curr.target].get(i);

                if (dist[next.target] > curr.cost + next.cost) {
                   dist[next.target] = curr.cost + next.cost;
                   pq.add(new Edge(next.target, dist[next.target]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {

        int target;
        int cost;

        Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {

            return this.cost - o.cost;
        }
    }

}
