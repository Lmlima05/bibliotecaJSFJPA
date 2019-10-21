package br.unip.alpoo.biblioteca.apoio;

public class Numero {
	
	   public static String preencheZeroNumero(String pNumero, String pLetra, int pTamanho){
        	
	        if (pNumero == null || pNumero.trim() == "" ) {
	        	pNumero = "";
	        }
	             
	        while (pNumero.contains("  ")) {
	        	pNumero = pNumero.replaceAll("  "," ").trim();
	        }
	   
	        pNumero = pNumero.replaceAll("[./-]","");
	        StringBuffer sb = new StringBuffer(pNumero);
	         for (int i=sb.length() ; i<pTamanho ; i++){
	                sb.insert(0,pLetra);
	           }
	        return sb.toString();
	    }


}
