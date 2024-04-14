package 프로그래머스.KAKAO.Lv1;

public class 다트게임 {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];                   
        char[] charArr = dartResult.toCharArray();  
        int idx = -1;                              
        
        for (int i=0; i<charArr.length; i++) {
            if (charArr[i] >= '0' && charArr[i] <= '9') {
                idx++; 
                score[idx] += Integer.parseInt(String.valueOf(charArr[i])); 
                if (charArr[i] == '1' && charArr[i+1] == '0') {     
                    score[idx] -= Integer.parseInt(String.valueOf(charArr[i]));
                    score[idx] = 10;
                    i++;    		
                }
            } else if (charArr[i] == 'D') {
                score[idx] = (int) Math.pow(score[idx],2);
            } else if(charArr[i] == 'T') {
                score[idx] = (int) Math.pow(score[idx],3);
            } else if (charArr[i] == '*') { 
                if (idx > 0) score[idx-1] *=2;
                score[idx] *= 2;
            } else if (charArr[i] == '#') { 
                score[idx] *= -1;
            }
        }
        answer = score[0] + score[1] + score[2];
        return answer;
    }
}