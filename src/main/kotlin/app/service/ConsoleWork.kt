package app.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ConsoleWork : CommandLineRunner {

    @Autowired
    private val fileService: FileService? = null

    override fun run(vararg args: String?) {
        println("\n\t Начало работы приложения ")

        while (true) {
            println("Чтобы распарсить файл, введите его путь")
            println("Чтобы выйти из приложения, введите 'exit'")

            print("Ввод: ")
            val entryStr = readLine()

            if (entryStr.equals("exit", ignoreCase = true)){
                println("\n\t Конец работы приложения ")
                break
            }

            if (entryStr != null && fileService?.isFile(entryStr) == true) {
                println("OK")
            } else println("OK, but not File")
        }
    }


}