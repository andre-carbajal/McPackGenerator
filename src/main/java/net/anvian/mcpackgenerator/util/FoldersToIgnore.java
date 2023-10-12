package net.anvian.mcpackgenerator.util;

public enum FoldersToIgnore {
    GIT(".git"),
    GITIGNORE(".gitignore");

    private final String folderName;

    FoldersToIgnore(String folderName) {
        this.folderName = folderName;
    }

    public String getFolderName() {
        return folderName;
    }
}
