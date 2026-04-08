import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class SistemaRecomendacionRankingTest {

    @Test
    public void testOrdenDeRecomendacion() {
        SistemaRecomendacion sistema = new SistemaRecomendacion();
        
        // Curso con 2 coincidencias (Programacion e IA)
        Course cFull = new Course("Desarrollo Completo");
        cFull.agregarTema("programacion");
        cFull.agregarTema("ia");
        
        // Curso con 1 coincidencia (IA)
        Course cPartial = new Course("Solo IA");
        cPartial.agregarTema("ia");
        
        sistema.agregarCourse(cFull);
        sistema.agregarCourse(cPartial);

        Student est = new Student("Kevin");
        est.agregarInteres("programacion");
        est.agregarInteres("ia");

        List<Course> recomendados = sistema.recomendar(est);
        
        // El primer curso en la lista debe ser el que tiene mas coincidencias
        assertEquals("Desarrollo Completo", recomendados.get(0).nombre, 
            "El curso con mas coincidencias debe aparecer primero");
        assertEquals(2, recomendados.size(), "Debe recomendar ambos cursos");
    }

    @Test
    public void testPersistenciaEnHistorial() {
        SistemaRecomendacion sistema = new SistemaRecomendacion();
        Course c1 = new Course("Java");
        c1.agregarTema("coding");
        sistema.agregarCourse(c1);

        Student est = new Student("Luna");
        est.agregarInteres("coding");

        sistema.recomendar(est);

        // Validar que el historial guardo la recomendacion para el estudiante
        assertTrue(sistema.historial.containsKey("Luna"), 
            "El historial debe contener el nombre del estudiante");
        assertEquals(1, sistema.historial.get("Luna").size(), 
            "El historial debe tener guardada la lista de cursos recomendados");
    }
}