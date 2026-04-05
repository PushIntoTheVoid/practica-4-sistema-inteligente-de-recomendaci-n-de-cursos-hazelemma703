import java.util.*;

public class SistemaRecomendacion {

    ArrayList<Course> Courses;
    HashMap<String, ArrayList<Course>> historial;

    public SistemaRecomendacion() {
        Courses = new ArrayList<>();
        historial = new HashMap<>();
    }

    public void agregarCourse(Course Course) {
        Courses.add(Course);
    }

    public List<Course> recomendar(Student estudiante) {

        HashMap<Course, Integer> puntuacion = new HashMap<>();

        for (Course Course : Courses) {

            int score = 0;

            for (String interes : estudiante.intereses) {
                if (Course.temas.contains(interes)) {
                    score++;
                }
            }

            puntuacion.put(Course, score);
        }

        // Ordenar Courses por puntuación
        List<Map.Entry<Course, Integer>> lista = new ArrayList<>(puntuacion.entrySet());

        lista.sort((a, b) -> b.getValue() - a.getValue());

        List<Course> recomendados = new ArrayList<>();

        for (Map.Entry<Course, Integer> entry : lista) {
            if (entry.getValue() > 0) {
                recomendados.add(entry.getKey());
            }
        }

        // Guardar historial
        historial.put(estudiante.nombre, new ArrayList<>(recomendados));

        return recomendados;
    }
}