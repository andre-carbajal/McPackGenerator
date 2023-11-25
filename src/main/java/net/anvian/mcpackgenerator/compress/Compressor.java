package net.anvian.mcpackgenerator.compress;

import net.anvian.mcpackgenerator.util.AlertService;
import net.anvian.mcpackgenerator.util.FolderLocation;
import net.anvian.mcpackgenerator.util.FoldersToIgnore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compressor implements ICompress{

    @Override
    public void compress(String zipFileName) {
        Path folderLocation = FolderLocation.getPath();
        try (
                ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName))
        ){
            walkAndZipFiles(folderLocation, zos);
            AlertService.alertConfirmation("The file has been successfully generated in the folder:\n " + folderLocation.toFile().getParentFile());
        } catch (IOException e) {
            AlertService.alertError("Failed to compress files: " + e.getMessage());
        }
    }

    private void walkAndZipFiles(Path folderLocation, ZipOutputStream zos) throws IOException{
        Files.walkFileTree(folderLocation, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs){
                for (FoldersToIgnore folder : FoldersToIgnore.values()) {
                    if (dir.getFileName().toString().equals(folder.getFolderName())) {
                        return FileVisitResult.SKIP_SUBTREE;
                    }
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {

                if (attributes.isSymbolicLink()) {
                    return FileVisitResult.CONTINUE;
                }

                try (FileInputStream fis = new FileInputStream(file.toFile())) {

                    Path targetFile = folderLocation.relativize(file);
                    ZipEntry zipEntry = new ZipEntry(targetFile.toString());
                    zos.putNextEntry(zipEntry);

                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }

                    zos.closeEntry();

                    System.out.println("Zip file: " + file);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.err.printf("Unable to zip : %s%n%s%n", file, exc);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
