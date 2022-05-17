package programmers.kakao_2022;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        // 중복제거
        LinkedHashSet<String> DeduplicationReport = new LinkedHashSet<>(Arrays.asList(report));

        Map<String, Integer> reportedCount = new LinkedHashMap<>();
        Map<String, Integer> mailedCount = new LinkedHashMap<>();

        // 초기화
        for(String id : id_list){
            reportedCount.put(id, 0);
            mailedCount.put(id, 0);
        }

        // 신고당한 횟수
        for(String item : DeduplicationReport){
            String[] split_str = item.split(" ");
            reportedCount.replace(split_str[1], reportedCount.get(split_str[1]) +1);
        }

        // 메일받은 횟수
        for(String item : DeduplicationReport){
            String[] split_str = item.split(" ");
            if( reportedCount.get(split_str[1]) >= k ) {
                mailedCount.replace(split_str[0], mailedCount.get(split_str[0]) + 1);
            }
        }

        int i = 0;
        for(Integer value : mailedCount.values()){
            answer[i] = value;
            i++;
        }

        return answer;
    }
}
