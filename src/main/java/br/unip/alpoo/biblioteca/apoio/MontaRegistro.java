
package br.unip.alpoo.biblioteca.apoio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


/**
 * @author Luan
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MontaRegistro {

	private MontaRegistro(){}
	private static MontaRegistro singleton;
	/**
	 * Fornece refer�ncia para a �nica inst�ncia desta classe,
	 * a partir da qual poder�o ser invocados os m�todos de persist�ncia.
	 * 
	 * @return Refer�ncia para o objeto. 
	 */
	public static MontaRegistro getInstance(){
		if (singleton == null){ singleton = new MontaRegistro(); } return singleton;
	 }

	/*
	 * L� no resultset o valor da coluna especificada.
	 * Se for NULL, retorna null. Sen�o retorna um Integer. 
	 * 
	 * @param pResultSet
	 *        Um ResultSet posicionado no registro desejado.
	 * @param pNomeDaColuna
	 *        Nome da coluna que ser� lida.
	 * @throws SQLException
	 *         Se ocorrer erro de acesso ao ResultSet. 
	 */
	 
	protected Integer montaInteger(ResultSet pResultSet, String pNomeDaColuna)
			throws SQLException {
		
		Integer valor = new Integer (pResultSet.getInt(pNomeDaColuna));
		if (pResultSet.wasNull()){
			return null;
		}else{
			return valor;
		}
	}

	/*
	 * L� no resultset o valor da coluna especificada.
	 * Se for NULL, retorna null. Sen�o retorna um String. 
	 * 
	 * @param pResultSet
	 *        Um ResultSet posicionado no registro desejado.
	 * @param pNomeDaColuna
	 *        Nome da coluna que ser� lida.
	 * @throws SQLException
	 *         Se ocorrer erro de acesso ao ResultSet. 
	 */
	protected String montaString(ResultSet pResultSet, String pNomeDaColuna)
			throws SQLException {
		
		String valor = pResultSet.getString(pNomeDaColuna);
		if (pResultSet.wasNull()){
			return null;
		}else{
			return valor;
		}
	}

	/*
	 * L� no resultset o valor da coluna especificada.
	 * Se for NULL, retorna null. Sen�o retorna um Short. 
	 * 
	 * @param pResultSet
	 *        Um ResultSet posicionado no registro desejado.
	 * @param pNomeDaColuna
	 *        Nome da coluna que ser� lida.
	 * @throws SQLException
	 *         Se ocorrer erro de acesso ao ResultSet. 
	 */
	protected Short montaShort(ResultSet pResultSet, String pNomeDaColuna)
			throws SQLException {
		
		Short valor = new Short (pResultSet.getShort(pNomeDaColuna));
		if (pResultSet.wasNull()){
			return null;
		}else{
			return valor;
		}
	}


	/*
	 * L� no resultset o valor da coluna especificada.
	 * Se for NULL, retorna null. Sen�o retorna um byte. 
	 * 
	 * @param pResultSet
	 *        Um ResultSet posicionado no registro desejado.
	 * @param pNomeDaColuna
	 *        Nome da coluna que ser� lida.
	 * @throws SQLException
	 *         Se ocorrer erro de acesso ao ResultSet. 
	 */
	protected Byte montaByte(ResultSet pResultSet, String pNomeDaColuna)
			throws SQLException {
				
		Byte valor = new Byte (pResultSet.getByte(pNomeDaColuna));
		if (pResultSet.wasNull()){
			return null;
		}else{
			return valor;
		}
	}

	/*
	 * L� no resultset o valor da coluna especificada.
	 * Se for NULL, retorna null. Sen�o retorna um Boolean. 
	 * 
	 * @param pResultSet
	 *        Um ResultSet posicionado no registro desejado.
	 * @param pNomeDaColuna
	 *        Nome da coluna que ser� lida.
	 * @throws SQLException
	 *         Se ocorrer erro de acesso ao ResultSet. 
	 */
	protected Boolean montaBoolean(ResultSet pResultSet, String pNomeDaColuna)
			throws SQLException {
		
		Boolean valor = new Boolean (pResultSet.getBoolean(pNomeDaColuna));
		if (pResultSet.wasNull()){
			return null;
		}else{
			return valor;
		}
	}


	/*
	 * L� no resultset o valor da coluna especificada.
	 * Se for NULL, retorna null. Sen�o retorna um Date. 
	 * 
	 * @param pResultSet
	 *        Um ResultSet posicionado no registro desejado.
	 * @param pNomeDaColuna
	 *        Nome da coluna que ser� lida.
	 * @throws SQLException
	 *         Se ocorrer erro de acesso ao ResultSet. 
	 */
	protected Date montaDate(ResultSet pResultSet, String pNomeDaColuna)
			throws SQLException {
		
		Date valor = pResultSet.getDate(pNomeDaColuna);
		if (pResultSet.wasNull()){
			return null;
		}else{
			return valor;
		}
	}

	/*
	 * L� no resultset o valor da coluna especificada.
	 * Se for NULL, retorna null. Sen�o retorna um Timestamp. 
	 * 
	 * @param pResultSet
	 *        Um ResultSet posicionado no registro desejado.
	 * @param pNomeDaColuna
	 *        Nome da coluna que ser� lida.
	 * @throws SQLException
	 *         Se ocorrer erro de acesso ao ResultSet. 
	 */
	protected Timestamp montaTimestamp(ResultSet pResultSet, String pNomeDaColuna)
			throws SQLException {
		
		Timestamp valor = pResultSet.getTimestamp(pNomeDaColuna);
		if (pResultSet.wasNull()){
			return null;
		}else{
			return valor;
		}
	}
	
    
    
}
