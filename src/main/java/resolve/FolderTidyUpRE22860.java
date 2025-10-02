package resolve;

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

// 1. 폴더와 파일을 어떻게 구분할까?
// 2. 결론적으로 필요한 것은 파일의 종류 개수와 파일의 총 개수

public class FolderTidyUpRE22860 {

  // 폴더 Tree
  static Map<String, List<String>> folderTree = new HashMap<>();

  // 탐색 관련
  static Set<String> fileType;  // 파일 종류 (파일명 중복되지 않도록)
  static int totalFile; // 파일 총 개수

  static StringBuilder sb;

  // 폴더의 하위에 있는 파일의 종류와 개수를 찾는 거니까 깊이 우선 탐색
  static void dfs(String target) {
    if (!folderTree.containsKey(target)) {
      // 파일 트리에 더 이상 타겟이 존재하지 않을 때
      return;
    }

    // 대상 폴더의 하위 폴더들을 파고들며 탐색
    for (String child : folderTree.get(target)) {
      if (folderTree.containsKey(child)) {
        // child가 하위 폴더라면 Map으로 정의해 뒀을 것
        dfs(child);
      } else {  // 파일일 때
        fileType.add(child);
        totalFile++;
      }
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int Fo = Integer.parseInt(st.nextToken());
    int Fi = Integer.parseInt(st.nextToken());

    // 폴더 Tree에 구조 저장
    String parent, child, type;
    for (int i = 0; i < Fo + Fi; i++) {
      // 입력받기
      st = new StringTokenizer(br.readLine());
      parent = st.nextToken();
      child = st.nextToken();
      type = st.nextToken();

      // 파일이든 폴더든 부모 리스트에 저장
      folderTree.putIfAbsent(parent, new ArrayList<>());  // 부모가 혹시라도 없으면 새 List 생성하여 저장
      folderTree.get(parent).add(child);

      if (type.equals("1")) { // 폴더라면
        folderTree.putIfAbsent(child, new ArrayList<>());
      }
    }

    // 경로 입력 받아서 저장
    int Q = Integer.parseInt(br.readLine());
    sb = new StringBuilder();
    for (int i = 0; i < Q; i++) {
      fileType = new HashSet<>();
      totalFile = 0;
      String[] temp = br.readLine().split("/");
      dfs(temp[temp.length - 1]);
      sb.append(fileType.size()).append(" ").append(totalFile).append("\n");
    }

    System.out.println(sb);
  }

}
