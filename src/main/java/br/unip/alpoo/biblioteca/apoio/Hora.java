/*
 * Created on 04/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.unip.alpoo.biblioteca.apoio;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Luan
 *
 */
public class Hora {

	private static Hora singleton;

	private Hora(){}
	
	/**
	 * Fornece refer�ncia para a �nica inst�ncia desta classe,
	 * a partir da qual poder�o ser invocados os m�todos.
	 * 
	 * @return Refer�ncia para o objeto.
	 */
	public static Hora getInstance(){
		if (singleton == null){ singleton = new Hora(); } return singleton;
	 }
	
	/**
	 * Retorna hora no formato string. A String ser� formatada 
	 * 21h40min,39s GM-03:00
	 * 	
	 * @param pData - util.Date para converter
	 * 
	 * @return hora 
	 */
	public String getHoraCompleta(Date pData) {
		if (pData != null){
		    DateFormat dataEntrada = DateFormat.getTimeInstance(DateFormat.FULL);
			String hora = dataEntrada.format(pData);
			return hora;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}

	/**
	 * Retorna hora no formato string. A String ser� formatada 
	 * 	
	 * @param pData - util.Date para converter
	 * 
	 * @return hora 
	 */
	public String getHoraLonga(Date pData) {
		if (pData != null){
		    DateFormat dataEntrada = DateFormat.getTimeInstance(DateFormat.LONG);
			String hora = dataEntrada.format(pData);
			return hora;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}

	/**
	 * Retorna hora no formato string. A String ser� formatada 
	 * 	
	 * @param pData - util.Date para converter
	 * 
	 * @return hora 
	 */
	public String getHoraMedia(Date pData) {
		if (pData != null){
		    DateFormat dataEntrada = DateFormat.getTimeInstance(DateFormat.MEDIUM);
			String hora = dataEntrada.format(pData);
			return hora;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}


	/**
	 * Retorna hora no formato string. A String ser� formatada 
	 * 	
	 * @param pData - util.Date para converter
	 * 
	 * @return hora 
	 */
	public String getHoraCurta(Date pData) {
		if (pData != null){
		    DateFormat dataEntrada = DateFormat.getTimeInstance(DateFormat.SHORT);
			String hora = dataEntrada.format(pData);
			return hora;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}


	/**
	 * Retorna hora no formato string. A String ser� formatada 
	 * 	
	 * @param pData - util.Date para converter
	 * 
	 * @return hora 
	 */
	public String getHoraDefault(Date pData) {
		if (pData != null){
		    DateFormat dataEntrada = DateFormat.getTimeInstance(DateFormat.DEFAULT);
			String hora = dataEntrada.format(pData);
			return hora;
		}else{
			// String vazio, retorna null.
			return null;
		}
	}


}
