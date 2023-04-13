import java.util.HashSet;
import java.util.Set;

public class Equipo {

    private  String nombre, descripcion;

    public Equipo(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion=descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion(){
        return descripcion;
    }

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

    
	
	
}
