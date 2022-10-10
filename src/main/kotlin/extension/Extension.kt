package extension

fun String.contains(set: Set<String>, ignoreCase: Boolean = false): Boolean {
    val list = this.replace(Regex("[,.!?;:]"),"").split(" ")
    if (list.size > 1) {
        return list.contains(set, ignoreCase)
    } else {
        for (one in set) {
            if (this.contains(one, ignoreCase = ignoreCase)) {
                return true
            }
        }
        return false
    }
}

fun List<String>.contains(set: Set<String>, ignoreCase: Boolean = false): Boolean {
    for (one in this) {
        if (one.contains(set, ignoreCase = ignoreCase)) {
            return true
        }
    }
    return false
}
