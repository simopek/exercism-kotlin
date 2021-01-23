import java.text.DecimalFormat
import kotlin.math.floor

object ResistorColorTrio {

    private val unitList =
        listOf(Unit.OHMS, Unit.KILOOHMS, Unit.MEGAOHMS, Unit.GIGAOHMS, Unit.TERAOHMS, Unit.PETAOHMS, Unit.EXAOHMS)

    fun text(vararg input: Color): String {

        // we compute the base number from the first 2 bands
        var base: Double = input.take(2).map { it.ordinal }.fold(0) { acc, nextColorValue -> acc * 10 + nextColorValue }.toDouble()
        val baseGte10 = base >= 10
        // we get the 3rd band telling us the exponent
        val zerosBand = input[2]

        var zerosToBeAdded = zerosBand.ordinal

        var unit = Unit.OHMS

        // if we "miss" only one digit so that we can use the "next" unit and the base is >= 10
        // we use the next unit and we divide the base by 10
        if(zerosToBeAdded % 3 == 2 && baseGte10) {
            unit = unitList[floor((zerosBand.ordinal.toDouble() + 1) / 3).toInt()]
            base /= 10
            zerosToBeAdded = 0
        } else {
            unit = unitList[floor(zerosBand.ordinal.toDouble() / 3).toInt()]
        }

        var zeros = (zerosToBeAdded % 3).downTo(1).fold("") { acc, _ -> "${acc}0" }

        // we format the base in case we don't have decimal points
        return "${DecimalFormat("0.#").format(base)}$zeros ${unit.name.toLowerCase()}"
    }
}
