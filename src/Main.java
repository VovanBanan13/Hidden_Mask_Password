import Service.FileService;
import Service.ReplaceService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Начало работы приложения");

        Scanner console = new Scanner(System.in);
        FileService fileService = new FileService();
        ReplaceService replaceService = new ReplaceService();

        while (true) {
            System.out.println("\n Чтобы прочитать файл, введи его путь");
            System.out.println("Чтобы выйти из приложения, введи 'exit'");

            System.out.print("Ввод: ");
            String entryStr = console.nextLine();

            if (entryStr.equalsIgnoreCase("exit")) {
                System.out.println("Завершение работы приложения");
                break;
            }

            if (fileService.isFile(entryStr)) {
                if (fileService.isTxt(entryStr)) {
                    String text = fileService.readText(entryStr);
                    if (replaceService.isContainsPassword(text)) {
                        String textPassword = replaceService.replacePassword(text);
                        fileService.writeText(fileService.replaceNewFileName(entryStr), textPassword);
                        System.out.println("Новый файл: " + fileService.replaceNewFileName(entryStr));
                    } else {
                        System.out.println("В тексте нет паролей");
                    }
                } else {
                    System.out.println("Файл не в формате txt");
                }
            } else {
                System.out.println("Файл не найден");
            }
        }
    }
}