import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.time.temporal.Temporal
import java.time.temporal.TemporalUnit

class Gigasecond(private val instant: LocalDateTime) {

    constructor(_date: LocalDate): this(_date.atStartOfDay())

    val date: LocalDateTime = instant.plusSeconds(1000000000)
}
