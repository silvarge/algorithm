package set_and_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class NumberCard10815 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    Set<Integer> cardList = new HashSet<>();
    for (int i = 0; i < n; i++) {
      cardList.add(Integer.parseInt(st.nextToken()));
    }

    int m = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
    st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      int key = Integer.parseInt(st.nextToken());
      sb.append(cardList.contains(key) ? 1: 0).append(" ");
    }
    System.out.println(sb);
  }
}
