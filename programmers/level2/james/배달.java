import java.util.*;

public class 배달 {

  public static void main(String[] args) {
      배달 test = new 배달();

      System.out.println(test.solution(5, new int[][]{{1,2,1},{2,3,3}, {5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3)); // 4
      System.out.println(test.solution(6, new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4)); // 4
  }

  class Edge implements Comparable<Edge> {

      int target;
      int time;

      public Edge(int target, int time) {
          this.target = target;
          this.time = time;
      }

      @Override
      public int compareTo(Edge o) {
          return this.time - o.time;
      }
  }

  int[] dist; // 거리 배열
  ArrayList[] graph; // 마을 정보 그래프 리스트

  // index 0= dummy
  public int solution(int N, int[][] road, int K) {

      dist = new int[N+1];
      dist[1] = 0;
      for (int i = 2; i <= N; i++) {
          dist[i] = Integer.MAX_VALUE;
      }
      graph = new ArrayList[N+1];
      for(int i = 1; i <= N; i++) graph[i] = new ArrayList<Edge>();
      for (int i = 0; i < road.length; i++) {
          int from = road[i][0];
          int to = road[i][1];
          int time = road[i][2];

          graph[from].add(new Edge(to, time));
          graph[to].add(new Edge(from, time));
      }

      // 다익스트라
      dikjstra();
      // dist 순회하면서 K 이하 cnt 후 반환
      return getCnt(K);
  }

  void dikjstra() {

      PriorityQueue<Edge> pq = new PriorityQueue<>();
      pq.add(new Edge(1,0));

      while(!pq.isEmpty()) {

          Edge curr = pq.poll();
          ArrayList<Edge> list = graph[curr.target];

          for(Edge next : list) {

              int nextIdx = next.target;
              if (dist[nextIdx] < next.time) continue;

              if (curr.time + next.time < dist[nextIdx]) {

                  dist[nextIdx] = curr.time + next.time;
                  pq.add(new Edge(nextIdx, dist[nextIdx]));
              }
          }
      }
  }

  int getCnt(int K) {
      int cnt = 0;
      for (int i = 1; i < dist.length; i++) {
          if (dist[i] > K) continue;
          cnt++;
      }
      return cnt;
  }
}
