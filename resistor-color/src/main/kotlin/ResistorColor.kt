object ResistorColor {

    private val colors = listOf("black", "brown", "red", "orange",
        "yellow", "green", "blue", "violet", "grey", "white")

    fun colorCode(input: String): Int {
        return colors.indexOf(input.toLowerCase())
    }

    fun colors(): List<String> {
       return colors
    }

}
