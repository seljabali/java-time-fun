<p align="center" >
  <img src="screenshots/logo.png" width=300px alt="SwiftDate" title="SwiftDate">
</p>

<p align="center"><strong>Kotlin extension functions for Java Time.</strong></p>

## What's This?
[Java Time](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html) became integrated to the JDK as of Java 8, which was a huge improvement over [Date](https://docs.oracle.com/javase/8/docs/api/java/sql/Date.html). <br><br>
This library makes dates & times even that much easier to work with. 

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
val result = "2021-09-04T19:14:27+0000".parseZonedDateTime()

// Maintain original time zone
val result = "2021-09-04T19:14:27+0000".parseZonedDateTime(convertToDefaultTimeZone = false)

// Parse, zoned date time conversion, & time zone conversion
val result = "2021-06-07".parseZonedDateTime()
```
#### 2. Creation
```kotlin
val result = ZonedDateTimeUtil.new(year = 2021, month = 3, day = 25)

val result = ZonedDateTimeUtil.new(1325134800000)
```

#### 3. Comparisons
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

#### 5. Mutations
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

## How to install?
Add to root `build.gradle` at the end of repositories:
```gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```
Add to module `build.gradle`
```gradle
dependencies {
  implementation 'com.github.seljabali:java-time-plus:v0.1'
}  
```
### For Android
In addition to the above. Add to module `build.gradle`
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
This to enable Android desugaring, to find out more click [here](https://developer.android.com/studio/write/java8-support#library-desugaring).
