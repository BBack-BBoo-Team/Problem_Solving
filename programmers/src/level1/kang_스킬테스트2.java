package level1;

// a[0]*b[0] + a[1]*b[1] + ... + a[n]*b[n]
public class kang_스킬테스트2 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
