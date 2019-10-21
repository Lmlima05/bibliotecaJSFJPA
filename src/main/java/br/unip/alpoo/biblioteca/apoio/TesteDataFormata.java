/*
 * Created on 04/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.unip.alpoo.biblioteca.apoio;

import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * @author Luan
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TesteDataFormata {
    
    
    public static void main(String[] args) {
	    Date dataCorrente= new Date(System.currentTimeMillis());
        						
        DataFormata dataformata =DataFormata.getInstance();

        String mostraFormata ;
        try {
            mostraFormata ="data formata curta =  " + dataformata.getDataFormataCurta("14/04/2004")+ "\n\n" + 
                "hora media  =  " + dataformata.getDataFormataMedia("04/04/2004")+ "\n\n"+
                "hora texto =  " + dataformata.getDataFormataTexto("22/04/2004")+ "\n\n" +
                "hora americano =  " + dataformata.getDataFormataMediaAmericana(dataCorrente)+ "\n\n" +
   
                "data formata curta =  " + dataformata.getDataFormataCurta(dataCorrente)+ "\n\n" + 
            	"hora media  =  " + dataformata.getDataFormataMedia(dataCorrente)+ "\n\n"+
            	"hora texto =  " + dataformata.getDataFormataTexto(dataCorrente)+ "\n\n";
            JOptionPane.showMessageDialog(null,mostraFormata);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.exit(0);
    }
}
