package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 멀티탭에 자리가 있는 경우 -> 그냥 집어넣으면 된다
 * <p>
 * 2. 이미 멀티탭에 꽂혀 있는 경우 -> 넘기면 된다
 * <p>
 * 3. 멀티탭에 자리가 없는 경우
 * <p>
 * 3.1 이후 사용하지 않을 전자기기가 꽂혀 있는 경우 -> 사용하지 않을 전자기기를 빼면 됨
 * <p>
 * 3.2 모든 전자기기가 사용할 예정인 경우 -> 가장 나중에 사용할 전자기기를 제거하면 됨
 */

public class PluginScheduling1700 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍의 개수
    int K = Integer.parseInt(st.nextToken()); // 전기용품 총 사용 횟수

    st = new StringTokenizer(br.readLine());

    // 멀티탭을 사용할 전자기기 순서 저장
    List<Integer> orderList = new ArrayList<>();

    // 멀티탭
    List<Integer> multiTap = new ArrayList<>();
    // 교체 횟수
    int count = 0;

    // 사용할 순서 등록
    for (int i = 0; i < K; i++) {
      orderList.add(Integer.parseInt(st.nextToken()));
    }

    // 전자기기를 모두 사용할 때까지 반복
    while (!orderList.isEmpty()) {
      int order = orderList.remove(0);  // 사용할 값 반환

      // 멀티 탭에 해당 전자기기가 이미 꽂혀 있는 경우
      if (multiTap.contains(order)) {
        continue;
      }

      // 멀티 탭에 자리가 있는 경우
      if (multiTap.size() < N) {
        multiTap.add(order);
      } else {  // 멀티 탭에 자리가 없는 경우
        count++;  // 어쨌든 교체하니까 우선 계산
        boolean flag = false;
        int idx = -1;
        int priorIdx = -1; // 삭제 시 우선 순위를 가지는 전자 기기(가장 후순위에 쓰이는 기기 번호)
        for (int i = 0; i < multiTap.size(); i++) {
          // 1. 이후 사용하지 않을 전자기기가 있는 경우
          if (!orderList.contains(multiTap.get(i))) {
            flag = true;
            multiTap.remove(i);   // 사용하지 않을 전자 기기 플러그 빼고
            multiTap.add(order);  // 사용해야 하는 전자 기기 플러그 꽂기
            break;
          } else {   // 2. 모두 사용될 예정인 전자기기인 경우
            // 멀티 탭에 꽂혀있는 전자 기기 중 가장 후순위에서야 사용되는 번호 찾기
            // 기기 사용 순서가 가장 큰(후인) 값 찾기
            if (orderList.indexOf(multiTap.get(i)) > idx) {
              idx = orderList.indexOf(multiTap.get(i));   // 꽂혀 있는 전자 기기가 몇 번째 순서에 있는지 넣기
              priorIdx = i;
            }
          }
        }
        // 모두 사용될 예정이라 삭제 우선순위 계산 후 삭제
        if (!flag) {
          multiTap.remove(priorIdx);
          multiTap.add(order);
        }
      }
    }

    System.out.println(count);

  }

}
