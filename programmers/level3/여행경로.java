
import java.util.*;

// point
// 1) 항공권 모두 이용
// 2) ICN 시작
// 3) 방문지는 티켓+1 
class Solution {
    
    private static final String START_AIRPORT = "ICN";
    
    boolean[] isUsedTicket;
    ArrayList<String> resultList;
    
    public String[] solution(String[][] tickets) {
        int ticketCnt = tickets.length;
        isUsedTicket = new boolean[ticketCnt];
        resultList = new ArrayList<>();
        String[] answer = new String[ticketCnt];
        dfs(0, ticketCnt, START_AIRPORT, tickets, START_AIRPORT);
        
        return resultList.stream()
            .sorted()
            .findFirst()
            .map(s->s.split(" ")).get();
    }
    
    void dfs(int useCnt, int ticketCnt, String from, String[][] tickets, String result) {
        if(useCnt==ticketCnt) {
            resultList.add(result);
            return;
        }
        
        for(int i = 0; i < ticketCnt; i++) {
            if(!from.equals(tickets[i][0])) continue;
            if(isUsedTicket[i]) continue;
            isUsedTicket[i] = true;
            String to = tickets[i][1];
            dfs(useCnt+1, ticketCnt, to , tickets, result.concat(" " + to));
            isUsedTicket[i] = false;
        }
    }
}
