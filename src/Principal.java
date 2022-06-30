import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	public Principal() {
		
		
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Login login=new Login("celin@gmail.com","1234");
		ResultSet r=login.verificarIngreso();
		if(r.next()) {
			System.out.println("puedo ingresar");
			if(r.getInt("idRol")==1) {
				System.out.println("Bienvenido: \t"+r.getString("Nombre").concat("\t").concat(r.getString("Apellido")));
						
				Usuario u=new Usuario(r.getInt("idUsuario"),r.getString("Nombre"),r.getString("Apellido"),
						r.getString("Correo"),r.getString("Dni"),r.getString("pass"),r.getInt("idRol"),
						r.getInt("EsFrecuente"));
				
				Menu_Admin menuA= new Menu_Admin(u);
				
			}else {
				System.out.println("Sos usuario comun");
			}
			
			
		}else {
			System.out.print("Usuario y/o contraseña incorrecto");
		}
	
		
	}
	
}
