package com.azakordonets.tests


import com.azakordonets.entities.DatesRange
import com.azakordonets.enums.DateRangeType._
import com.azakordonets.enums.{DateFormat, DateRangeType}
import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}
import org.testng.annotations.{BeforeMethod, DataProvider, Test}

class DatesRangeTestSuite extends DateTimeBaseTestSuite {

  var dateRange: DatesRange = null

  @BeforeMethod
  def init() = {
    dateRange = new DatesRange
  }

  @Test
  def testDefaultValues() = {
    val datesRange = dateRange.asDatesList
    assert(datesRange.length == 12)
    val date0 = datesRange.head
    val date1 = datesRange(1)
    assertDates(date0, date1, MONTHS)
    assert(date1.getMonthOfYear - date0.getMonthOfYear == 1)
  }

  @Test
  def testDefaultValuesAsStringsWithDefaultFormat() = {
    val datesRange = dateRange.asStringsList()
    assert(datesRange.length == 12)
    val formatter: DateTimeFormatter = DateTimeFormat.forPattern("dd-MM-yyyy")
    val date0 = DateTime.parse(datesRange.head, formatter)
    val date1 = DateTime.parse(datesRange(1), formatter)
    assertDates(date0, date1, MONTHS)
    assert(date1.getMonthOfYear - date0.getMonthOfYear == 1)
  }

  @Test
  def testDefaultValuesAsStringsWithCustomFormat() = {
    val format: DateFormat = DateFormat.dd_MM_yyyy_SEMICOLON
    val datesRange = dateRange.asStringsList(format)
    assert(datesRange.length == 12)
    val formatter: DateTimeFormatter = DateTimeFormat.forPattern(format.getFormat)
    val date0 = DateTime.parse(datesRange.head, formatter)
    val date1 = DateTime.parse(datesRange(1), formatter)
    assertDates(date0, date1, MONTHS)
    assert(date1.getMonthOfYear - date0.getMonthOfYear == 1)
  }

  @DataProvider
  def datesRangeDP(): Array[Array[Any]] = {
    Array(Array(2001, 1, 1, 2010, 1, 1, YEARS, 1, 9),
      Array(2001, 1, 1, 2010, 1, 1, YEARS, 2, 5),
      Array(2001, 1, 1, 2010, 1, 1, MONTHS, 1, 108),
      Array(2001, 1, 1, 2010, 1, 1, MONTHS, 2, 54),
      Array(2001, 1, 1, 2010, 1, 1, WEEKS, 2, 235),
      Array(2001, 1, 1, 2001, 10, 1, DAYS, 10, 28),
      Array(2001, 1, 1, 2001, 10, 1, HOURS, 10, 656),
      Array(2001, 1, 1, 2001, 10, 1, MINUTES, 10, 39306)
    )
  }

  @Test(dataProvider = "datesRangeDP")
  def testDateRangeInYears(startYear: Int, startMonth: Int, startDay: Int, endYear: Int, endMonth: Int, endDay: Int, rangeType: DateRangeType, step: Int, expectedSize: Int) = {
    val datesRange = dateRange
      .startYear(startYear)
      .startMonth(startMonth)
      .startDay(startDay)
      .stepEvery(step, rangeType)
      .endYear(endYear)
      .endMonth(endMonth)
      .endDay(endDay)
      .asDatesList
    assert(Math.abs(expectedSize - datesRange.length) <= 15)
  }

  @DataProvider
  def datesRangeOfDatesDP(): Array[Array[Any]] = {
    Array(Array(new DateTime(2001, 1, 1, 0, 0), new DateTime(2010, 1, 1, 0, 0), YEARS, 1, 9),
      Array(new DateTime(2001, 1, 1, 0, 0), new DateTime(2010, 1, 1, 0, 0), YEARS, 2, 5),
      Array(new DateTime(2001, 1, 1, 0, 0), new DateTime(2010, 1, 1, 0, 0), MONTHS, 1, 108),
      Array(new DateTime(2001, 1, 1, 0, 0), new DateTime(2010, 1, 1, 0, 0), MONTHS, 2, 54),
      Array(new DateTime(2001, 1, 1, 0, 0), new DateTime(2010, 1, 1, 0, 0), WEEKS, 2, 235),
      Array(new DateTime(2001, 1, 1, 0, 0), new DateTime(2001, 10, 1, 0, 0), DAYS, 10, 28),
      Array(new DateTime(2001, 1, 1, 0, 0), new DateTime(2001, 10, 1, 0, 0), HOURS, 10, 656),
      Array(new DateTime(2001, 1, 1, 0, 0), new DateTime(2001, 10, 1, 0, 0), MINUTES, 10, 39306)
    )
  }

  @Test(dataProvider = "datesRangeOfDatesDP")
  def testDateRangeInDates(startDate: DateTime, endDate: DateTime, rangeType: DateRangeType, step: Int, expectedSize: Int) = {
    val datesRange = dateRange
      .startDate(startDate)
      .stepEvery(step, rangeType)
      .endDate(endDate)
      .asDatesList
    assert(Math.abs(expectedSize - datesRange.length) <= 15)
  }

  @Test
  def testDatesRangeWithCustomFormat() = {
    val datesRange = dateRange.startDate(DateTime.now())
      .endDate(DateTime.now().plusYears(1))
      .format(DateFormat.dd_MM_yy)
      .asDatesList
    val date0 = datesRange.head
    val date1 = datesRange(1)
    assertDates(date0, date1, MONTHS)
    assert(date1.getMonthOfYear - date0.getMonthOfYear == 1)
  }
}
