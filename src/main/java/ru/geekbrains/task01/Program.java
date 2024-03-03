package ru.geekbrains.task01;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        copy(new File("."), new File("BackUp"));
    }

    public static void copy(File sourcePath, File destinationPath) throws IOException {
        if (sourcePath.isDirectory()){
            copyDirectory(sourcePath, destinationPath);
        }else {
            copyFile(sourcePath, destinationPath);
        }
    }

    private static void copyDirectory(File sourcePath, File destinationPath) throws IOException {
        if (!destinationPath.exists()){
            destinationPath.mkdir();
        }

        String[] fileNames = sourcePath.list();
        if (fileNames == null) { return; }

        for (String fileName : fileNames){
            if (fileName.equals(destinationPath.getName())){
                continue;
            }
            File srcFile = new File(sourcePath, fileName);
            File destFile = new File(destinationPath, fileName);
            copy(srcFile, destFile);
        }
    }

    private static void copyFile(File sourcePath, File destinationPath) throws IOException{
        try (InputStream in = new FileInputStream(sourcePath); OutputStream out = new FileOutputStream(destinationPath)){
            byte[] bytes = new byte[1024];
            int length;
            while ((length = in.read(bytes)) > 0) {
                out.write(bytes, 0, length);
            }
        }
    }
}
