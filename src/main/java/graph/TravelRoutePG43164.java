package graph;

import java.util.Arrays;

public class TravelRoutePG43164 {

  private static boolean[] used;
  private static String[] route;

  public boolean dfs(String[][] tickets, String start, int depth) {
    // 티켓 수만큼 다 돌았을 때 (모든 티켓을 다 쓰면 성공)
    if (depth == tickets.length) {
      return true;
    }

    // 현재 위치에서 출발하는 모든 티켓 후보 탐색
    for (int i = 0; i < tickets.length; i++) {
      // 티켓을 사용하지 않았고, 출발지가 탐색 대상과 같다면
      if (tickets[i][0].equals(start) && !used[i]) {
        // 사용 처리 + 경로에 티켓 추가 (상태 갱신)
        used[i] = true;
        route[depth + 1] = tickets[i][1];

        // 다음 공항 시작점으로 탐색
        if (dfs(tickets, tickets[i][1], depth + 1)) {
          return true;  // 성공 경로 발견 시, 탐색하지 않고 반환
        }
        // 경로 탐색 중 실패 시 티켓 사용 취소 후 다른 경로 탐색하러 감
        used[i] = false;
      }
    }
    // 탐색을 진행했지만 실패한 경우
    return false;
  }

  public String[] solution(String[][] tickets) {
    // 출발지 -> 도착지, 사전순 티켓 정렬
    Arrays.sort(tickets, (a, b) -> {
      if (!a[0].equals(b[0])) {
        return a[0].compareTo(b[0]);
      }
      return a[1].compareTo(b[1]);
    });

    // 사용된 티켓
    used = new boolean[tickets.length];

    // 경로 저장할 배열
    route = new String[tickets.length + 1];

    // 무조건 인천 출발
    route[0] = "ICN";

    // 탐색 시작
    dfs(tickets, "ICN", 0);

    return route;
  }

}
