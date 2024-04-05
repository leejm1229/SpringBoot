package 프로그래머스.KAKAO.Lv2;

import java.util.ArrayList;
import java.util.List;

public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {   
        int answer = 0;
        long sumQ1 = 0;
        long sumQ2 = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < queue1.length; i++) {
            sumQ1 += queue1[i];
            sumQ2 += queue2[i];
            list.add(queue1[i]);
        }

        for (int i = 0; i < queue2.length; i++) {
            list.add(queue2[i]);
        }

        long target = (sumQ1 + sumQ2) / 2;
        int queue1Idx = 0;
        int queue2Idx = (queue1.length + queue2.length) / 2;

        while (!(sumQ1 == target)) {
            if(queue1Idx >= list.size() || queue2Idx >= list.size()) {
                answer = -1;
                break;
            }
            if (sumQ1 < sumQ2) {
                sumQ2 -= list.get(queue2Idx);
                sumQ1 += list.get(queue2Idx);
                queue2Idx++;
            } else {
                sumQ1 -= list.get(queue1Idx);
                sumQ2 += list.get(queue1Idx);
                queue1Idx++;
            }
            answer++;
        }
        return answer;
    }
}
