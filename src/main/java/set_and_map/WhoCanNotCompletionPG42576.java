package set_and_map;

import java.util.HashMap;
import java.util.Map;

public class WhoCanNotCompletionPG42576 {

  public String solution(String[] participant, String[] completion) {
    String answer = "";

    Map<String, Integer> pMap = new HashMap<>();

    // 참여자 이름을 Key로, 참여자 수를 Value로 집어넣음
    for (String p :participant) {
      if(pMap.containsKey(p)) {
        pMap.put(p, pMap.get(p) + 1);
      }else {
        pMap.put(p, 1);
      }
    }

    // 완주자 만큼 수를 뺌
    for (String c: completion) {
      if(pMap.get(c) != 0) {
        pMap.put(c, pMap.get(c) - 1);
      }
    }

    // Map을 돌면서 0이 아닌 값을 찾음
    for (String key: pMap.keySet()) {
      if (pMap.get(key) != 0) {
        answer = key;
        break;
      }
    }

    return answer;
  }

}
