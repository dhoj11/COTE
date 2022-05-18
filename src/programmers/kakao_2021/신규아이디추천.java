package programmers.kakao_2021;

public class 신규아이디추천 {
    public String solution(String new_id) {
        String answer = new_id;

        // 1. 소문자치환
        answer = answer.toLowerCase();

        // 2. 영숫자, -,_,. 외 문자 제거
        answer = answer.replaceAll("[^-_.a-z0-9]", "");

        // 3. 연속된 .. 하나의 . 로 치환
        while(answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

        // 4. 처음이나 끝에오는 . 제거
        if (answer.startsWith(".") ){
            answer = answer.substring(1, answer.length());
        }
        if (answer.endsWith(".")){
            answer = answer.substring(0, answer.length()-1);
        }

        // 5. 빈 문자열일 경우 a 대입
        if (answer.length() == 0){
            answer += "a";
        }

        // 6. 16자 이상이면 15자 까지만 남김
        if (answer.length() >= 15){
            answer = answer.substring(0, 15);
        }

        // 마지막 . 제거
        if (answer.endsWith(".")){
            answer = answer.substring(0, answer.length()-1);
        }

        // 7. 2자 이하면 마지막 문자를 길이가 3까지 반복
        if (answer.length() <= 2){
            String endChar = answer.charAt(answer.length()-1) + "";

            for(int i=answer.length(); i<3 ; i++){
                answer += endChar;
            }
        }

        return answer;
    }
}