/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.unip.alpoo.biblioteca.apoio;

import java.util.Date;

import javax.swing.JOptionPane;

/**
 * @author Luan
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TesteData {
    
    
    public static void main(String[] args) {
	    Date dataCorrente= new Date(System.currentTimeMillis());
	    
        Data data =Data.getInstance();
        String mostraData ="data corrente =  " + data.getDataCorrente()+ "\n\n" +
						"data completa =  " + data.getDataCompleta(dataCorrente)+ "\n\n" + 
						"data longa =  " + data.getDataLonga(dataCorrente)+ "\n\n" + 
						"data media =  " + data.getDataMedia(dataCorrente)+ "\n\n" + 
						"data curta =  " + data.getDataCurta(dataCorrente)+ "\n\n" + 
						"data padrao =  " + data.getDataDefault(dataCorrente)+ "\n\n" ; 
						
        JOptionPane.showMessageDialog(null,mostraData);

        
        System.exit(0);
    }
}
