object Transpose {

    fun transpose(input: List<String>): List<String> {

        val maxPadding = input.size
        val maxLength = input.map { it.length }.max() ?: return emptyList()

        val output = mutableListOf<String>()
        (0 until maxLength).forEach { ith ->

            val newString =
                input.filter { str -> ith <= str.length - 1 }.map { str -> str[ith] }.joinToString(separator = "")
            output.add(newString.padStart(maxPadding,' '))
        }

        return output
    }
}
