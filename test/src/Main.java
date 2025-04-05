import java.util.*;
import java.util.logging.Logger;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    // public static void main(String[] args) {
    // List<String> inputLines = new ArrayList<>();

    // // 標準入力からすべての行を読み取る
    // try (Scanner scanner = new Scanner(System.in)) { // 標準入力を読み取る
    // while (scanner.hasNextLine()) {
    // inputLines.add(scanner.nextLine());
    // }
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
            try (DirectoryStream<Path> txtFiles = Files.newDirectoryStream(directoryPath,
                    "*.txt")) {
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
        int n = 1;
        float answer = n;
        System.out.println(answer);

        return 1;
    }
}