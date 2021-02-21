class Matrix(private val matrixAsString: String) {

    private val matrixRows: Map<Int, List<Int>>

    init {

        val matrixLines = matrixAsString.lines()

        var rowIdx = 0
        matrixRows = matrixLines.associateBy({rowIdx++},
            { it -> it.replace("\\s+".toRegex(), " ")
                .split(" ").map { it2 -> it2.trim() }.filter { it3 -> it3.isNotBlank() }
                .map { it4 -> it4.toInt() }})
    }

    fun column(colNr: Int): List<Int> {
        return matrixRows.values.map { row -> row[colNr - 1] }
    }

    fun row(rowNr: Int): List<Int> {
        return matrixRows[rowNr - 1]!!
    }
}
