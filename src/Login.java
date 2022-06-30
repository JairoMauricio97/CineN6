import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	private String correo;
	private String pass;
	private Conexion conn;
	
	public Login() {
	
		
	}
	public Login(String correo, String pass) {
		
		this.correo = correo;
		this.pass = pass;
		this.conn=new Conexion();
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public ResultSet verificarIngreso() throws SQLException {
		
		String sql="select * from Usuarios where Correo="+"'"+this.correo+"'"+ " and pass="+"'"+this.pass+"'"+";";
		
		ResultSet rs=conn.devolverConsulta(sql);
		
		return rs;
	}
	
	
}