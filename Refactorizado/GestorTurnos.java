package Refactorizado;

//GestorTurnos.java (refactorizado)
import java.util.ArrayList;
import java.util.List;

public class GestorTurnos {
 private List<paciente> pacientes;

 public GestorTurnos() {
     this.pacientes = new ArrayList<>();
 }

 // Agrega un paciente a la lista de espera
 public void agregarPaciente(String nombre, String motivoConsulta, int prioridad) {
     paciente paciente = new paciente(nombre, motivoConsulta, prioridad);
     pacientes.add(paciente);
 }

 // Atiende y remueve el siguiente paciente según la prioridad: 1 (alta), 2 (media), 3 (baja)
 public paciente atenderPaciente() {
     paciente siguiente = buscarSiguientePaciente();
     if (siguiente != null) {
         pacientes.remove(siguiente);
     }
     return siguiente;
 }

 // Retorna la cantidad de pacientes en la lista para una prioridad dada
 public int obtenerCantidadPorPrioridad(int prioridad) {
     int count = 0;
     for (paciente paciente : pacientes) {
         if (paciente.getPrioridad() == prioridad) {
             count++;
         }
     }
     return count;
 }

 // Devuelve el nombre del siguiente paciente a ser atendido
 public String obtenerSiguientePaciente() {
     paciente siguiente = buscarSiguientePaciente();
     return (siguiente != null) ? siguiente.getNombre() : "No hay pacientes";
 }

 // Cancela el turno de un paciente, identificado por nombre
 public void cancelarTurno(String nombre) {
     paciente pacienteCancelado = buscarPacientePorNombre(nombre);
     if (pacienteCancelado != null) {
         pacientes.remove(pacienteCancelado);
     }
 }

 // Métodos auxiliares

 // Busca el siguiente paciente según la prioridad (recorriendo de 1 a 3)
 private paciente buscarSiguientePaciente() {
     for (int prioridad = 1; prioridad <= 3; prioridad++) {
         for (paciente paciente : pacientes) {
             if (paciente.getPrioridad() == prioridad) {
                 return paciente;
             }
         }
     }
     return null;
 }

 // Busca un paciente por su nombre (no distingue entre mayúsculas y minúsculas)
 private paciente buscarPacientePorNombre(String nombre) {
     for (paciente paciente : pacientes) {
         if (paciente.getNombre().equalsIgnoreCase(nombre)) {
             return paciente;
         }
     }
     return null;
 }
}
