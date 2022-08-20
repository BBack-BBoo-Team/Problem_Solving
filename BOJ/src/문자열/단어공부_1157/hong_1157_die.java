package 문자열.단어공부_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class hong_1157_die {
/* 단어 공부
time :
memory :
1. bufferedreader로 입력 받기
2. toUpper()로 대문자 변경
3. StringTokenizer로 문자열 분리
4. "키:값" 형태로 저장할 수 있는 것 선언
5. 반복문으로 각 문자열 하나씩 비교하며 문자열 개수 카운트
6. 가장 큰 개수를 가지는 키 반환환 */


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().toUpperCase();
        StringTokenizer st = new StringTokenizer(str, "");
        String[] arr = new String[st.countTokens()];
        for(int i=0; i< st.countTokens(); i++) {
            arr[i] = st.nextToken();
        }

        Map<String, Integer> temp = new HashMap<>();

        for(int i=1; i<arr.length; i++){
            String base = arr[i];
            int count = 0;
            for(int j=0; j<arr.length; j++){
                if(base.equals(arr[j])){
                    count++;
                }
            }
            temp.put(arr[i],count);
        }
        String result = "";

/*        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };
        Map.Entry<String, Integer> max = Collections.max(temp.entrySet(), comparator);*/
        Integer maxim = Collections.max(temp.values());
        System.out.println(result);
    }
}


// 시류ㅐㅁㄹ;아ㅓㄴ실패