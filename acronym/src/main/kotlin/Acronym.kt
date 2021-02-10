object Acronym {
    fun generate(phrase: String): String {

        val words = phrase
            .replace("-", " ")
            .replace("_", " ")
            .split(" ")

        return words.map { it.trim() }.filter { it.isNotBlank() }
            .map { s -> s[0] }.fold("") { acc: String, c: Char -> acc + c.toUpperCase() }
    }
}
