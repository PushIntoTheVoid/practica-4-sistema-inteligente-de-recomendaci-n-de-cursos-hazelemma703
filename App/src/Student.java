import java.util.ArrayList;

public class Student {

    String nombre;
    ArrayList<String> intereses;

    public Student(String nombre) {
        this.nombre = nombre;
        this.intereses = new ArrayList<>();
    }

    public void agregarInteres(String interes) {
        intereses.add(interes.toLowerCase());
    }
}