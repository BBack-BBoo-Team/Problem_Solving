package 문자열.그룹단어체크_1316;


import java.util.Scanner;

/*  1.그룹 단어가 아닌 단어만 골라내고 맞는 그룹단어 개수만 카운트하자
    2.첫번째 문자와 첫번쨰 문자 +1을 비교하기
    3.만약 같다면 넘어가고
    4.다르다면 이전 배열에서 같은 문자가있는지 확인 없다면 넘어가

 */
public class LEE_1316 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 단어 갯수 입력
        int count = 0;        // 결과가 들어갈 count

        //변환과정 for문
        for (int i=0; i<N; i++) {  // 입력한 N만큼 반복
            String word = sc.next();  // 문자 입력
            char[] charWord  = word.toCharArray(); // 입력받은 문자 char 타입배열로 변환
            int noGroup = 0;
            //그룹 단어인지 확인하는 for문
            for(int j=0; j< charWord.length-1; j++){  // 배열-1만큼 반복할꺼다.

                if(charWord[j] != charWord[j+1]){       // 만약 j랑j+1이 다르다면
                    for(int k=0; k<j; k++){             // 지금까지 지나 온 문자중에 k와 같은 문자가 있나 확인하기
                        if(charWord[k] == charWord[j+1]){
                            noGroup++;                  // 만약 같은 단어가 있다면 noGroup에 1더해주고 for문 종료
                            break;
                        }
                    }
                }
            }
            if(noGroup == 0){  //그룹 단어인지 확인하는 for문에 걸리지 않았다면 그 문자는 그룹문자이기 떄문에 count해준다.
                count++;
            }
        }
        System.out.println(count);
    }
}
