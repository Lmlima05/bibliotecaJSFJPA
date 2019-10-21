package br.unip.alpoo.biblioteca.apoio;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public final class Calendario {

	private GregorianCalendar calendario;

    public final ShortDateFormat FORMATO_PARA_DATA = new ShortDateFormat();

	private Calendario(){
		calendario = new GregorianCalendar();
	}
	private static Calendario singleton;
	
	/**
	 * Fornece refer�ncia para a �nica inst�ncia desta classe,
	 * a partir da qual poder�o ser invocados os m�todos.
	 * 
	 * @return Refer�ncia para o objeto.
	 */
	public static Calendario getInstance(){
		if (singleton == null){ singleton = new Calendario(); } return singleton;
	 }

	public int getAno(Date pData){
		calendario.setTime(pData);
		return calendario.get(GregorianCalendar.YEAR); 
	}

	public int getMes(Date pData){
		calendario.setTime(pData);
		return calendario.get(GregorianCalendar.MONTH); 
	}

	public int getDia(Date pData){
		calendario.setTime(pData);
		return calendario.get(GregorianCalendar.DAY_OF_MONTH); 
	}
	public Date getDataCorrenteUtil(){
		return Calendar.getInstance().getTime();

	}
	
	public String getHoraCorrente(){
		DateFormat hora = DateFormat.getTimeInstance();
		return hora.format(Calendar.getInstance().getTime());

	}

	// dd/mm/yyyyy 
	public String getData(Date pData){
		if (pData != null){
			ShortDateFormat f = FORMATO_PARA_DATA;
			calendario.setTime(pData);
			String txt = f.formatDate(calendario);
			return txt;
		}else{
			return "";
		}
	}
	
	// dd/mm/yyyyy 
	public Date getData(String pData) throws ParseException{
		if (pData.length() > 0){
			ShortDateFormat f = FORMATO_PARA_DATA;
			// Recebe valor como Calendar
			Calendar c = f.parseDate(pData);
			// Converte valor para Date
			Date d = c.getTime();
			return d;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}

	// dd/mm/yyyyy -  no formato java.sql.Date
	public java.sql.Date convertDataUtilDataSQL(Date pData){
		if (pData != null){
			java.sql.Date dataSQL = new java.sql.Date(pData.getTime());
			return dataSQL;
		}else{
			return null;
		}
	}
	 public  java.sql.Time getHoraCorrenteSQL() {
		    java.util.Date date = Calendar.getInstance().getTime();
		    return new java.sql.Time(date.getTime());
	  }
	
	public java.sql.Time convertStringHoraTimeSQL(String pHora){
		if (pHora != null){
			java.sql.Time myTime =java.sql.Time.valueOf(pHora);
			return myTime;
		}else{
			return null;
		}
	}
	
	
}
