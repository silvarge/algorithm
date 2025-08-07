package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 초기값을 String 형태로 저장 (입력값이 1 2 3 / 4 5 6 / 7 8 0 이면, "123456780" 으로 저장)
 * <p>
 * 2. 모양에 대해서 몇 번의 이동을 거쳐야 하는지에 대해 저장할 HashMap 생성 (key가 퍼즐의 상태, value가 그 상태가 되기까지의 이동 수)
 * <p>
 * 3. '0' 인덱스를 찾아 그 주변 상/하/좌/우로 위치 변경하며 탐색 수행 (새로 나타난 상태(key)라면 그 값에 대하여 Map에 저장)
 * <p>
 * 4. '123456780' 이 나오면 count에 그때까지의 이동 수를 반환, 탐색이 끝나고도 원하는 값이 나오지 않았다면 -1 반환
 */
public class Puzzle1525 {

  static int result = -1;

  // 상하좌우를 표현하기 위한 좌표계 설정
  // 상: (0, 1) / 하: (0, -1) / 좌: (-1, 0) / 우: (1, 0)
  static int[] dx = {0, 0, -1, 1};  // 상, 하, 좌, 우
  static int[] dy = {1, -1, 0, 0};

  // 상태 저장용 HashMap
  static HashMap<String, Integer> puzzleStatus = new HashMap<>();

  // StringBuilder (좀 더 빠르게 문자열 저장하기 위함)
  static StringBuilder sb = new StringBuilder();

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 초기값을 String으로 변환하여 저장
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        sb.append(Integer.parseInt(st.nextToken()));
      }
    }

    puzzleStatus.put(sb.toString(), 0);
    // 탐색 시작
    search(sb.toString());

    // 결과 출력
    System.out.println(result);

  }

  static void search(String target) {
    Queue<String> queue = new LinkedList<>();

    // 시작 노드 등록
    queue.add(target);

    // 큐가 빌 때까지 반복
    while (!queue.isEmpty()) {
      // 현재 상태 가젹오기
      String polled = queue.poll();
      // '0' 값 (이동시켜야 하는 값)의 인덱스 위치 찾기
      int zeroIdx = polled.indexOf('0');

      // 123456780 배열의 상태가 되면 이동 횟수를 결과 값에 넣고 함수 종료
      if (polled.equals("123456780")) {
        result = puzzleStatus.get(polled);
        return;
      }

      // 상하좌우로 이동하기
      for (int dir = 0; dir < 4; dir++) {
        // 0이 상/하/좌/우 로 이동했을 때 위치 세팅
        int pc = zeroIdx % 3 + dy[dir]; // 행 (가로)
        int pr = zeroIdx / 3 + dx[dir]; // 열 (세로)

        // 상하좌우 이동 시 3x3을 벗어나면 그냥 넘기기
        if (pr < 0 || pr >= 3 || pc < 0 || pc >= 3) {
          continue;
        }

        // 위치 변경
        int tempZeroIdx = pr * 3 + pc;
        StringBuilder tempSb = new StringBuilder(polled);
        // 0이 들어가야 할 곳에 있던 값을 가져와 기존 0이 있던 곳에 넣어줌
        char changeTarget = tempSb.charAt(tempZeroIdx);
        tempSb.setCharAt(zeroIdx, changeTarget);
        // 0이 들어가야 할 곳에 0을 넣어줌
        tempSb.setCharAt(tempZeroIdx, '0');

        // 퍼즐 상태 저장소에 해당 상태가 존재하지 않는다면 저장
        if (!puzzleStatus.containsKey(tempSb.toString())) {
          queue.add(tempSb.toString()); // 큐에 값 넣음 (루트 저장)
          puzzleStatus.put(tempSb.toString(), puzzleStatus.get(polled) + 1);  // 기존 이동 횟수 + 1
        }
      }
    }
  }

}
