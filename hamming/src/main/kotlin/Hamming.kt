object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {

        require(leftStrand.length == rightStrand.length) {
            "left and right strands must be of equal length"
        }

        return leftStrand.foldIndexed(0, {idx, acc, ch ->
            when (rightStrand[idx]) {
                ch -> acc
                else -> acc + 1
            }
        })
    }
}
