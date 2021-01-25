data class Year(val value: Int) {

    val isLeap = computeLeapness()

    private fun computeLeapness(): Boolean {

        return if (value % 4 == 0) {

            if (value % 100 == 0) {

                value % 400 == 0
            } else {
                true
            }
        } else {
            false
        }


    }
}
