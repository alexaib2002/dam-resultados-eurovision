package org.uem.gestor_resultados_eurovision.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.uem.gestor_resultados_eurovision.contract.ResultadoContract;
import org.uem.gestor_resultados_eurovision.contract.TableContract;
import org.uem.gestor_resultados_eurovision.model.Resultado;
import org.uem.gestor_resultados_eurovision.utils.SQLQueryBuilder;

public class DBPersistence {
	
	private DBConnection dbConnection;
	
	public DBPersistence() {
		dbConnection = new DBConnection();
	}
	
	public ArrayList<Resultado> getResultadosList() {
		ArrayList<Resultado> resultados = new ArrayList<>();
		
		ResultSet rset = null;
		Connection con = null;
		Statement stmt = null;
		
		int c = 1;
		
		try {
			con = dbConnection.getConnection();
			stmt = con.createStatement();
			String query = SQLQueryBuilder.buildSelectQuery(TableContract.PARTICIPANTES.toString(),
					ResultadoContract.getTableCols(), null, "PUNTOS", false);
			rset = stmt.executeQuery(query);
			
			while (rset.next()) {
				resultados.add(new Resultado(c, 
						rset.getString(ResultadoContract.PAIS.toString()),
						rset.getString(ResultadoContract.CANCION.toString()), 
						rset.getString(ResultadoContract.INTERPRETE.toString()),
						rset.getInt(ResultadoContract.PUNTOS.toString())));
				c++;
			}
			
		} catch (Exception e) {
			System.err.println("Excepcion desconocida");
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Excepcion en codigo SQL");
			}
		}
		
		return resultados;
	}
	
	public int getPuntosJurado(String pais) {
		int pts = -1;
		ResultSet rset = null;
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = dbConnection.getConnection();
			stmt = con.createStatement();
			String query = SQLQueryBuilder.buildSelectQuery(TableContract.PARTICIPANTES.toString(),
					new String[] { ResultadoContract.PUNTOS_JURADO.toString() },
					new String[] { String.format("%s LIKE '%s'", ResultadoContract.PAIS.toString(), pais) }, 
					null, false);
			rset = stmt.executeQuery(query);
			pts = rset.getInt(ResultadoContract.PUNTOS_JURADO.toString());
			
		} catch (Exception e) {
			System.err.println("Excepcion desconocida");
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.err.println("Excepcion en codigo SQL");
			}
		}
		
		return pts;
	}

	public int updateResultado(UpdateExpression expr) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dbConnection.getConnection();
			pstmt = expr.executeUpdateSQL(con, pstmt);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error en codigo SQL");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
				System.out.println("Conexion a BBDD cerrada con exito");
			} catch (SQLException e) {
				System.out.println("Error durante cierre de conexion a BBDD");
			}
		}
		return result;
	}
}
