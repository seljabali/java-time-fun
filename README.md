<p align="center" >
  <img src="screenshots/logo.png" width=300px alt="SwiftDate" title="SwiftDate">
</p>

<p align="center"><strong>Kotlin extension functions for Java Time.</strong></p>

### What's This?
[Java Time](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html) became integrated to the JDK, as of Java 8, which was a huge improvement over [Date](https://docs.oracle.com/javase/8/docs/api/java/sql/Date.html). <br><br>
This library makes Java Time even that much easier to work with. 

### What's In It?
#### 1. Date Parsing
```kotlin
// Provided time
val result = "01:30 AM".parseLocalTime()

// Provided local date
val result = "2021-06-07".parseLocalDate()

// Provided ambiguous date formats
val result = "06/07/2021".parseLocalDate(format = "MM/dd/yyyy")

// Automatic time zone conversions
val result = "2021-09-04T19:14:27+0000".parseZonedDateTime()

// Maintain original time zone
val result = "2021-09-04T19:14:27+0000".parseZonedDateTime(convertToDefaultTimeZone = false)

// Parse, zoned date time conversion, & time zone conversion
val result = "2021-06-07".parseZonedDateTime()
```
#### 2. Date Creation
```kotlin
val result = ZonedDateTimeUtil.new(year = 2021, month = 3, day = 25)

val result = ZonedDateTimeUtil.new(1325134800000)
```

#### 3. Date Comparisons
```kotlin
// Day
val result = dateA.compareDay(dateB)
val result = dateA.isAfterEqualDay(dateB)

// Year
val result = dateA.compareYear(dateB)
val result = dateA.isBeforeYear(dateB)

// Month
val result = dateA.compareMonth(dateB)
val result = dateA.isEqualMonth(dateB)
val result = dateA.getMonthDifference(dateB)

// Time
val result = dateA.compareTime(dateB)
val result = dateA.isAfterEqualTime(dateB)
```

#### 4. Date Print
```kotlin
val date = "2021-07-06".parseZonedDateTime()
val result = date.print(format = "MM/dd/yyyy")
```

#### 5. Date Attributes
```kotlin
val result = date.isAtStartOfDay()

val result = date.getDaysInMonth()
```

#### 5. Date Mutations
```kotlin
val result = date.atStartOfDay()

val result = date.getLast(DayOfWeek.FRIDAY)

val result = date.getNext(DayOfWeek.MONDAY)
```

#### 5. Preset Dates
```kotlin
val result = ZonedDateTimes.today

val result = ZonedDateTimes.tomorrow

val result = ZonedDateTimes.lastMonday

val result = ZonedDateTimes.nextThursday
```
