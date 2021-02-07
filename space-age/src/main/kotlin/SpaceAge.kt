import kotlin.math.roundToLong

class SpaceAge(private val ageInSeconds: Long) {

    companion object {
        private const val EARTH_YEAR = 31557600.0
        private const val MERCURY_YEAR = 0.2408467 * EARTH_YEAR
        private const val VENUS_YEAR = 0.61519726 * EARTH_YEAR
        private const val MARS_YEAR = 1.8808158 * EARTH_YEAR
        private const val JUPITER_YEAR = 11.862615 * EARTH_YEAR
        private const val SATURN_YEAR = 29.447498 * EARTH_YEAR
        private const val URANUS_YEAR = 84.016846 * EARTH_YEAR
        private const val NEPTUNE_YEAR = 164.79132 * EARTH_YEAR
    }

    fun onEarth(): Double = roundConvertedAge(ageInSeconds / EARTH_YEAR)
    fun onMercury(): Double = roundConvertedAge(ageInSeconds / MERCURY_YEAR)
    fun onVenus(): Double = roundConvertedAge(ageInSeconds / VENUS_YEAR)
    fun onMars(): Double = roundConvertedAge(ageInSeconds / MARS_YEAR)
    fun onJupiter(): Double = roundConvertedAge(ageInSeconds / JUPITER_YEAR)
    fun onSaturn(): Double = roundConvertedAge(ageInSeconds / SATURN_YEAR)
    fun onUranus(): Double = roundConvertedAge(ageInSeconds / URANUS_YEAR)
    fun onNeptune(): Double = roundConvertedAge(ageInSeconds / NEPTUNE_YEAR)

    private fun roundConvertedAge(n: Double) : Double {
        return ((n * 100).roundToLong() / 100.0)
    }
}
