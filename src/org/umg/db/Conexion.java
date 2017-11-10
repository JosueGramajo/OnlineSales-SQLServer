package org.umg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class Conexion {
	private Connection conexion;
	private Statement stm;
	public static final Conexion INSTANCIA=new Conexion();
	
	public Conexion(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conexion=DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=OnlineSales;integratedSecurity=false","sa","123456");
			stm=conexion.createStatement();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ejecutarConsulta(String consulta){
		try {
			stm.execute(consulta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void ejecutarConsultaCascada(String consulta) throws Exception{
		stm.execute(consulta);
	}
	
	public ResultSet obtenerConsulta(String consulta){
		ResultSet rs=null;
		try {
			rs=stm.executeQuery(consulta);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return rs;
	}
}
