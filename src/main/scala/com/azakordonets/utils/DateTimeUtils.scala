package com.azakordonets.utils


import com.azakordonets.entities.{DatesRange, NextDay, RelativeDate}
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

  def getNext(dayOfWeek: Day): NextDay = NextDay(dayOfWeek)

  def getNext(dayOfWeek: Day, startPoint: LocalDate): NextDay = NextDay(dayOfWeek, startPoint)




}
