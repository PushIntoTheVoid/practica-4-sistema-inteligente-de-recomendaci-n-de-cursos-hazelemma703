import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class SistemaRecomendacionTest {

    @Test
    public void testRecomendacionBasica() {
        SistemaRecomendacion sistema = new SistemaRecomendacion();
        
        Course c1 = new Course("Java");
        c1.agregarTema("programacion");
        sistema.agregarCourse(c1);

        Student est = new Student("Test");
        est.agregarInteres("programacion");

        List<Course> recomendados = sistema.recomendar(est);
        
        assertFalse(recomendados.isEmpty(), "Debería haber al menos una recomendación");
        assertEquals("Java", recomendados.get(0).nombre);
    }

    @Test
    public void testSinCoincidencias() {
        SistemaRecomendacion sistema = new SistemaRecomendacion();
        Course c1 = new Course("Cocina");
        c1.agregarTema("recetas");
        sistema.agregarCourse(c1);

        Student est = new Student("Programador");
        est.agregarInteres("java");

        List<Course> recomendados = sistema.recomendar(est);
        assertTrue(recomendados.isEmpty(), "No debería haber recomendaciones si no hay coincidencia");
    }
}