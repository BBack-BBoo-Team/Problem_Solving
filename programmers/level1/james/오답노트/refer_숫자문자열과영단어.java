package level1.james.오답노트;

/**
 * String 클래스의 replaceAll 메서드 활용
 */
public class refer_숫자문자열과영단어 {

    public int solution(String s) {
        
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i<10; i++) {
            s = s.replaceAll(alphabets[i], digits[i]);
        }

        return Integer.parseInt(s);
    }
}
