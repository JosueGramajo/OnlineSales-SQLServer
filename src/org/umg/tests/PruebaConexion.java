package org.umg.tests;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.umg.db.Conexion;

public class PruebaConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select * from categoria order by nombre ASC");
		
		try {
			while(rSet.next()) {
				System.out.println(rSet.getString("nombre"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
