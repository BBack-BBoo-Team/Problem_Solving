package 함수.셀프넘버_4673;

/* 셀프넘버
time : 156 ms
memory : 14532 KB

입력을 받지 않고 푸는 알고리즘은 처음이라 엄청 헤맸다
재귀함수를 어려워해서 사용을 피했는데 이문제를 풀며
재귀함수의 유용함을 느낄 수 있었다 :)
 */

//33 -> 33+3+3 = 39 -> 39+3+9 = 51 ...
//n으로 d(n)을 찾기 -> noSelfNum() 사용
//d(n)이 되는 경우는 셀프넘버가 아니라고 판단함

public class hong_4673 {
    public static void main(String[] args) {
        boolean[] noSelf = new boolean[10001];  //1-10000까지의 셀프 넘버를 찾아야 되니깐
        //배열의 모든 값은 false를 가짐
        //for문으로 함수를 돌리며 셀프 넘버가 아니면 true로 변환
        for(int i=1; i<noSelf.length; i++){   //1-10000까지
            int num = noSelfNum(i);           //noSelftNum함수의 결과를 num에 넣고
            if(num <= 10000){                 //그 num이 10000보다 작은 경우만 셀프 넘버가 아닌 경우로 체크해줌
                noSelf[num] = true;
            }
        }
        for(int j=1; j<noSelf.length; j++){   //false의 값만 출력해주기
            if(noSelf[j] == false) {
                System.out.println(j);
            }
        }
    }

    //생성자가 있으면 셀프 넘버가 아님
    //셀프 넘버가 아니면 자신과 자신을 구성하는 숫자들의 1의 자리로 만들어 모두 더한 값 !
    public static int noSelfNum(int x) {
        int sum = x;
        while(x != 0){
            sum += ( x % 10);
            x /= 10;
        }
        return sum;   //여기서 결과로 나왔다는 것은 셀프넘버가 아니라는 의미

    }
}
