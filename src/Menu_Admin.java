import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu_Admin {

	private Usuario u;
	Scanner t = new Scanner(System.in);
	private String[][] matriz_resultado;
	private Conexion conn;

	public Menu_Admin(Usuario u) throws SQLException {
		this.conn = new Conexion();
		this.u = u;

		System.out.println("Menu");
		System.out.println("1 Ver todas  las peliculas");
		System.out.println("2 Ver reservas de todos los clientes.");
		System.out.println("3 Ver reservas de un cliente en particular.");
		System.out.println("4 Crear una sala con la película.");
		System.out.println("5 Modificar una sala.");
		System.out.println("6 Eliminar una sala.");
		System.out.println("7 Modificar descuentos.");

		System.out.println("ingrese una opcion");
		int op = t.nextInt();

		switch (op) {
		case 1:
			verPeliculas();
			break;
		case 4:
			crearCartelera();
			break;

		case 5:
			modificarSala();

			break;
		case 6:

		}

	}

	public void eliminarSala() throws SQLException {

		int id = 0;
		int confirm = 0;
		String sql = "select idCartelera,Nombre,Hora,idSala,PrecioTotal from Carteleras inner\n"
				+ "join Peliculas using(idPelicula);";

		ResultSet r = conn.devolverConsulta(sql);
		System.out.println("id|\t Nombre Pelicula|\t Hora|\t sala|\t Precio");

		while (r.next()) {

			System.out.println(r.getInt("idCartelera") + "\t");
			System.out.println(r.getString("Nombre") + "\t");
			System.out.println(r.getString("Hora") + "\t");
			System.out.println(r.getInt("idSala") + "\t");
			System.out.println(r.getString("PrecioTotal") + "\t");
		}

		System.out.println("Seleccione el id de la Cartlera a eliminarr");
		id = t.nextInt();

		System.out.println("Esta seguro de eliminar 1-SI 0-NO");
		confirm = t.nextInt();

		if (confirm == 1) {
			sql = "delete from Carteleras where idCartelera=" + id + ";";
			conn.EjecutarConsulta(sql);
			System.out.print("Cartelera eliminada con exito");
		}
	}

	public void modificarSala() throws SQLException {

		int id = 0;
		int idP = 0;
		String sql = "select idCartelera,Nombre,Hora,idSala from Carteleras inner\n"
				+ "join Peliculas using(idPelicula);";

		ResultSet r = conn.devolverConsulta(sql);
		System.out.println("id|\t Nombre Pelicula|\t Hora|\t sala");

		while (r.next()) {

			System.out.println(r.getInt("idCartelera") + "\t");
			System.out.println(r.getString("Nombre") + "\t");
			System.out.println(r.getString("Hora") + "\t");
			System.out.println(r.getInt("idSala") + "\t");
		}

		System.out.println("Seleccione el id de la Cartlera a modificar");
		id = t.nextInt();

		System.out.print("Seleccione la pelicula nueva");

		r = conn.devolverConsulta("select * from Peliculas;");
		System.out.println("id|\t Nombre|\t Duracion");

		while (r.next()) {

			System.out.print(r.getInt("idPelicula") + "\n");
			System.out.print(r.getString("Nombre") + "\n");
			System.out.print(r.getString("Duracion") + "\n");

		}
		System.out.println("Ingrese el id de la nueva Pelicula");
		idP = t.nextInt();

		sql = "UPDATE `CineN6`.`Carteleras` SET `idPelicula` = " + idP + " WHERE (`idCartelera` = " + id + ");";
		conn.EjecutarConsulta(sql);

		System.out.print("Cartelera actualizada");

	}

	public void crearCartelera() throws SQLException {

		int idSala = 0;
		int idP = 0;
		String Horario = null;
		System.out.println("Esta por crear una cartelera");

		System.out.println("Seleccione la sala");

		ResultSet r = conn.devolverConsulta(
				"select idSala,nombre,capacidad,tipo from Salas inner join tipoSala using(idTipoSala);");

		System.out.println("idSala|\t Nombre|\t Capacidad|\t Tipo\t");

		while (r.next()) {
			System.out.print(r.getInt("idSala") + "\t");
			System.out.print(r.getString("nombre") + "\t");
			System.out.print(r.getString("capacidad") + "\t");
			System.out.print(r.getString("tipo") + "\t");
			System.out.print(r.getString("\n"));
		}
		System.out.println("Ingrese el id de la sala");
		idSala = t.nextInt();

		System.out.println("Seleccione la pelicula");
		r = conn.devolverConsulta("select idPelicula,Nombre,Duracion from Peliculas;");
		System.out.println("idPelicula|\t Nombre|\t Duracion");

		while (r.next()) {

			System.out.print(r.getInt("idPelicula") + "\t");
			System.out.print(r.getString("Nombre") + "\t");
			System.out.print(r.getString("Duracion") + "\t");

		}
		System.out.println("selecciona el id de la pelicula");
		idP = t.nextInt();

		System.out.println("Ingrese el horario");
		Horario = t.next();

		System.out.println("Ingrese el precio");
		double precio = t.nextDouble();

		String sql = "insert into Carteleras values (null," + Horario + "," + idP + "," + idSala + "," + "'" + precio
				+ "'" + ");";
		conn.EjecutarConsulta(sql);

		System.out.println("Cartelera creada con exito");

	}

	public void verPeliculas() throws SQLException {
		String sql = "select idPelicula,Nombre,Duracion,atp,plus,genero from Peliculas inner join Genero using(idGenero);";
		ResultSet r = conn.devolverConsulta(sql);
		System.out.println("id|\t Nombre|\t Duracion|\t atp|\t plus|\t genero");
		while (r.next()) {

			String genero = null;
			if (r.getString("atp") == "1") {
				genero = "si";
			} else {
				genero = "no";
			}
			System.out.println(r.getInt("idPelicula") + "\t" + r.getString("Nombre") + "\t" + r.getString("Duracion")
					+ "\t" + genero + "\t" + r.getString("plus") + "\t" + r.getString("genero"));
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
