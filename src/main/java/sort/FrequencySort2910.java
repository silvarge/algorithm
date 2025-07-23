package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class FrequencySort2910 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    Map<Integer, Integer> map = new LinkedHashMap<>();

    st = new StringTokenizer(br.readLine());
    int temp;
    for (int i = 0; i < N; i++) {
      temp = Integer.parseInt(st.nextToken());
      if (map.containsKey(temp)) {
        map.put(temp, map.get(temp) + 1);
      } else {
        map.put(temp, 1);
      }
    }

    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
    entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

    for (Entry<Integer, Integer> entry : entryList) {
      for (int i = 0; i < entry.getValue(); i++) {
        sb.append(entry.getKey()).append(" ");
      }
    }

    System.out.println(sb);

  }

}
