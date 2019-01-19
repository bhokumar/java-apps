package org.axway.datetimeapi;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class TestDateTime {

	public static void main(String[] args) {
		DateTimeBean dateTime = new DateTimeBean();
		dateTime.setDate(LocalDate.of(2016, Month.OCTOBER, 26));
		dateTime.setTime(LocalTime.of(12, 57, 52, 6000));
		dateTime.setDateTime(LocalDateTime.of(2016, Month.APRIL, 23, 04, 52, 36, 5000));

		LocalDate date = LocalDateTime.now().toLocalDate();
		LocalDate dateNow = LocalDate.now();
		System.out.println(date.toString());
		System.out.println(dateNow.toString());
		System.out.println(dateTime.toString());
		System.out.println(LocalTime.now().toString());
		System.out.println(LocalDateTime.now().toString());
		LocalDate currentDate = LocalDate.now();
		LocalDate birthday = LocalDate.of(2016, Month.FEBRUARY, 26);
		if (currentDate.isAfter(birthday)) {
			System.out.println(currentDate);
		}
		if (currentDate.isLeapYear()) {
			System.out.println(currentDate + " Is a leap year");
		}

		currentDate = currentDate.with(lastDayOfMonth());
		System.out.println(currentDate);

		LocalDateTime localDateTime = LocalDateTime.of(2015, Month.APRIL, 25, 12, 23, 23, 6000);

		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
		System.out.println(zonedDateTime);

		Instant instant1 = Instant.now();
		System.out.println(instant1.toString());

		LocalDate dateOfBirth = LocalDate.of(1992, Month.JULY, 24);
		MonthDay monthDay = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		System.out.println(monthDay);

		// Add hours in time
		LocalTime localTime = LocalTime.now();
		LocalTime newLocalTime = localTime.plusHours(2);
		System.out.println(newLocalTime);
		
		//Find date after one week
		LocalDate today = LocalDate.now();
		System.out.println("Day after one week : "+today.plus(1,ChronoUnit.WEEKS));
		
		//Date After and Before one Year
		System.out.println("Day After one year : "+ today.plus(1, ChronoUnit.YEARS));
		System.out.println("Day before one year : "+ today.minus(1, ChronoUnit.YEARS));

		//Use of Clock
		Clock clock = Clock.systemUTC();
		System.out.println(clock.instant());
	}

}
