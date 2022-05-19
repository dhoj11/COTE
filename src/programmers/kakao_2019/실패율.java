import java.util.*;

public class 실패율 {
    public static int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        double[] failureRate = new double[N];

        for(int i=1; i<=N; i++){

            int reachedStagePlayer = 0; // 스테이지에 도달한 플레이어 수
            int notClearPlayer = 0; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수

            for (int j : stages){
                if( i <= j){
                    reachedStagePlayer++;
                }
                if( i == j){
                    notClearPlayer ++;
                }
            }

            if(notClearPlayer==0){
                failureRate[i-1] = 9999999;
            }else{
                failureRate[i-1] = reachedStagePlayer*1.0/notClearPlayer*1.0;
            }
        }

        // 스테이지(key) 실패율(value)
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        int i = 1;
        for(double a : failureRate){
            map.put(i, failureRate[i-1]);
            i++;
        }

        // 맵의 값을 기준으로 내림차순 정렬하여 key값을 배열에 저장
        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
        int j=0;
        for(Integer key : keySetList) {
            answer[j] = key;
            j++;
        }

        return answer;
    }
}
