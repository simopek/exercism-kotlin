object ResistorColorDuo {

    private val colorValues = listOf(
        Color.BLACK, Color.BROWN, Color.RED,
        Color.ORANGE, Color.YELLOW, Color.GREEN,
        Color.BLUE, Color.VIOLET, Color.GREY, Color.WHITE
    )

    fun value(vararg colors: Color): Int {
        return colors.slice(0..1).map { color -> colorValues.indexOf(color) }
            .fold(0) { acc, nextColorValue -> acc * 10 + nextColorValue }
    }
}
