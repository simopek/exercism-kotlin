import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.time.temporal.Temporal
import java.time.temporal.TemporalUnit

class Gigasecond(private val instant: Temporal) {


    val date: LocalDateTime = when (instant) {
        is LocalDate -> instant.atStartOfDay().plus(1000000000, ChronoUnit.SECONDS)
        else -> LocalDateTime.from(instant.plus(1000000000, ChronoUnit.SECONDS))
    }
}
