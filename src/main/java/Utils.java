import java.io.IOException;

/**
 * Created by thomas on 23/11/14.
 */
public class Utils {
    public static void keepThreadAlive() throws IOException {
        System.in.read();
    }
}
