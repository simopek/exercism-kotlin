class Scale(private val tonic: String) {

    private val notesWithSharps = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
    private val notesWithFlats = listOf("C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B")
    private val normalizedTonic =
        if (tonic.length > 1) tonic[0].toString().toUpperCase() + tonic[1].toString().toLowerCase()  else tonic.toUpperCase()

    /**
     * Searches the tonic among the "notes with sharps" or
     * among the "notes with flats".
     *
     * @return a pair with the index of the tonic inside the list of notes.
     * If the tonic is not found a negative index is returned along with an empty list.
     */
    private fun findTonic(): Pair<Int, List<String>> {

        var notes: List<String>

        var tonicIdx = notesWithSharps.indexOfFirst { normalizedTonic == it }
        notes = notesWithSharps

        if (tonicIdx < 0) {
            tonicIdx = notesWithFlats.indexOfFirst { normalizedTonic == it }
            notes = notesWithFlats
            if (tonicIdx < 0) {
                return Pair(tonicIdx, emptyList())
            }
        }
        return Pair(tonicIdx, notes)
    }

    fun chromatic(): List<String> {

        var (tonicIdx, notes) = findTonic()

        if (tonicIdx < 0) {
            return notes
        }

        return notes.subList(tonicIdx, notes.size) + notes.subList(0, tonicIdx)
    }

    fun interval(intervals: String): List<String> {

        var (tonicIdx, notes) = findTonic()

        if (tonicIdx < 0) {
            return notes
        }

        var i = tonicIdx
        // we initialize the list with the tonic
        var scaleNotes = mutableListOf<String>(notes[i])

        intervals.forEach { interval ->

            i += when (interval) {
                'M' -> 2
                'm' -> 1
                'A' -> 3
                else -> throw IllegalArgumentException("invalid interval")
            }
            i %= notes.size

            scaleNotes.add(notes[i])
        }

        // we remove the last note since it's the octave
        return scaleNotes.subList(0, scaleNotes.size - 1)
    }

}
