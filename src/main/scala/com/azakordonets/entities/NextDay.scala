package com.azakordonets.entities
import com.azakordonets.enums.{DateFormat, Day}
import org.joda.time.LocalDate

object NextDay {

  def apply(dayOfWeek: Day): NextDay = new NextDay(dayOfWeek, LocalDate.now)

  def apply(dayOfWeek: Day, startPoint: LocalDate): NextDay = new NextDay(dayOfWeek, startPoint)
}

class NextDay(dayOfWeek: Day, startPoint: LocalDate) {

  private def getNext(dayOfTheWeek: Day, startingPoint: LocalDate): LocalDate = {
    val expectedDay: LocalDate = startingPoint.dayOfWeek().setCopy(dayOfTheWeek.getIndex)
    if (startingPoint.getDayOfWeek == dayOfTheWeek.getIndex) {
      startingPoint.plusWeeks(1)
    } else if (expectedDay.isBefore(startingPoint)) {
      startingPoint.plusWeeks(1).dayOfWeek().setCopy(dayOfTheWeek.getIndex)
    } else {
      startingPoint.dayOfWeek().setCopy(dayOfTheWeek.getIndex)
    }
  }

  def asDate: LocalDate = getNext(dayOfWeek, startPoint)

  def asString: String = asString(DateFormat.dd_MM_yyyy)

  def asString(format: DateFormat): String = getNext(dayOfWeek, startPoint).toString(format.getFormat)

}
