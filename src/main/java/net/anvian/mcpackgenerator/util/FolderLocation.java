package net.anvian.mcpackgenerator.util;

import java.nio.file.Path;

public class FolderLocation {

    private static Path path;

    public static Path getPath() {
        return path;
    }

    public static void setPath(Path path) {
        FolderLocation.path = path;
    }

}
