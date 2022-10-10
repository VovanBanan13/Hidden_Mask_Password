package app.service

import app.extension.contains
import app.set.loginSet
import app.set.passwordSet
import org.springframework.stereotype.Component

@Component
class ReplaceService {

    fun isContainsPassword(text: String) : Boolean =
        (text.contains(passwordSet, ignoreCase = true))

    fun replacePassword(text: String) : String {
        return if (text.contains(passwordSet, ignoreCase = true)) {
            var result = text
            val textList = text
                .replace("\n", " ")
                .replace(Regex("[,.!?;:\\t]"), "")
                .split(" ")
            for (i in textList.indices) {
                if (textList[i].contains(passwordSet, ignoreCase = true)) {
                    result = result.replace(
                        textList[i + 1],
                        "*".repeat((textList[i + 1]).length)
                    )
                }
            }
            result
        } else text
    }

    fun replaceLogin(text: String) : String {
        return if (text.contains(loginSet, ignoreCase = true)) {
            var result = text
            val textList = text
                .replace("\n", " ")
                .replace(Regex("[,.!?;:\\t]"), "")
                .split(" ")
            for (i in textList.indices) {
                if (textList[i].contains(loginSet, ignoreCase = true)) {
                    result = result.replace(
                        textList[i + 1],
                        "%".repeat((textList[i + 1]).length)
                    )
                }
            }
            result
        } else text
    }
}