package 프로그래머스.KAKAO.Lv1;

public class 숫자문자열과영단어 {
    public int solution(String s) {
        String[] convert = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < convert.length; i++) {
            s = s.replaceAll(convert[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s);
    }
}
