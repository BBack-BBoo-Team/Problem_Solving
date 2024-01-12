import java.util.*;

Class Solution {
  public int solution(int[][] meetings) {
    ArrayList<int[]> list = new ArrayList<>();
    for(int[] x : meetings) {
      list.add(new int[]{x[0],1});
      list.add(new int[]{x[1],2});
    }
    list.sort((a,b) -> a[0]==b[0] ? b[1] - a[1] : a[0] - b[0]);
    int answer = 0, cnt =0;
    for(int[] x : list) {
      if(x[1]==1) cnt++;
      else cnt--;
      answer = Math.max(answer, cnt);
    }
    return answer;
  }
}
