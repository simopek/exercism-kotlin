class CustomSet(private vararg val _elements: Int) {

    private val elements: MutableList<Int> = _elements.distinct().toMutableList()

    fun isEmpty(): Boolean  = elements.isEmpty()

    fun isSubset(other: CustomSet): Boolean {
        return elements.none { !other.contains(it) }
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return elements.none { other.contains(it) }
    }

    fun contains(other: Int): Boolean = elements.contains(other)

    fun intersection(other: CustomSet): CustomSet {
      val newElements = elements.filter { it -> other.contains(it) }
      return CustomSet(*newElements.toIntArray())
    }

    fun add(other: Int) {

        if (contains(other)) {
            return
        }
        elements.add(other)
    }

    override fun equals(other: Any?): Boolean {

        if (other == null) {
            return false
        }

        return when (other) {
            is CustomSet -> isSubset(other) && other.elements.size == elements.size
            else -> false
        }

    }

    operator fun plus(other: CustomSet): CustomSet {

        val newElements = other.elements.filter { !contains(it) }.toMutableList()
        newElements.addAll(elements)

        return CustomSet(*newElements.toIntArray())
    }

    operator fun minus(other: CustomSet): CustomSet {

        val newElements = mutableListOf<Int>()
        newElements.addAll(elements)
        newElements.removeIf { other.contains(it) }

        return CustomSet(*newElements.toIntArray())
    }
}
