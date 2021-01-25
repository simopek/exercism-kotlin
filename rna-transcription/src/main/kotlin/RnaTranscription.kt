val transcoding = mapOf(
    'a' to 'u',
    'A' to 'U',
    't' to 'a',
    'T' to 'A',
    'c' to 'g',
    'C' to 'G',
    'g' to 'c',
    'G' to 'C'
)

fun transcribeToRna(dna: String): String {

    return dna.map { transcoding[it] }.joinToString("")
}
