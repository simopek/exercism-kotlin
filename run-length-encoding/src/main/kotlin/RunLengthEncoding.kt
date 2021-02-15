object RunLengthEncoding {

    fun encode(input: String): String {

        var output = StringBuilder()

        var charIdx = 0
        while (charIdx < input.length) {

            var currInput = input.slice(charIdx until input.length)
            // since we are slicing the original string, we get the first char at 0
            var currChar = currInput[0]
            // we get all the chars until we find a different one
            var currCharSubstring = currInput.takeWhile { c -> currChar == c }

            // in case we counted only 1 char, we skip the number
            if (currCharSubstring.length > 1) {
                output = output.append(currCharSubstring.length)
            }
            output = output.append(currChar)
            charIdx += currCharSubstring.length
        }

        return output.toString()
    }

    fun decode(input: String): String {

        var output = StringBuilder()

        var readingDigits = false
        var charIdx = 0
        while (charIdx < input.length) {

            var currInput = input.slice(charIdx until input.length)
            // we get all the chars until we find a different one
            var currCharSubstring = currInput.takeWhile { c -> !c.isDigit() }

            if (currCharSubstring.isNotBlank()) {
                output = output.append(currCharSubstring)
            }
            
            charIdx += currCharSubstring.length
            readingDigits = true
        }

        return output.toString()
    }
}
