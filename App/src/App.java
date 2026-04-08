import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        SistemaRecomendacion sistema = new SistemaRecomendacion();

        // Crear Courses
        Course c1 = new Course("Programacion en Java");
        c1.agregarTema("programacion");

        Course c2 = new Course("Introduccion a IA");
        c2.agregarTema("ia");

        Course c3 = new Course("Bases de Datos");
        c3.agregarTema("datos");

        sistema.agregarCourse(c1);
        sistema.agregarCourse(c2);
        sistema.agregarCourse(c3);

        // Crear Student
        Student est = new Student("Kevin");
        est.agregarInteres("programacion");
        est.agregarInteres("ia");

        // Recomendación
        List<Course> recomendados = sistema.recomendar(est);

        System.out.println("Courses recomendados:");

        for (Course c : recomendados) {
            System.out.println("- " + c.nombre);
        }
    }
}
