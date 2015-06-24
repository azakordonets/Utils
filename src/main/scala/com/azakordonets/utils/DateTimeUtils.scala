package com.azakordonets.utils


import com.azakordonets.entities.{DatesRange, RelativeDate}
import com.azakordonets.enums.Day
import org.joda.time.{DateTime, DateTimeZone, LocalDate}

object DateTimeUtils {
  def apply(): DateTimeUtils = {
    new DateTimeUtils
  }
}

class DateTimeUtils {

  def datesRange: DatesRange = new DatesRange

  def relativeDate: RelativeDate = new RelativeDate

  def relativeDate(initialDate: DateTime): RelativeDate = new RelativeDate(initialDate)

  def relativeDate(timeZone: DateTimeZone): RelativeDate = new RelativeDate(timeZone)

  def getNext(dayOfTheWeek: Day) = {
    getNext(dayOfTheWeek, startingPoint = LocalDate.now())
  }

  def getNext(dayOfTheWeek: Day, startingPoint: LocalDate): LocalDate = {
    val expectedDay: LocalDate = startingPoint.dayOfWeek().setCopy(dayOfTheWeek.getDayOfWeek)
    if (startingPoint.getDayOfWeek == dayOfTheWeek.getDayOfWeek) {
      return startingPoint.plusWeeks(1)
    }
    if (expectedDay.isBefore(startingPoint)) {
      startingPoint.plusWeeks(1).dayOfWeek().setCopy(dayOfTheWeek.getDayOfWeek)
    } else {
      startingPoint.dayOfWeek().setCopy(dayOfTheWeek.getDayOfWeek)
    }
  }

}
