import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class NnM1 {
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    List<Integer> list = new ArrayList<>();

    backTracking(list, n, m);
  }

  public static void backTracking(List<Integer> list, int n, int m){
    if(list.size() == m) {
      for (int r: list) {
        System.out.print(r + " ");
      }
      System.out.println();
    }

    for (int i = 1; i <= n; i++) {
      if (!list.contains(i)) {
        list.add(i);
        backTracking(list, n, m);
        list.remove(list.size()-1);
      }
    }
  }
}
