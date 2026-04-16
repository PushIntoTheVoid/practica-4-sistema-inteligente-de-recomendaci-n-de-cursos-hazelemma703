import java.util.ArrayList;

public class Course {

    String nombre;
    ArrayList<String> temas;

    public Course(String nombre) {
        this.nombre = nombre;
        this.temas = new ArrayList<>();
    }

    public void agregarTema(String tema) {
        temas.add(tema.toLowerCase());
    }
}