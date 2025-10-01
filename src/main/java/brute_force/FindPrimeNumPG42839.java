package brute_force;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumPG42839 {

  static Set<Integer> makeNum;    // 만들 수 있는 숫자 저장 (중복 미허용)
  static boolean[] visited = new boolean[7];  // 1이상 7 미만

  public int solution(String numbers) {
    int answer = 0;

    // 숫자 조합 저장
    makeNum = new HashSet<>();  // 새 HashSet 생성
    dfs(numbers, "", 0);    // 깊이 우선 탐색을 통해 가능한 숫자 조합 찾기

    // 소수 판별
    for (int value : makeNum) {
      if (isPrime(value)) {
        answer++;
      }
    }

    return answer;
  }

  // 깊이 우선 탐색
  public static void dfs(String numbers, String numStr, int depth) {
    if (depth == numbers.length()) {
      return;
    }

    for (int i = 0; i < numbers.length(); i++) {
      if (!visited[i]) {   // 방문하지 않았다면 조합 가능한 숫자라는 뜻
        visited[i] = true;  // 방문했다 표시하고
        makeNum.add(Integer.parseInt(numStr + numbers.charAt(i)));  // 조합 가능한 숫자니까 Set에 추가
        dfs(numbers, numStr + numbers.charAt(i),
            depth + 1);    // 추가 조합한 숫자를 이용하여 더 뒤에 붙일 수 있는지 확인하기
        // 백트래킹을 위해서 방문 여부 철회
        visited[i] = false;
      }
    }
  }

  public static boolean isPrime(int n) {
    if (n < 2) { // 1은 소수가 아님
      return false;
    }

    // 소수 판별 - 에라토스테네스의 체 이용
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }
}
