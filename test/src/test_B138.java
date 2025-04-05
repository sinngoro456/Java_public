import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test_B138 {
   private static final Logger logger = Logger.getLogger(test_B138.class.getName());

   // public static void main(String[] args) {
   // Scanner scanner = new Scanner(System.in); // 標準入力を読み取る
   // List<String> inputLines = new ArrayList<>();

   // // 標準入力からすべての行を読み取る
   // while (scanner.hasNextLine()) {
   // inputLines.add(scanner.nextLine());
   // }

   // try {
   // int result = processInput(inputLines);
   // System.out.println(result);
   // } catch (IllegalArgumentException e) {
   // logger.severe("エラー: " + e.getMessage());
   // }
   // }

   public static void main(String[] args) {
      Path directoryPath = Paths.get("C:\\prog\\Java\\Java_public\\test\\testcase");

      try {
         // ディレクトリ内のすべての .txt ファイルを取得
         try (DirectoryStream<Path> txtFiles = Files.newDirectoryStream(directoryPath, "*.txt")) {
            for (Path filePath : txtFiles) {
               System.out.println("処理中のファイル: " + filePath);

               // ファイル内容を読み込む
               List<String> inputLines = Files.readAllLines(filePath);

               try {
                  // processInput を実行
                  int result = processInput(inputLines);
                  System.out.println(result);
               } catch (IllegalArgumentException e) {
                  logger.severe("エラー: " + e.getMessage());
               }
            }
         }
      } catch (IOException e) {
         logger.log(Level.SEVERE, "ディレクトリまたはファイルの読み込み中にエラーが発生しました", e);
      }
   }

   private static int processInput(List<String> inputLines) {
      if (inputLines.size() < 2) {
         throw new IllegalArgumentException("入力データが不足しています。少なくとも2行必要です。");
      }

      String[] Line1 = inputLines.get(0).split(" ");
      int H = Integer.parseInt(Line1[0]); // 行数
      int W = Integer.parseInt(Line1[1]); // 列数

      if (inputLines.size() < H + 1) {
         throw new IllegalArgumentException("入力データが不足しています。指定された行数に対応するデータがありません。");
      }

      // 二次元配列を初期化
      char[][] grid = new char[H][W];

      // 2行目以降を1文字ずつ二次元配列に格納
      for (int i = 0; i < H; i++) {
         String line = inputLines.get(1 + i); // 2行目以降
         if (line.length() != W) {
            throw new IllegalArgumentException("行の長さが指定された列数と一致しません: " + line);
         }
         grid[i] = line.toCharArray(); // 1文字ずつ配列に格納
      }

      // // 二次元配列の内容を確認（デバッグ用）
      // for (char[] row : grid) {
      // System.out.println(Arrays.toString(row));
      // }
      int numDonut = 0;
      for (int i = 1; i < H - 1; i++) {
         for (int j = 1; j < W - 1; j++) {
            if (grid[i][j] == '.') {
               // 上下左右のマスを確認
               if (grid[i - 1][j - 1] == '#' && grid[i - 1][j] == '#' && grid[i - 1][j + 1] == '#'
                     && grid[i][j - 1] == '#' && grid[i][j + 1] == '#'
                     && grid[i + 1][j - 1] == '#' && grid[i + 1][j] == '#' && grid[i + 1][j + 1] == '#') {
                  numDonut++;
               }
            }
         }
      }

      return numDonut;
   }
}