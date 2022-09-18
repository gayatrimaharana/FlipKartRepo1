package org.tyss.genericUtility;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
/**
 * This class contains java reusable methods
 * @author User
 *
 */

public final class JavaUtility {
	/**
	 * This method is used to generate the random number within 1000
	 * @return
	 */
	public int getRandomNumber()
	{
		return new Random().nextInt(1000);
	}
	/**
	 * This method is used to generate the random number based on limit
	 * @return
	 */
	public int getRandomNumber(int limit)
	{
		return new Random().nextInt(limit);
	}
	/**
	 * This method is used to convert string to long data type
	 * @param Data
	 * @return
	 */
	public Long convertStringToLong(String Data)
	{
		return Long.parseLong(Data);
	}
	/**
	 * This method is used to print the value in console
	 * @param value
	 */
	public void printStatement(String value)
	{
		System.out.println(value);
	}
	/**
	 * This method is used to split the string based on strategy
	 * @param value
	 * @param strategy
	 * @return
	 */
	public String[] splitString(String value,String strategy)
	{
		return value.split(strategy);
	}
	/**
	 * This method is used to get current date in specified strategy
	 * @param strategy
	 * @return
	 */
	public String getCurrentDate(String strategy)
	{
		return new SimpleDateFormat(strategy).format(new Date());
	}
	
	public static int convertMonthFromStringToInt(String monthName,String strategy)
	{
	return	DateTimeFormatter.ofPattern(strategy).withLocale(Locale.ENGLISH).parse(monthName).get(ChronoField.MONTH_OF_YEAR);
	}

}
