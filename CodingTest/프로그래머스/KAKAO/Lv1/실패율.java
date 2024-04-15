package 프로그래머스.KAKAO.Lv1;


class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] players = new int[N+2]; 
        int[] reach = new int[N+2]; 
        double[] failureRates = new double[N]; 

        for (int stage : stages) {
            players[stage]++;
        }

        int totalPlayers = stages.length; 

        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                failureRates[i-1] = 0; 
            } else {
                failureRates[i-1] = (double) players[i] / totalPlayers; 
                totalPlayers -= players[i]; 
            }
            reach[i+1] = players[i] + reach[i]; 
        }

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int maxIndex = 0;
            for (int j = 1; j < N; j++) {
                if (failureRates[j] > failureRates[maxIndex]) {
                    maxIndex = j;
                }
            }
            answer[i] = maxIndex + 1;
            failureRates[maxIndex] = -1; 
        }

        return answer;
    }
}