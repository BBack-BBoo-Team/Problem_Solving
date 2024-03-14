import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
stream 적용해보았다. 10배 더 느려졌다.
stream을 이렇게 사용할 수 있구나 하고 공부만 하자
단일 쓰레드에선 비효율적인듯..
*/
class Solution {
    
    class Genre implements Comparable<Genre> {
        
        String name;
        int totalPlay;
        
        Genre(String name, int totalPlay) {
            this.name = name;
            this.totalPlay = totalPlay;
        }
        
        public String getName() {
            return this.name;
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
        
        public int getIndex() {
            return this.index;
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
        IntStream.range(0, leng)
            .forEach(i -> {
                String genre = genres[i];
                int play = plays[i];
                totalPlayMap.merge(genre, play, Integer::sum);

                musicMapByGenre
                    .computeIfAbsent(genre, g -> new PriorityQueue<>())
                    .offer(new Music(i, play));
            });
        
        // 총 재생수 map -> pq에 저장하여 play 수로 정렬
        PriorityQueue<Genre> totalPQ = totalPlayMap.entrySet().stream()
            .map(e->new Genre(e.getKey(), e.getValue()))
            .collect(Collectors.toCollection(PriorityQueue::new));
        
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
        
        // 결과 리스트 -> 반환 타입 변환    
        return answerList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
