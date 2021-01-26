import kotlin.math.sqrt

object Darts {

    private const val OUTER_CIRCLE_RADIUS = 10
    private const val MIDDLE_CIRCLE_RADIUS = 5
    private const val INNER_CIRCLE_RADIUS = 1

    fun score(x: Number, y: Number): Int {

        val radius = computeRadius(x.toDouble(), y.toDouble())

        return when {
            radius <= INNER_CIRCLE_RADIUS -> 10
            radius <= MIDDLE_CIRCLE_RADIUS -> 5
            radius <= OUTER_CIRCLE_RADIUS -> 1
            else -> 0
        }
    }

    private fun computeRadius(x: Double, y: Double): Double = sqrt(x * x + y * y)
}
