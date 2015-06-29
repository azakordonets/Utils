package com.azakordonets.tests

import com.azakordonets.enums.{DateFormat, Day}
import com.azakordonets.utils.GetUtil._
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
    val nextDate: LocalDate = DateTime.getNext(nextDay).asDate
    val currentDate: LocalDate = LocalDate.now()
    assertResult(nextDay.getIndex)(nextDate.getDayOfWeek)
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
    val nextDate: LocalDate = DateTime.getNext(nextDay, startPoint).asDate
    assertResult(expectedDate)(nextDate)
  }

  @Test
  def testNextDayAsDefaultString() = {
    val startPoint = LocalDate.parse("2015-06-22")
    val nextDate: String = DateTime.getNext(Day.MONDAY, startPoint).asString
    assertResult(LocalDate.parse("2015-06-29").toString("dd-MM-yyyy"))(nextDate)
  }

  @Test
  def testNextDayAsCustomString() = {
    val startPoint = LocalDate.parse("2015-06-22")
    val nextDate: String = DateTime.getNext(Day.MONDAY, startPoint).asString(DateFormat.dd_MM_yy)
    assertResult(LocalDate.parse("2015-06-29").toString("dd-MM-yy"))(nextDate)
  }

}
