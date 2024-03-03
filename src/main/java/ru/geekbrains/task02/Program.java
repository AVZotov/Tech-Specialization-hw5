package ru.geekbrains.task02;

import java.io.File;

public class Program {
    public static void main(String[] args) {
        tree(new File("."));
    }

    public static void tree(File folder) {
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        printDirectory(folder, indent, sb);
        System.out.println(sb);
    }

    private static void printDirectory(File sourceFile, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent)).append("└─").append(sourceFile.getName()).append("/").append("\n");
        File[] files = sourceFile.listFiles();

        if (files == null){
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                printDirectory(file, indent + 1, sb);
            } else {
                printFile(file, indent + 1, sb);
            }
        }
    }

    private static void printFile(File file, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent)).append("▪ ").append(file.getName()).append("\n");
    }

    private static String getIndentString(int indent) {
        return "|  ".repeat(Math.max(0, indent));
    }
}

