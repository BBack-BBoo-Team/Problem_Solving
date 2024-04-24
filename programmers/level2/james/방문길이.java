import java.util.*;

class Solution {
    
    class Edge {
        int fromX;
        int fromY;
        int toX;
        int toY;
        
        public Edge(int fromX, int fromY, int toX, int toY) {
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }
    }
    
    class Node {
        int x, y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static ArrayList<Edge> list;
    
    public int solution(String dirs) {
        list = new ArrayList<>();
        HashMap<Character, Node> direction = new HashMap();
        
        direction.put('L', new Node(-1, 0));
        direction.put('R', new Node(1, 0));
        direction.put('U', new Node(0, 1));
        direction.put('D', new Node(0, -1));
        
        Node curr = new Node(0,0);
        
        for(char ch : dirs.toCharArray()) {
            Node temp = direction.get(ch);
            int newX = curr.x + temp.x;
            int newY = curr.y + temp.y;
            
            if(isInValid(newX, newY)) continue;
            if(isFirstLine(curr.x, curr.y, newX, newY)) {
                list.add(new Edge(curr.x, curr.y, newX, newY));
            }
        
            curr = new Node(newX, newY);
        }
        return list.size();
    }
    
    private boolean isInValid(int x, int y) {
        return x>5 || y>5 || x<-5 || y<-5;
    }
    
    // 이미 방문한 길인지 체크
    private boolean isFirstLine(int currX, int currY, int nextX, int nextY) {
        
        for(Edge edge : list) {
            if(currX == edge.fromX && currY == edge.fromY && nextX == edge.toX && nextY == edge.toY) return false;
            if(currX == edge.toX && currY == edge.toY && nextX == edge.fromX && nextY == edge.fromY) return false;
        }
        return true;
    }
}
