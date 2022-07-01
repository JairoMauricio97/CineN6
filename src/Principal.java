import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	static Scanner t=new Scanner(System.in);
	static Conexion conn;
	public Principal() {
		
		
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		conn = new Conexion();
		System.out.println("----MENU---");
		System.out.println("----1 INICIAR SESION---");
		System.out.println("----2 REGISTRARSE---");
		int op= t.nextInt();
		switch(op) {
		
		case 1:
			IniciarSesion();
			break;
		default:
			RegistrarUsuario();
			break;
		}		
	}
	
	public static void IniciarSesion() throws SQLException {
		
		System.out.println("Ingrese el correo");
		String correo=t.next();
		System.out.println("Ingrese contraseña");
		String pass=t.next();
		Login login=new Login(correo,pass);
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
	public static void RegistrarUsuario() throws SQLException {
		System.out.println("Registrarse");
		
		System.out.println("Ingrese su nombre");
		String n=t.next();
		System.out.println("Ingrese su Apellido");
		String ap=t.next();
		System.out.println("Ingrese su Correo");
		String c=t.next();
		System.out.println("Ingrese su Dni");
		String d=t.next();
		System.out.println("Ingrese su Contraseña");
		String pass=t.next();
		System.out.println("Ingrese nuevamente su Contraseña");
		String pass2=t.next();

		if(n.isEmpty()==false && pass.equals(pass2)) {
		
			ArrayList<String> listValores=new ArrayList<>();
			listValores.add(n);
			listValores.add(ap);
			listValores.add(c);
			listValores.add(d);
			listValores.add(pass);
			listValores.add("2");
			listValores.add("0");
			conn.AgregarUsuario(listValores);
		}

	}
}
