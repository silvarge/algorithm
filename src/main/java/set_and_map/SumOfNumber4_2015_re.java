package set_and_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SumOfNumber4_2015_re {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    // 누적합 배열
    long[] arr = new long[N+1];

    // 개수 세기용
    Map<Long, Long> map = new HashMap<>();
    map.put(0L, 1L);  // 일단 0이 1번 나왔다는 사실
    long result = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      // 누적합 채우기
      arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());

      // i까지의 누적합을 기준으로, arr[i] - arr[j] = K 라는 누적합을 가진 시점이 몇 번 있었는지 세기
      result += map.getOrDefault(arr[i] - K, 0L);

      // 지금까지 나온 누적합의 빈도 수를 저장
      map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1);
    }
    // 결과 출력
    System.out.println(result);
  }

}
