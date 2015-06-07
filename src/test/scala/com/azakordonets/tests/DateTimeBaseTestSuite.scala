package com.azakordonets.tests

import com.azakordonets.enums.DateRangeType
import com.typesafe.scalalogging.slf4j.LazyLogging
import org.joda.time.DateTime
import org.scalatest.testng.TestNGSuite
import com.azakordonets.enums.DateRangeType._

class DateTimeBaseTestSuite extends TestNGSuite with LazyLogging {

  protected def assertDates(expectedDate: DateTime, actualDate: DateTime) = {
    assertResult(expectedDate.getYear)(actualDate.getYear)
    assertResult(expectedDate.getMonthOfYear)(actualDate.getMonthOfYear)
    assertResult(expectedDate.getDayOfMonth)(actualDate.getDayOfMonth)
    assertResult(expectedDate.getHourOfDay)(actualDate.getHourOfDay)
    assertResult(expectedDate.getMinuteOfHour)(actualDate.getMinuteOfHour)
  }

  protected def assertDates(expectedDate: DateTime, actualDate: DateTime, except: DateRangeType) = {
    if (!except.equals(YEARS))assertResult(expectedDate.getYear)(actualDate.getYear)
    if (!except.equals(MONTHS)) assertResult(expectedDate.getMonthOfYear)(actualDate.getMonthOfYear)
    if (!except.equals(DAYS))assertResult(expectedDate.getDayOfMonth)(actualDate.getDayOfMonth)
    if (!except.equals(HOURS))assertResult(expectedDate.getHourOfDay)(actualDate.getHourOfDay)
    if (!except.equals(MINUTES))assertResult(expectedDate.getMinuteOfHour)(actualDate.getMinuteOfHour)
  }

}
