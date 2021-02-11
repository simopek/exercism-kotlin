object ScrabbleScore {

    fun scoreLetter(c: Char): Int = Letters.getScore(c)

    fun scoreWord(word: String): Int = word.map { scoreLetter(it) }.sum()
}
