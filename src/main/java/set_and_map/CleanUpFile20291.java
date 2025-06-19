package set_and_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CleanUpFile20291 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      String exp = br.readLine().split("\\.")[1];
      if (map.containsKey(exp)) {
        map.put(exp, map.get(exp) + 1);
      } else {
        map.put(exp, 1);
      }
    }

    List<String> keyList = map.keySet().stream().sorted().collect(Collectors.toList());

    for (String key : keyList) {
      sb.append(key).append(" ").append(map.get(key)).append("\n");
    }

    System.out.print(sb);

  }

}
