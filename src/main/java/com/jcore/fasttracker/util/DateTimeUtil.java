package com.jcore.fasttracker.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeUtil {

	private static ZoneId DEFAULT_TIMEZONE = ZoneId.of("Europe/Amsterdam");

	public static boolean isBeforeToday(ZonedDateTime compare) {
		// TODO: Someday we'll make it user location dependent
		ZonedDateTime now = ZonedDateTime.now(DEFAULT_TIMEZONE);

		return toDays(compare).isBefore(toDays(now));
	}

	public static boolean isAfterToday(ZonedDateTime compare) {
		// TODO: Someday we'll make it user location dependent
		ZonedDateTime now = ZonedDateTime.now(DEFAULT_TIMEZONE);

		return toDays(compare).isAfter(toDays(now));
	}

	private static ZonedDateTime toDays(ZonedDateTime zdt) {
		return zdt.truncatedTo(ChronoUnit.DAYS);
	}
}