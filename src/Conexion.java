
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {

	
	public Connection conn;
	public Statement stmt;
	
	public Conexion() {
		 final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
		 final String DB_URL="jdbc:mysql://localhost:3306/CineN6";
		 
		 info f=new info();
		 final String USER= f.getUser();//usuario
		 final String PASS=f.getPass();//pass
		 
		 	conn=null;
			stmt =null;
			try {
				//paso 2
				Class.forName(JDBC_DRIVER);
				
				//paso3 
				System.out.println("conectando");
				conn= DriverManager.getConnection(DB_URL,USER,PASS);
				
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			//System.out.print("LIsto");
		}

		public ResultSet devolverConsulta(String query) throws SQLException {
			//System.out.println("creando declaracion");
			stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql;
			sql=query;
			
			ResultSet rs =stmt.executeQuery(sql);
			 return rs;
		}
		public void EjecutarConsulta(String sql) throws SQLException {
			stmt.executeUpdate(sql);
		}
		
		public void AgregarElementos(String tabla, ArrayList<String> elementos) throws SQLException {
			
			System.out.println("Creando Statement");
			
			String sql;
			sql="insert into "+ tabla + "\r\n"
				+"values \r\n";
			for( int i=0;i<elementos.size()-1;i++) {
				
				sql.concat("("+"'"+elementos.get(i)+"'"+", \r\n");
			}
			sql.concat("'"+elementos.get(elementos.size())+"'"+")\r\n");
			sql.concat(";");
			stmt.executeUpdate(sql);
			System.out.print("valores agregados");
			
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}