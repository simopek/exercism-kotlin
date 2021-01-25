val intermediateTranscoding = mapOf(
    'a' to 1,
    'A' to 2,
    't' to 3,
    'T' to 4,
    'c' to 5,
    'C' to 6,
    'g' to 7,
    'G' to 8
)

val finalTranscoding = mapOf(
    1 to 'u',
    2 to 'U',
    3 to 'a',
    4 to 'A',
    5 to 'g',
    6 to 'G',
    7 to 'c',
    8 to 'C'
)

/*
fun transcribeToRna(dna: String): String = dna
    .replace('a', 'u')
    .replace('A', 'U')
    .replace('t', 'a')
    .replace('T', 'A')
    .replace('c', 'x')
    .replace('C', 'X')
    .replace('g', 'c')
    .replace('G', 'C')
    .replace('x', 'g')
    .replace('X', 'G')
*/

fun transcribeToRna(dna: String): String {

    return dna.map { intermediateTranscoding[it] }.map { finalTranscoding[it] }
        .fold("") { acc, nextChar -> "$acc$nextChar" }
}
