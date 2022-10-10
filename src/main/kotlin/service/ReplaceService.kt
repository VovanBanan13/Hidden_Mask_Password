package service

import extension.contains
import set.loginSet
import set.passwordSet

class ReplaceService {

    fun replacePassword(text: String) : String {
        return if (text.contains(passwordSet, ignoreCase = true)) {
            var result = text
            val textList = text.replace(Regex("[,.!?;:]"), "").split(" ")
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
            val textList = text.replace(Regex("[,.!?;:]"), "").split(" ")
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