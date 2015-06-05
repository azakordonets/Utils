package com.azakordonets.utils

import com.azakordonets.entities.{DatesRange, RelativeDate}
import org.joda.time.DateTime
import org.joda.time.DateTimeZone

class DateTimeUtils {

  def datesRange: DatesRange = new DatesRange

  def relativeDate: RelativeDate = new RelativeDate

  def relativeDate(initialDate: DateTime): RelativeDate = new RelativeDate(initialDate)

  def relativeDate(timeZone: DateTimeZone): RelativeDate = new RelativeDate(timeZone)

}
