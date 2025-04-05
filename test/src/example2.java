
// example2.java
import java.util.logging.Level;
import java.util.logging.Logger;

public class example2 {
    private static final Logger logger = Logger.getLogger(example2.class.getName());

    public static void main(String[] args) {
        // example3 クラスのインスタンスを作成
        example3 obj = new example3("ManagedObject", 100);

        // メソッド呼び出し
        obj.displayInfo();

        // セッターで値を変更
        obj.setName("UpdatedName");
        obj.setValue(200);

        // 変更後の情報を表示
        logger.log(Level.INFO, "Updated Values - Name: {0}, Value: {1}",
                new Object[] { obj.getName(), obj.getValue() });
    }
}