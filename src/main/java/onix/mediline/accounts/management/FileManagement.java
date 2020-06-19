package onix.mediline.accounts.management;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManagement {

    public static String APPLICATION_FOLDER = ".mediline-test";

    private static final String USER_FOLDER = System.getProperty("user.home");
    private static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    public static Path getApplicationHomePath() {
        return Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    }
    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }

    public static void initApplicationHomeDirIfNeeded() {
        if (!Files.exists(getApplicationHomePath()))
            getApplicationHomePath().toFile().mkdirs();
    }

}
