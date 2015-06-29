# Utils

[![Build Status](https://travis-ci.org/azakordonets/Utils.svg?branch=master)](https://travis-ci.org/azakordonets/Utils) &nbsp;&nbsp;&nbsp;&nbsp;   [![Coverage Status](https://coveralls.io/repos/azakordonets/Utils/badge.png)](https://coveralls.io/r/azakordonets/Utils)

This library contains set of handy utils methods that you could use in your project. 
 
Usage
-----

Utils consist out of next utility objects : 
* DateTime - everything that is related to date or time generation/conversion, getting relative date
* Hashing - can encode any String into hash using md5, sha1, sha256, sha512 and other algorithms 


DateTime
--------
At this moment you can get some date range, or relative date as a Date or String object

```scala
import com.azakordonets.utils._

val datesRange = GetUtil.DateTime.datesRange // default date range that starts today and ends in 1 year. Difference between dates - 1 month

val datesRange = GetUtil.DateTime.datesRange.endMonth(12).endYear(2016).asDatesList // list of dates from today, till 01.12.2016 with 1 month step

val datesRange = GetUtil.DateTime.datesRange.stepEvery(DateRangeType.DAY, 10).asStringsList // list of dd-MM-yyyy formatted dates from today till year from now with every 10 days step

val relativeDate = GetUtil.DateTime.relativeDate

val yesterday = relativeDate.yesterday.asDate 
 
val two_weeks_ahead = relativeDate.weeks(2).asString // dd-MM-yyyy formatted date two weeks ahead since now

val two_weeks_and_three_days_ago = relativeDate.days(-3).weeks(-2).asString(DateFormat.dd_MM_yy_SEMICOLON)// dd:MM:yy formatted date 2 weeks and 3 days ago

val nextThursday = GetUtil.DateTime.getNext(Day.THURSDAY).asDate // date of next Thursday

val nextFriday = GetUtil.DateTime.getNext(Day.Friday).asString(DateFormat.dd_MM_yyyy) // dd-MM-yyyy formatted next Friday date
```

Hashing
-------
For this purpose i used [Hasher](https://github.com/Nycto/Hasher) library . Utils method provides a simple wrapper 
that covers only part of available library functionality, but it will be extended in the future. 

```scala
import com.azakordonets.utils.GetUtil._

val password = "SuperSecretPassword"

val hashedString = Hash(password).sha512 // hashed with sha512 password returned as String

val hashedAndSoltedString = Hash(password).salt("secret").sha512 // encrypted with salt

```


