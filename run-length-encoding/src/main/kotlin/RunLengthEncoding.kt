object RunLengthEncoding {

    /*

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

        // it tells if we are reading the number by which the following character has to be repeated
        var readingCharCounter = false
        var charCounterBldr = StringBuilder()

        input.forEach { currChar ->

           when  {
               currChar.isDigit() -> {

                   if (!readingCharCounter) {
                       charCounterBldr = StringBuilder()
                       readingCharCounter = true
                   }

                   charCounterBldr = charCounterBldr.append(currChar)
               }
               else -> {

                   output = if (readingCharCounter) {

                       readingCharCounter = false
                       output.append(currChar.toString().repeat(charCounterBldr.toString().toInt()))
                   } else {
                       output.append(currChar)
                   }
               }
           }
        }

        return output.toString()
    }

     */


    /*
    With (.) we get any character. With \\1+ we refer to the first match, that
    is any character, and we get the string that matches the repetition of the first match.

    it is the match result
    it.value is the matched string so we get the length and the first char
     */
    fun encode(input: String): String =
        input.replace(Regex("(.)\\1+")) {
            String.format("%d%s", it.value.length, it.value[0])
        }

    /*
    With (\\d+)(.) we get any number followed by a character.
    The matches are stored in the groups 1 and 2.
    The group 2 keeps the character that we repeat by n times,
    where n is group 1.
     */
    fun decode(input: String): String =
        input.replace(Regex("(\\d+)(.)")) {
            it.groupValues[2].repeat(it.groupValues[1].toInt())
        }

}
