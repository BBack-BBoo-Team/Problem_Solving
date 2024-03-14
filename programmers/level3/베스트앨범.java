import java.util.*;

class Solution {
    
    class Genre implements Comparable<Genre> {
        
        String name;
        int totalPlay;
        
        Genre(String name, int totalPlay) {
            this.name = name;
            this.totalPlay = totalPlay;
        }
        
        @Override
        public int compareTo(Genre g) {
            return g.totalPlay - this.totalPlay;
        }
    }
    
    class Music implements Comparable<Music> {
        int index;
        int play;
        
        Music(int index, int play) {
            this.index = index;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music m) {
            return this.play == m.play ? this.index - m.index : m.play - this.play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int leng = genres.length;
        HashMap<String, Integer> totalPlayMap = new HashMap<>();
        HashMap<String, PriorityQueue<Music>> musicMapByGenre = new HashMap<>();
        
        // 장르별 총 재생 수, 장르별 음악 정보 저장
        for(int i = 0; i < leng ; i++) {
            String genre = genres[i];
            int play = plays[i];
            totalPlayMap.put(genre, totalPlayMap.getOrDefault(genre, 0)+play);
            
            if(!musicMapByGenre.containsKey(genre))
                musicMapByGenre.put(genres[i], new PriorityQueue<>());
            
            musicMapByGenre.get(genre).offer(new Music(i, play));
        }
        
        // 총 재생수 map -> pq에 저장하여 play 수로 정렬
        PriorityQueue<Genre> totalPQ = new PriorityQueue<>();
        for(String genre : totalPlayMap.keySet()) {
            totalPQ.offer(new Genre(genre, totalPlayMap.get(genre)));
        }
        
        // totalPQ에서 순서대로 genre 출력
        // genre에 해당하는 음악 리스트 출력
        // 음악 리스트에서 최상단 2개까지 추출 후 결과 리스트에 저장, 2개 미만이면 패스
        List<Integer> answerList = new ArrayList<>();
        while(!totalPQ.isEmpty()) {
            String genre = totalPQ.poll().name;
            PriorityQueue<Music> musicPQ = musicMapByGenre.get(genre);
            int pollCnt = 0;
            while(!musicPQ.isEmpty() && pollCnt++ < 2) {
                Music music = musicPQ.poll();
                answerList.add(music.index);
            }
        }
        
        int[] answer = new int[answerList.size()];
        // 결과 리스트 -> 반환 타입 변환
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
                          
        return answer;
    }
}
