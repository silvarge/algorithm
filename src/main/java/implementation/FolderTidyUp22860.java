package implementation;

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

public class FolderTidyUp22860 {

  // <폴더명, 하위 폴더/파일 이름 리스트>
  static Map<String, List<String>> fileTree = new HashMap<>();
  static int fileCount;
  static Set<String> fileTypes;

  static void dfs(String target) {
    // fileTree에 대상 폴더명이 없다면 종료
    if (!fileTree.containsKey(target)) {
      return;
    }

    // 파일 트리에 대상 폴더명이 존재 -> 그 하위 폴더에 대하여 조사
    for (String child : fileTree.get(target)) {
      // 하위 폴더가 존재 -> 탐색
      if (fileTree.containsKey(child)) {
        dfs(child);
      } else {
        // 파일 트리에서 Key로 쓰이지 않음 == 파일이라는 의미
        fileTypes.add(child);
        fileCount++;
      }
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    // 입력받을 폴더/파일 개수
    int folder = Integer.parseInt(st.nextToken());
    int file = Integer.parseInt(st.nextToken());

    for (int i = 0; i < folder + file; i++) {
      st = new StringTokenizer(br.readLine());
      String parent = st.nextToken(); // 부모 폴더명
      String child = st.nextToken();  // 자식 폴더 OR 파일명
      int type = Integer.parseInt(st.nextToken());  // 자식이 파일인지(0), 폴더인지(1) 여부

      // 키 값이 존재하면 Map의 Value를 반환하고, 존재하지 않으면 키와 Value를 저장하고 null 반환
      fileTree.putIfAbsent(parent, new ArrayList<>());
      fileTree.get(parent).add(child);  // 부모 폴더의 하위 폴더 리스트에 이름 집어 넣기 (폴더든 파일이든 상관X)

      // 폴더라면
      if (type == 1) {
        // fileTree의 키로 등록
        fileTree.putIfAbsent(child, new ArrayList<>());
      }
    }

    int Q = Integer.parseInt(br.readLine());
    // 파일 개수 세기
    for (int i = 0; i < Q; i++) {
      String[] path = br.readLine().split("/");
      String folderName = path[path.length - 1];  // 찾는 대상 폴더명

      fileCount = 0;
      fileTypes = new HashSet<>();
      dfs(folderName);
      sb.append(fileTypes.size()).append(" ").append(fileCount).append("\n");
    }

    System.out.println(sb);
  }
}
