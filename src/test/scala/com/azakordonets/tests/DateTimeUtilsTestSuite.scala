package com.azakordonets.tests

import com.azakordonets.enums.Day
import com.azakordonets.utils.FUtils
import org.joda.time.{Days, LocalDate}
import org.testng.annotations.{DataProvider, Test}

class DateTimeUtilsTestSuite extends DateTimeBaseTestSuite {

  @DataProvider(name = "nextDayDP")
  def nextDayDP() = {
    Array(Array(Day.MONDAY),
      Array(Day.TUESDAY),
      Array(Day.WEDNESDAY),
      Array(Day.THURSDAY),
      Array(Day.FRIDAY),
      Array(Day.SATURDAY),
      Array(Day.SUNDAY)
    )
  }

  @Test(dataProvider = "nextDayDP")
  def testNextDay(nextDay: Day) = {
    val nextDate: LocalDate = FUtils.dateTime().getNext(nextDay)
    val currentDate: LocalDate = LocalDate.now()
    assertResult(nextDay.getDayOfWeek)(nextDate.getDayOfWeek)
    assert(Days.daysBetween(nextDate, currentDate).getDays <= 7)
  }

  @DataProvider(name = "nextDayWithCustomDateDP")
  def nextDayWithCustomDateDP() = {
    Array(Array(Day.MONDAY, LocalDate.parse("2015-06-29")),
      Array(Day.TUESDAY, LocalDate.parse("2015-06-23")),
      Array(Day.WEDNESDAY, LocalDate.parse("2015-06-24")),
      Array(Day.THURSDAY, LocalDate.parse("2015-06-25")),
      Array(Day.FRIDAY, LocalDate.parse("2015-06-26")),
      Array(Day.SATURDAY, LocalDate.parse("2015-06-27")),
      Array(Day.SUNDAY, LocalDate.parse("2015-06-28"))
    )
  }

  @Test(dataProvider = "nextDayWithCustomDateDP")
  def testNextDayWithCustomDate(nextDay: Day, expectedDate: LocalDate) = {
    val startPoint = LocalDate.parse("2015-06-22")
    val nextDate: LocalDate = FUtils.dateTime().getNext(nextDay, startPoint)
    assertResult(expectedDate)(nextDate)
  }

}
