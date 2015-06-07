package com.azakordonets.tests

import com.azakordonets.entities.RelativeDate
import com.azakordonets.enums.DateFormat
import org.joda.time.format.DateTimeFormat
import org.joda.time.{DateTime, DateTimeZone}
import org.testng.annotations.{BeforeMethod, Test}

class RelativeDateTestSuite extends DateTimeBaseTestSuite {

  var relativeDate: RelativeDate = null
  val currentDate: DateTime = DateTime.now()

  @BeforeMethod
  def init() = {
    relativeDate = new RelativeDate()
  }

  @Test
  def testDefaultConstructor() = {
    val currentDate = DateTime.now()
    assertDates(currentDate, relativeDate.asDate())
  }

  @Test
  def testDefaultConstructorWithCustomTimeZone() = {
    val currentDateInUTC = DateTime.now(DateTimeZone.UTC)
    val relativeDate: RelativeDate = new RelativeDate(DateTimeZone.UTC)
    assertDates(currentDateInUTC, relativeDate.asDate())
  }

  @Test
  def testTomorrow() = {
    val expectedDate = currentDate.plusDays(1)
    val tomorrow = relativeDate.tomorrow().asDate()
    assertDates(expectedDate, tomorrow)
  }

  @Test
  def testYesterday() = {
    val expectedDate = currentDate.minusDays(1)
    val yesterday = relativeDate.yesterday().asDate()
    assertDates(expectedDate, yesterday)
  }

  @Test
  def testPlusYears() = {
    val expectedDate = currentDate.plusYears(1)
    val date = relativeDate.years(1).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testMinusYears() = {
    val expectedDate = currentDate.minusYears(1)
    val date = relativeDate.years(-1).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testZeroYears() = {
    val expectedDate = currentDate
    val date = relativeDate.years(0).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testPlusMonths() = {
    val expectedDate = currentDate.plusMonths(1)
    val date = relativeDate.months(1).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testMinusMonths() = {
    val expectedDate = currentDate.minusMonths(1)
    val date = relativeDate.months(-1).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testZeroMonths() = {
    val expectedDate = currentDate
    val date = relativeDate.months(0).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testPlusWeeks() = {
    val expectedDate = currentDate.plusWeeks(1)
    val date = relativeDate.weeks(1).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testMinusWeeks() = {
    val expectedDate = currentDate.minusWeeks(1)
    val date = relativeDate.weeks(-1).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testZeroWeeks() = {
    val expectedDate = currentDate
    val date = relativeDate.weeks(0).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testPlusDays() = {
    val expectedDate = currentDate.plusDays(1)
    val date = relativeDate.days(1).asDate()
    assertDates(expectedDate, date)
  }
  @Test
  def testMinusDays() = {
    val expectedDate = currentDate.minusDays(1)
    val date = relativeDate.days(-1).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testZeroDays() = {
    val expectedDate = currentDate
    val date = relativeDate.days(0).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testPlusHours() = {
    val expectedDate = currentDate.plusHours(1)
    val date = relativeDate.hours(1).asDate()
    assertDates(expectedDate, date)
  }
  @Test
  def testMinusHours() = {
    val expectedDate = currentDate.minusHours(1)
    val date = relativeDate.hours(-1).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testZeroHours() = {
    val expectedDate = currentDate
    val date = relativeDate.hours(0).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testPlusMinutes() = {
    val expectedDate = currentDate.plusMinutes(1)
    val date = relativeDate.minutes(1).asDate()
    assertDates(expectedDate, date)
  }
  @Test
  def testMinusMinutes() = {
    val expectedDate = currentDate.minusMinutes(1)
    val date = relativeDate.minutes(-1).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testZeroMinutes() = {
    val expectedDate = currentDate
    val date = relativeDate.minutes(0).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testPlusSeconds() = {
    val expectedDate = currentDate.plusSeconds(1)
    val date = relativeDate.seconds(1).asDate()
    assertDates(expectedDate, date)
  }
  @Test
  def testMinusSeconds() = {
    val expectedDate = currentDate.minusSeconds(1)
    val date = relativeDate.seconds(-1).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testZeroSeconds() = {
    val expectedDate = currentDate
    val date = relativeDate.seconds(0).asDate()
    assertDates(expectedDate, date)
  }

  @Test
  def testAsStringWithDefaultFormatting() = {
    val formatter = DateTimeFormat.forPattern(DateFormat.dd_MM_yyyy.getFormat)
    val expectedDate = DateTime.now().toString(formatter)
    val date = relativeDate.asString()
    assertResult(expectedDate)(date)
  }

  @Test
  def testAsStringWithCustomFormatting() = {
    val format: DateFormat = DateFormat.dd_MM_yyyy_SEMICOLON
    val formatter = DateTimeFormat.forPattern(format.getFormat)
    val expectedDate = DateTime.now().toString(formatter)
    val date = relativeDate.asString(format)
    assertResult(expectedDate)(date)
  }




}
