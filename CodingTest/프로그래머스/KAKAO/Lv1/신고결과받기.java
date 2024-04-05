package 프로그래머스.KAKAO.Lv1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 신고결과받기 {
    public static int[] solution(String[] id_list, String[] report, int k) {
	    int[] answer = {};
	    answer = new int[id_list.length];

		Map<String, HashSet<String>> reportedMap = new HashMap<>();
		Map<String, Integer> answerMap = new HashMap<>(); 


		for (int i = 0; i < id_list.length; i++) {
			HashSet<String> reportingId = new HashSet<>();
			reportedMap.put(id_list[i], reportingId); 
			answerMap.put(id_list[i], 0); 
		}

		for (String s : report) {
			String[] reportStr = s.split(" ");
			String reportingID = reportStr[0]; 
			String reportedID = reportStr[1];
			reportedMap.get(reportedID).add(reportingID); 
		}

		for (String reportedUser : reportedMap.keySet()) { 
			HashSet<String> userForSend = reportedMap.get(reportedUser); 
			if (userForSend.size() >= k) { 
				for (String userId : userForSend) {
					answerMap.put(userId, answerMap.get(userId) + 1); 
				}
			}
		}


		for (int i = 0; i < id_list.length; i++) {
			answer[i] = answerMap.get(id_list[i]);
		}

		return answer;
	}
}
