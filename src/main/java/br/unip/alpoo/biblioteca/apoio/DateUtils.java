
package	br.unip.alpoo.biblioteca.apoio;

/**
 * This class contains all the methods which are useful for manipulating
 * dates.
 */
public class DateUtils
{
	/**
	 * Returns the number of days in a perticular month of a year. This method
	 * returns no. of actual days that will be/was in the specified year and
	 * month. It considers leap year also.
	 *
	 * @param	iYear	year
	 * @param	iMonth	month
	 * @return	number of days in the month
	 */
	public static int getDaysInMonth( int iYear, int iMonth )
	{
		switch( iMonth )
		{
		case 3:
		case 5:
		case 8:
		case 10:
			return	30;
		case 1:		// February
			return	((iYear%4)==0 || (iYear%200)==0) ? 29 : 28;
		default:
			return	31;
		}
	}
	
}
