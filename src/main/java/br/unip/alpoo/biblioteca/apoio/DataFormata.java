/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.unip.alpoo.biblioteca.apoio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Luan
 *
 */
public final class DataFormata {

	private static DataFormata singleton;

	private DataFormata(){}
	
	/**
	 * Fornece refer�ncia para a �nica inst�ncia desta classe,
	 * a partir da qual poder�o ser invocados os m�todos.
	 * 
	 * @return Refer�ncia para o objeto.
	 */
	public static DataFormata getInstance(){
		if (singleton == null){ singleton = new DataFormata(); } return singleton;
	 }
		
	/**
	 * Retorna uma data no formato Date. A Date ser� formatada 
	 * 	
	 * @param pData - uma string no formato Date
	 * 
	 * @return data - util.date
	 *  
	 * @throws ParseException - formato estiver incorreto 
	 */  
	public Date getDataFormataMedia(String pData) throws ParseException   {
		if (pData != null){
		    SimpleDateFormat dataEntrada = new  SimpleDateFormat("dd/MM/yyyy");
		    Date data = dataEntrada.parse(pData);
			return data;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}

	/**
	 * Retorna uma data no formato String. A Date ser� formatada 
	 * 	
	 * @param pData - uma string no formato Date
	 * 
	 * @return data - formato string
	 *  
	 */  
	public String getDataFormataMedia(Date pData) {
		if (pData != null){
		    SimpleDateFormat dataEntrada = new  SimpleDateFormat("dd/MM/yyyy");
			String data = dataEntrada.format(pData);
			return data;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}
	
	/**
	 * Retorna uma data no formato String. A Date ser� formatada 
	 * 	
	 * @param pData - uma string no formato Date
	 * 
	 * @return data - formato string
	 *  
	 */  
	public String getDataFormataMediaAmericana(Date pData) {
		if (pData != null){
		    SimpleDateFormat dataEntrada = new  SimpleDateFormat("yyyy-MM-dd");
			String data = dataEntrada.format(pData);
			return data;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}

	
	/**
	 * Retorna uma data no formato Date. A Date ser� formatada 
	 * 	
	 * @param pData - uma string no formato Date
	 * 
	 * @return data - util.date
	 *  
	 * @throws ParseException - formato estiver incorreto 
	 */  
	public Date getDataFormataCurta(String pData) throws ParseException   {
		if (pData != null){
		    SimpleDateFormat dataEntrada = new  SimpleDateFormat("d/M/yy");
		    Date data = dataEntrada.parse(pData);
			return data;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}

	/**
	 * Retorna uma data no formato String. A Date ser� formatada 
	 * 	
	 * @param pData - uma string no formato Date
	 * 
	 * @return data - data no formato string
	 *  
	 */  
	public String getDataFormataCurta(Date pData)   {
		if (pData != null){
		    SimpleDateFormat dataEntrada = new  SimpleDateFormat("d/M/yy");
			String data = dataEntrada.format(pData);
			return data;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}
	
	
	/**
	 * Retorna uma data no formato Date. A Date ser� formatada 
	 * 	
	 * @param pData - uma string no formato Date
	 * 
	 * @return data - String
	 *  
	 * @throws ParseException - formato estiver incorreto 
	 */  
	public String getDataFormataTexto(String pData) throws ParseException   {
		if (pData != null){
		    String mascara = "'Brasilia, ' EEEE , dd 'de' MMMM ' de ' yyyy - HH:mm:ss";
		  
		    SimpleDateFormat dataEntrada = new  SimpleDateFormat("dd/MM/yyyy");
		    Date dataConvertida = dataEntrada.parse(pData);

		    SimpleDateFormat dataSaida = new   SimpleDateFormat( mascara);
		    String data = dataSaida.format(dataConvertida);
			return data;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}

	/**
	 * Retorna uma data no formato Date. A Date ser� formatada 
	 * 	
	 * @param pData - Date
	 * 
	 * @return data - String 
	 *  
	 * @throws ParseException - formato estiver incorreto 
	 */  
	public String getDataFormataTexto(Date pData) throws ParseException   {
		if (pData != null){
		    String mascara = "'Brasilia, ' EEEE , dd 'de' MMMM ' de ' yyyy - HH:mm:ss";
		    SimpleDateFormat dataSaida = new   SimpleDateFormat(mascara);
		    String data = dataSaida.format(pData);
			return data;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}


}
