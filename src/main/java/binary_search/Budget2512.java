package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Budget2512 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] requestBudget = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    int low = 0;
    int high = -1;  // 예산의 최대 금액
    // 요청 예산 배열에 받기
    for (int i = 0; i < N; i++) {
      requestBudget[i] = Integer.parseInt(st.nextToken());
      high = Math.max(high, requestBudget[i]);
    }

    int M = Integer.parseInt(br.readLine());  // 국가 예산의 총액

    // 이진 탐색 시작: 상한 예산(mid)을 조정하면서 총합이 M을 넘지 않도록 함
    // 좌/우 포인터 수가 역전이 되지 않을 때까지 (상한선과 하한선이 역전되지 않을 때까지)
    // 중간 값을 찾거나, 요청 예산 중 최대 금액 이상이 되어도 괜찮은 상황이 되었다면 반복 탈출
    while (low <= high) {
      int mid = (high + low) / 2;   // 중앙 값을 구함 (상한 예산 후보)
      long totalBudget = 0;         // 계산 총액

      // 각 지방 요청 예산을 상한선 기준으로 합산하기
      for (int i = 0; i < N; i++) {
        // 중앙 값보다 작으면 예산 그대로 반영, 크면 중앙 값을 반영
        totalBudget += Math.min(requestBudget[i], mid);
      }

      if (totalBudget > M) {
        // 총합이 예산을 초과하면 상한선을 낮춤
        high = mid - 1;
      } else {
        // 총합이 예산을 초과하지 않으면 하한선을 높여 더 큰 값을 탐색
        low = mid + 1;
      }

    }

    System.out.println(high);

  }

}
