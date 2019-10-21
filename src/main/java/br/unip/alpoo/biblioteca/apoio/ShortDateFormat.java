package	br.unip.alpoo.biblioteca.apoio;

import java.text.ParseException;
import java.util.Calendar;
import java.util.StringTokenizer;

public class ShortDateFormat {
	private static final char SHORT_DATE_SEP = '/';

	public ShortDateFormat()	{}
	
	public Calendar parseDate( String szText )
		throws	ParseException
	{
		StringTokenizer	stFields	= new StringTokenizer(szText,""+SHORT_DATE_SEP);

		// There should be only three fields viz. DD,MM,YYYY ....
		if( stFields.countTokens() < 3 )
			throw	new ParseException( "Dados insuficientes, s�o necess�rios dia, m�s e ano.", 0 );

		String	szDate	= stFields.nextToken();
		String	szMonth	= stFields.nextToken();
		String	szYear	= stFields.nextToken();
		int		iMonth	= -1;
		int		iDate	= -1;
		int		iYear	= -1;
		
		iYear	= Integer.parseInt(szYear);

		if( iYear < 0 )
			throw	new ParseException( "O ano n�o pode ser negativo.", 0 );

		// If only two digits of year are specified ...
		if( iYear < 100 )
		{
			// Use the current year ...
			iYear += Calendar.getInstance().get(Calendar.YEAR) / 100 * 100;
		}
		
		iMonth	= Integer.parseInt(szMonth);
		iMonth--;

		if( iMonth < 0 || iMonth > 11 )
			throw	new ParseException( "O m�s deve estar entre 1 e 12.", 0 );

		iDate	= Integer.parseInt(szDate);

		if( iDate < 1 || iDate > DateUtils.getDaysInMonth(iYear,iMonth) )
			throw	new ParseException( "O dia deve estar entre 1 e "
				+ DateUtils.getDaysInMonth(iYear,iMonth) + ".", 0 );

		// Create the Calendar object with the converted values ...
		Calendar	cDate	= Calendar.getInstance();
		cDate.clear();
		cDate.set( iYear, iMonth, iDate );
		return	cDate;
	}

	/**
	 * retorna data no formato string. O formato da string DD/MM/YYYY.
	 *
	 * @param	cDate	date to convert
	 * @return	date in string format
	 */
	public String formatDate( Calendar cDate )
	{
		String	szDate	= "" + cDate.get(Calendar.DAY_OF_MONTH);
		szDate	+= "" + (char)SHORT_DATE_SEP;
		szDate	+= (cDate.get(Calendar.MONTH)+1);
		szDate	+= "" + (char)SHORT_DATE_SEP; 
		szDate	+= cDate.get(Calendar.YEAR);
		return	szDate;
	}
}
