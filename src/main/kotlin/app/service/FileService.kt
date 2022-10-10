package app.service

import org.springframework.stereotype.Component
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@Component
class FileService {

    companion object {
        const val TXT = "TXT"
    }

    fun isFile(fileDirection: String) : Boolean {
        val filePath: Path = Paths.get(fileDirection)

        if (Files.exists(filePath)) {
            println("Найден файл: ${filePath.fileName}")
            return true
        } else {
            println("Файл не найден")
        }
        return false
    }

    fun isTxt(fileName: String) : Boolean {
        val filePath: Path = Paths.get(fileName)
        val file = File(filePath.toString())
        if (TXT.equals(file.extension, ignoreCase = true)) {
            println("Расширение файла: ${file.extension}")
            return true
        }
        return false
    }

    fun readTxtFile(fileName: String) =
        File(fileName).readText()

    fun writeTxtFile(fileDirection: String, text: String) =
        File(fileDirection, "TodayTaskListChange.txt").writeText(text)
}