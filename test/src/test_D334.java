import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test_D334 {
   private static final Logger logger = Logger.getLogger(test_D334.class.getName());

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
      if (inputLines.size() < 7) {
         throw new IllegalArgumentException("入力データが不足しています。7行必要です。");
      }

      String[] Line1 = inputLines.get(0).split(" ");
      int p_1 = Integer.parseInt(Line1[0]);

      String[] Line2 = inputLines.get(1).split(" ");
      int p_2 = Integer.parseInt(Line2[0]);

      String[] Line3 = inputLines.get(2).split(" ");
      int p_3 = Integer.parseInt(Line3[0]);

      String[] Line4 = inputLines.get(3).split(" ");
      int p_4 = Integer.parseInt(Line4[0]);

      String[] Line5 = inputLines.get(4).split(" ");
      int p_5 = Integer.parseInt(Line5[0]);

      String[] Line6 = inputLines.get(5).split(" ");
      int p_6 = Integer.parseInt(Line6[0]);

      String[] Line7 = inputLines.get(6).split(" ");
      int p_7 = Integer.parseInt(Line7[0]);

      return p_1 + p_2 + p_3 + p_4 + p_5 + p_6 + p_7;
   }
}