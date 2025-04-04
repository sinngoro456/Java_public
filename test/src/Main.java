import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    // public static void main(String[] args) {
    // String dirPath = "C:\\prog\\Python\\Python_private\\test\\testcase";
    // try {
    // processAllTextFiles(dirPath);
    // } catch (IOException e) {
    // logger.log(Level.SEVERE, "ディレクトリ処理中にエラーが発生しました", e);
    // }
    // }

    public static void main(String[] args) {
        List<String> inputLines = new ArrayList<>();
        int result = processInput(inputLines);
        System.out.println("結果: " + result);
    }

    // // ファイル処理用メソッド
    // private static void processAllTextFiles(String dirPath) throws IOException {
    // try (Stream<Path> paths = Files.list(Paths.get(dirPath))) {
    // paths.filter(path -> path.toString().endsWith(".txt"))
    // .forEach(Main::processSingleFile);
    // }
    // }

    // private static void processSingleFile(Path filePath) {
    // try {
    // logger.info(() -> "処理開始: " + filePath);
    // List<String> inputLines = Files.readAllLines(filePath);
    // int result = processInput(inputLines);
    // logger.info(() -> "処理完了: " + filePath + " 結果: " + result);
    // System.out.println(filePath.getFileName() + " 結果: " + result);
    // } catch (IOException e) {
    // logger.log(Level.SEVERE, "ファイル処理エラー: " + filePath, e);
    // }
    // }

    private static int processInput(List<String> inputLines) {
        try {
            // 各行から数値を取得（7行分）
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
        } catch (Exception e) {
            logger.log(Level.SEVERE, "入力データの解析中にエラーが発生しました", e);
            System.err.println("エラーが発生しました: " + e.getMessage());
            return 0;
        }
    }
}