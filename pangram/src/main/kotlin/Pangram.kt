object Pangram {

    /*
    fun isPangram(input: String): Boolean {

        // we create a map that says for each ASCII character if we found a match
        var foundChars = (97..122).map { it.toChar() }.associateBy({ it }, { false }).toMutableMap()

        input.forEach { foundChars[it.toLowerCase()] = true }

        // in case the maps contains a "false" value, that means at least one character
        // was not found
        return !foundChars.containsValue(value = false)
    }

     */

    fun isPangram(input: String): Boolean {

        return ((97..122).map { it.toChar() }.toSet() - input.toLowerCase().toSet()).isEmpty()
    }
}
