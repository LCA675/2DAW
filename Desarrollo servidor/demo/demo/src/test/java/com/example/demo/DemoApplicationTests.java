package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testMostrarPlanConNombrePorDefecto() {
        PlanEstudioController controller = new PlanEstudioController();
        Model model = new ConcurrentModel();

        String view = controller.mostrarPlan("estudiante", model);

        assertEquals("plan", view);
        assertEquals("estudiante", model.getAttribute("nombre"));

        @SuppressWarnings("unchecked")
        List<String> asignaturas = (List<String>) model.getAttribute("asignaturas");
        assertNotNull(asignaturas);
        assertEquals(3, asignaturas.size());

        @SuppressWarnings("unchecked")
        List<Integer> duraciones = (List<Integer>) model.getAttribute("duraciones");
        assertNotNull(duraciones);
        assertEquals(3, duraciones.size());
    }

    @Test
    void testMostrarPlanConNombrePersonalizado() {
        PlanEstudioController controller = new PlanEstudioController();
        Model model = new ConcurrentModel();

        String view = controller.mostrarPlan("Lucía", model);

        assertEquals("plan", view);
        assertEquals("Lucía", model.getAttribute("nombre"));
    }
}
