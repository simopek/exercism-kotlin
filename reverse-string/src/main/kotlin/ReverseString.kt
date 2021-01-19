fun reverse(input: String): String {

    var revertedInput = ""
    for (i in (input.length - 1) downTo 0 ) {
        revertedInput += input[i]
    }

    return revertedInput
 }
