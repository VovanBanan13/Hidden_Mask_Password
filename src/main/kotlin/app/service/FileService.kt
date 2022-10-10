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
        return Files.exists(filePath)
    }

    fun isTxt(fileName: String) : Boolean {
        val filePath: Path = Paths.get(fileName)
        val file = File(filePath.toString())
        return (TXT.equals(file.extension, ignoreCase = true))
    }

    fun readTxtFile(fileName: String) =
        File(fileName).readText()

    fun writeTxtFile(fileDirection: String, text: String) =
        File(fileDirection).writeText(text)

    fun replaceNewFileName(fileName: String) : String {
        val fileDirection = fileName.substringBeforeLast(".")
        val fileExtension = fileName.substringAfterLast(".")
        return fileDirection + "_mask." + fileExtension
    }
}