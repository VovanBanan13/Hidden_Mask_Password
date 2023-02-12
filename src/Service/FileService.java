package Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileService {

    public boolean isFile(String entryStr) {
        Path filePath = Paths.get(entryStr);

        if (Files.exists(filePath)) {
            System.out.println("Найден файл: " + filePath.getFileName());
            return true;
        } else {
            System.out.println("Файл не найден");
        }
        return false;
    }

    public Boolean isTxt(String fileName) {
        int index = fileName.lastIndexOf(".");
        String fileExtension = fileName.substring(index+1);
        return "txt".equalsIgnoreCase(fileExtension);
    }

    public String readText(String fileName) throws IOException {
        return new File(Files.readString(Paths.get(fileName))).toString();
    }

    public void writeText(String fileName, String text) throws IOException {
        new File(String.valueOf(Files.writeString(Path.of(fileName), text)));
    }

    public String replaceNewFileName(String fileName)  {
        int index = fileName.lastIndexOf(".");
        String fileDirection = fileName.substring(0, index);
        String fileExtension = fileName.substring(index+1);
        return fileDirection + "_mask." + fileExtension;
    }
}
