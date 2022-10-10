package app.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ConsoleWork : CommandLineRunner {

    @Autowired
    private val fileService: FileService? = null
    private val replaceService: ReplaceService = ReplaceService()

    override fun run(vararg args: String?) {
        println("\n\t Начало работы приложения ")

        while (true) {
            println("\nЧтобы прочитать файл, введите его путь")
            println("Чтобы выйти из приложения, введите 'exit'")

            print("Ввод: ")
            val entryStr = readLine()

            if (entryStr.equals("exit", ignoreCase = true)){
                println("\n\t Конец работы приложения ")
                break
            }

            if (entryStr != null && fileService?.isFile(entryStr) == true) {
                if (fileService.isTxt(entryStr)) {
                    println("Найден файл с расширением TXT")
                    val text = fileService.readTxtFile(entryStr)
                    if (!replaceService.isContainsPassword(text)) {
                        println("В файле не содержатся пароли")
                    } else {
                        val textPassword = replaceService.replacePassword(text)
                        fileService.writeTxtFile(fileService.replaceNewFileName(entryStr), textPassword)
                        println("\nНовый файл со скрытым паролем создан")
                        println("Путь сохранения: ${fileService.replaceNewFileName(entryStr)}")
                    }
                } else println("Файл не TXT, повторите попытку")
            } else println("Файл не найден")
        }
    }
}