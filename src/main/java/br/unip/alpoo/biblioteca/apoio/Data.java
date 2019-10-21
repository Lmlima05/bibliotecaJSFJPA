 /*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.unip.alpoo.biblioteca.apoio;

import java.text.DateFormat;
import java.util.Date;


public final class Data {

	private static Data singleton;

	private Data(){}
	
	/**
	 * Fornece refer�ncia para a �nica inst�ncia desta classe,
	 * a partir da qual poder�o ser invocados os m�todos.
	 * 
	 * @return Refer�ncia para o objeto.
	 */
	public static Data getInstance(){
		if (singleton == null){ singleton = new Data(); } return singleton;
	 }
	/**
	 * Retorna uma data corrente do sistema operacional. Data no formato de 
	 * sat nov 27 09:37:14 GMT-03:00 2004
	 *
	 * @return	dateCorrente do tipo Date
	 */
	public Date getDataCorrente(){
	    Date dataCorrente= new Date(System.currentTimeMillis());
        return dataCorrente; 
	    
	}
	
	/**
	 * Retorna uma data no formato string. A String ser� formatada 
	 * 	
	 * @param pData - util.Date para converter
	 * 
	 * @return data 
	 */
	public String getDataCompleta(Date pData) {
		if (pData != null){
		    DateFormat dataEntrada = DateFormat.getDateInstance(DateFormat.FULL);
			String data = dataEntrada.format(pData);
			return data;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}
	/**
	 * Retorna uma data no formato string. A String ser� formatada 
	 * 	
	 * @param pData - util.Date para converter
	 * 
	 * @return data
	 */  
	public String getDataLonga(Date pData) {
		if (pData != null){
		    DateFormat dataEntrada = DateFormat.getDateInstance(DateFormat.LONG);
			String data = dataEntrada.format(pData);
			return data;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}
	
	/**
	 * Retorna uma data no formato string. A String ser� formatada 
	 * 	
	 * @param pData - util.Date para converter
	 * 
	 * @return data
	 */  
	public String getDataMedia(Date pData) {
		if (pData != null){
		    DateFormat dataEntrada = DateFormat.getDateInstance(DateFormat.MEDIUM);
			String data = dataEntrada.format(pData);
			return data;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}
	
	
	/**
	 * Retorna uma data no formato string. A String ser� formatada 
	 * 	
	 * @param pData - util.Date para converter
	 * 
	 * @return data
	 */  
	
	public String getDataCurta(Date pData) {
		if (pData != null){
		    DateFormat dataEntrada = DateFormat.getDateInstance(DateFormat.SHORT);
			String data = dataEntrada.format(pData);
			return data;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}

	/**
	 * Retorna uma data no formato string. A String ser� formatada 
	 * 	
	 * @param pData - util.Date para converter
	 * 
	 * @return data
	 */  
	
	public String getDataDefault(Date pData) {
		if (pData != null){
		    DateFormat dataEntrada = DateFormat.getDateInstance(DateFormat.DEFAULT);
			String data = dataEntrada.format(pData);
			return data;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}


}
