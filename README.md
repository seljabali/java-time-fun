<p align="center" >
  <img src="screenshots/logo.png" width=300px alt="SwiftDate" title="SwiftDate">
</p>

<p align="center"><strong>Java Time Kotlin extension functions.</strong></p>

## Background
[Java Time](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html) became integrated to the JDK as of Java 8. It was a huge improvement over its [Date](https://docs.oracle.com/javase/8/docs/api/java/sql/Date.html) predecessor.<br><br>
Java Time Fun library empowers Java Time even more, making usage of dates & times a breeze.

## What's In It?
#### 1. Parsing
```kotlin
// Provided time
val result = "01:30 AM".parseLocalTime()

// Provided local date
val result = "2021-06-07".parseLocalDate()

// Provided ambiguous date formats
val result = "06/07/2021".parseLocalDate(format = "MM/dd/yyyy")

// Automatic time zone conversions
val result = "2021-10-04T10:10:00+0000".parseZonedDateTime()

// Maintain original time zone
val result = "2021-10-04T10:10:00+0000".parseZonedDateTime(useSystemTimeZone = false)

// Parse LocalDate as ZonedDateTime
val result = "2021-06-07".parseZonedDateTime()
```
#### 2. Creation
```kotlin
val result = ZonedDateTimeUtil.new(year = 2021, month = 3, day = 25)

val result = LocalDateTimeUtil.new(Date())

val result = LocalDateUtil.new(GregorianCalendar())

val result = LocalTimeUtil.new(hour = 5, minute = 30)
```

#### 3. Comparisons
```kotlin
// Year
val result = dateA.compareYear(dateB)
val result = dateA.isBeforeYear(dateB)

// Month
val result = dateA.compareMonth(dateB)
val result = dateA.getMonthDifference(dateB)
val result = dateA.isEqualMonth(dateB)

// Day
val result = dateA.compareDay(dateB)
val result = dateA.getDayDifference(dateB)
val result = dateA.isAfterEqualDay(dateB)

// Time
val result = dateA.compareTime(dateB)
val result = dateA.getMinuteDifference(dateB)
val result = dateA.isAfterEqualTime(dateB)
```

#### 4. Print
```kotlin
val date = "2021-07-06".parseZonedDateTime()
val result = date.print(format = "MM/dd/yyyy")
```

#### 5. Attributes
```kotlin
val result = date.isAtStartOfDay()

val result = date.getDaysInMonth()
```

#### 6. Mutations
```kotlin
val result = date.atStartOfDay()

val result = date.getLast(DayOfWeek.FRIDAY)

val result = date.getNext(DayOfWeek.MONDAY)
```

#### 7. Preset Dates
```kotlin
val result = ZonedDateTimes.today

val result = LocalDateTimes.tomorrow

val result = LocalDates.nextMonday
```

## Install
Add to module `build.gradle`:
```gradle
repositories {
  mavenCentral()
}

dependencies {
  implementation("org.eljabali.sami.javatimefun:javatimefun:0.6")
}  
```

<details>
<summary>For Android</summary>

In addition to the above, you need to desugar your module:
- Ensure you're using [Gradle Plugin](https://developer.android.com/studio/releases/gradle-plugin#updating-plugin) 4.0.0+.
- Update module `build.gradle`:
```gradle
android {
    defaultConfig {
        // Required when setting minSdkVersion to 20 or lower
        multiDexEnabled true
    }

    compileOptions {
        // Flag to enable support for the new language APIs
        coreLibraryDesugaringEnabled true
        // Sets Java compatibility to Java 8
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}

dependencies {
    coreLibraryDesugaring 'com.android.tools:desugar_jdk_libs:1.1.5'
}
```
For more information on Android desugaring click [here](https://developer.android.com/studio/write/java8-support#library-desugaring).

</details>
