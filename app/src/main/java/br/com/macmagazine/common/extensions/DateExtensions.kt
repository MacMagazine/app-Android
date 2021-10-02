package br.com.macmagazine.common.extensions

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun LocalDate.toFormattedDate(): String =
    this.format(DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM", Locale("pt", "BR")))

fun LocalDate.isToday(): Boolean = LocalDate.now().compareTo(this) == 0

fun LocalDate.isTomorrow(): Boolean = LocalDate.now().plusDays(1).compareTo(this) == 0

fun LocalDate.isYesterday(): Boolean = LocalDate.now().minusDays(1).compareTo(this) == 0