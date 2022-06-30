import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu_Admin {


	private Usuario u;
	Scanner t= new Scanner(System.in);
	private String [][] matriz_resultado;
	private Conexion conn;
	public Menu_Admin(Usuario u) throws SQLException {
		this.conn=new Conexion();
		this.u=u;
		
		

		System.out.println("Menu");
		System.out.println("1 Ver todas  las peliculas");
		System.out.println("2 Ver reservas de todos los clientes.");
		System.out.println("3 Ver reservas de un cliente en particular.");
		System.out.println("4 Crear una sala con la película.");
		System.out.println("5 Modificar una sala.");
		System.out.println("6 Eliminar una sala.");
		System.out.println("7 Modificar descuentos.");
		
		System.out.println("ingrese una opcion");
		int op=t.nextInt();
		
		if(op==1) {
			
			String sql="select idPelicula,Nombre,Duracion,atp,plus,genero from Peliculas inner join Genero using(idGenero);";
			ResultSet r=conn.devolverConsulta(sql);
			System.out.println("id|\t Nombre|\t Duracion|\t atp|\t plus|\t genero");
			while(r.next()) {

				String genero=null;
				if(r.getString("atp")=="1") {
					genero="si";
				}else {
					genero="no";
				}
				System.out.println(r.getInt("idPelicula")+"\t"+r.getString("Nombre")+"\t"+
				r.getString("Duracion")+"\t"+genero
				+"\t"+r.getString("plus")+"\t"+r.getString("genero"));
			}
			
			
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
