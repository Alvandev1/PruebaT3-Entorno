package Test;
import Refactorizado.GestorTurnos;
import Refactorizado.paciente;
//GestorTurnosTest.java (refactorizado)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestorTurnosTest {
 GestorTurnos gestorTurnos;

 @BeforeEach
 public void setUp() {
     gestorTurnos = new GestorTurnos();
 }

 @Test
 public void testAgregarPaciente() {
     gestorTurnos.agregarPaciente("Juan", "Consulta general", 2);
     assertEquals("Juan", gestorTurnos.obtenerSiguientePaciente(), "El primer paciente debe ser Juan");
 }

 @Test
 public void testObtenerSiguientePaciente() {
     gestorTurnos.agregarPaciente("Ana", "Urgencia", 1);
     gestorTurnos.agregarPaciente("Pedro", "Consulta", 3);
     assertEquals("Ana", gestorTurnos.obtenerSiguientePaciente(), "El paciente de mayor prioridad debe ser Ana");
 }

 @Test
 public void testAtenderPaciente() {
     gestorTurnos.agregarPaciente("Ana", "Urgencia", 1);
     gestorTurnos.agregarPaciente("Pedro", "Consulta", 3);
     paciente p = gestorTurnos.atenderPaciente();
     assertNotNull(p, "Debe retornarse un paciente");
     assertEquals("Ana", p.getNombre(), "Debe atender a Ana primero por su prioridad alta");
 }

 @Test
 public void testCancelarTurno() {
     gestorTurnos.agregarPaciente("Luis", "Chequeo", 2);
     gestorTurnos.agregarPaciente("Carlos", "Revisión", 1);
     gestorTurnos.cancelarTurno("Carlos");
     assertEquals("Luis", gestorTurnos.obtenerSiguientePaciente(), "Después de cancelar la cita de Carlos, el siguiente debe ser Luis");
 }

 @Test
 public void testObtenerCantidadPorPrioridad() {
     gestorTurnos.agregarPaciente("Ana", "Urgencia", 1);
     gestorTurnos.agregarPaciente("Pedro", "Consulta", 3);
     gestorTurnos.agregarPaciente("Luis", "Chequeo", 2);
     gestorTurnos.agregarPaciente("Marta", "Chequeo", 1);
     assertEquals(2, gestorTurnos.obtenerCantidadPorPrioridad(1), "Deben haber 2 pacientes en prioridad alta (1)");
     assertEquals(1, gestorTurnos.obtenerCantidadPorPrioridad(2), "Debe haber 1 paciente en prioridad media (2)");
     assertEquals(1, gestorTurnos.obtenerCantidadPorPrioridad(3), "Debe haber 1 paciente en prioridad baja (3)");
 }
}
