
package br.unip.alpoo.biblioteca.apoio;

import java.util.Date;

import javax.swing.JOptionPane;

/**
 * @author Luan
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TesteHora {
    
    
    public static void main(String[] args) {
	    Date dataCorrente= new Date(System.currentTimeMillis());

        Hora hora =Hora.getInstance();

        String mostraHora =
		"hora completa =  " + hora.getHoraCompleta(dataCorrente)+ "\n\n" + 
		"hora longa =  " + hora.getHoraLonga(dataCorrente)+ "\n\n" + 
		"hora media =  " + hora.getHoraMedia(dataCorrente)+ "\n\n" + 
		"hora curta =  " + hora.getHoraCurta(dataCorrente)+ "\n\n" + 
		"hora padrao =  " + hora.getHoraDefault(dataCorrente)+ "\n\n" ; 
		
        JOptionPane.showMessageDialog(null,mostraHora);
        
        System.exit(0);
    }
}
