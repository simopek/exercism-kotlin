class Scale(private val _tonic: String) {

    private val notesWithSharps = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
    private val notesWithFlats = listOf("C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B")
    private val tonic = _tonic.toUpperCase()

    fun chromatic(): List<String> {

        var notes : List<String>?

        var tonicIdx = notesWithSharps.indexOfFirst { tonic == it  }
        notes = notesWithSharps

        if (tonicIdx < 0) {
            tonicIdx = notesWithFlats.indexOfFirst { tonic == it  }
            notes = notesWithFlats
            if (tonicIdx < 0) {
                return emptyList()
            }
        }

        return notes.subList(tonicIdx, notes.size) + notes.subList(0, tonicIdx)

    }

    fun interval(intervals: String): List<String> {

        var notes : List<String>?

        var tonicIdx = notesWithSharps.indexOfFirst { tonic == it  }
        notes = notesWithSharps

        if (tonicIdx < 0) {
            tonicIdx = notesWithFlats.indexOfFirst { tonic == it  }
            notes = notesWithFlats
            if (tonicIdx < 0) {
                return emptyList()
            }
        }

        var i = tonicIdx
        var scaleNotes = mutableListOf<String>(notes[i])

        intervals.forEach { interval ->

            when (interval) {
                'M' -> {

                    i += 2
                    if (i >= notes.size) {
                        i %= notes.size
                    }

                    scaleNotes.add(notes[i])
                }
                'm' -> {

                    i++
                    if (i >= notes.size) {
                        i %= notes.size
                    }
                    scaleNotes.add(notes[i])
                }
                else -> throw IllegalArgumentException("invalid interval")
            }
        }

        return scaleNotes.subList(0, scaleNotes.size - 1)
    }

}
