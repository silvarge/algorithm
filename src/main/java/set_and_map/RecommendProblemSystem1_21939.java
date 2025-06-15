package set_and_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Problem {
  int id;
  int level;

  Problem(int id, int level) {
    this.id = id;
    this.level = level;
  }
}

public class RecommendProblemSystem1_21939 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    // 문제 보관
    Map<Integer, Integer> levelMap = new HashMap<>();

    Queue<Problem> high = new PriorityQueue<>((a, b) -> {
      if (a.level != b.level) return b.level - a.level; // 난이도 내림차순
      return b.id - a.id; // 문제 번호 내림차순
    });

    Queue<Problem> low = new PriorityQueue<>((a, b) -> {
      if (a.level != b.level) return a.level - b.level; // 난이도 오름차순
      return a.id - b.id; // 문제 번호 오름차순
    });

    int N = Integer.parseInt(br.readLine());
    int[] temp;
    Problem p;

    for (int i = 0; i < N; i++) {
      temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      levelMap.put(temp[0], temp[1]);
      p = new Problem(temp[0], temp[1]);
      high.add(p);
      low.add(p);
    }

    int M = Integer.parseInt(br.readLine());
    int solveNum;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "add": {
          int[] add = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
          levelMap.put(add[0], add[1]);
          p = new Problem(add[0], add[1]);
          high.add(p);
          low.add(p);
          break;
        }
        case "recommend": {
          Queue<Problem> target = Integer.parseInt(st.nextToken()) == 1 ? high : low;
          while (!target.isEmpty()) {
            Problem peek = target.peek();
            if (!levelMap.containsKey(peek.id) || !Objects.equals(levelMap.get(peek.id), peek.level)) {
              target.poll();
              continue;
            }
            sb.append(peek.id).append("\n");
            break;
          }
          break;
        }
        case "solved": {
          solveNum = Integer.parseInt(st.nextToken());
          levelMap.remove(solveNum);
          break;
        }
      }
    }
    System.out.println(sb);

  }

}