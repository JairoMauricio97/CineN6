public class Usuario {




	private int idUsuario;
	private String nombre;
	private String apellido;
	private String correo;
	private String dni;
	private String pass;
	private int idRol;
	private int esFrecuente;
	
	public Usuario() {
		
	}
	
	public Usuario(int idUsurio, String nombre, String apellido, String correo, String dni, String pass, int idRol,
			int esFrecuente) {
		super();
		this.idUsuario = idUsurio;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.dni = dni;
		this.pass = pass;
		this.idRol = idRol;
		this.esFrecuente = esFrecuente;
	}
	public int getIdUsurio() {
		return idUsuario;
	}
	public void setIdUsurio(int idUsurio) {
		this.idUsuario = idUsurio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public int getEsFrecuente() {
		return esFrecuente;
	}
	public void setEsFrecuente(int esFrecuente) {
		this.esFrecuente = esFrecuente;
	}

	
	
		
}
