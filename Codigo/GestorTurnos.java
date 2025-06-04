package Codigo;

//GestorTurnos.java (versión inicial)
import java.util.ArrayList;
import java.util.List;

public class GestorTurnos {
 // Lista de pacientes sin encapsulación completa
 List<paciente> lista;

 public GestorTurnos() {
     lista = new ArrayList<>();
 }

 // Método para agregar pacientes (nombres y variables ambiguos)
 public void agrePaci(String n, String m, int p) {
     paciente pa = new paciente(n, m, p);
     lista.add(pa);
 }

 // Atender al siguiente paciente (recorre prioridades del 1 al 3)
 public paciente atiende() {
     if (lista.isEmpty()) {
         return null;
     }
     paciente aux = null;
     for (int pr = 1; pr <= 3; pr++) {
         for (paciente pa : lista) {
             if (pa.p == pr) {
                 aux = pa;
                 break;
             }
         }
         if (aux != null) {
             break;
         }
     }
     if (aux != null) {
         lista.remove(aux);
     }
     return aux;
 }

 // Retorna la cantidad de pacientes según la prioridad indicada
 public int cuantos(int pr) {
     int cont = 0;
     for (paciente pa : lista) {
         if (pa.p == pr) {
             cont++;
         }
     }
     return cont;
 }

 // Muestra el nombre del siguiente paciente (según prioridad)
 public String siguient() {
     if (lista.isEmpty()) {
         return "No hay pacientes";
     }
     paciente aux = null;
     for (int pr = 1; pr <= 3; pr++) {
         for (paciente pa : lista) {
             if (pa.p == pr) {
                 aux = pa;
                 break;
             }
         }
         if (aux != null) {
             break;
         }
     }
     return aux != null ? aux.n : "No hay pacientes";
 }

 // Cancela un turno eliminando el primer paciente que coincida por nombre
 public void cancela(String n) {
     paciente aux = null;
     for (paciente pa : lista) {
         if (pa.n.equals(n)) {
             aux = pa;
             break;
         }
     }
     if (aux != null) {
         lista.remove(aux);
     }
 }
}
/*
 CODIGO REFACTORIZADO
 package codigo;

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

 */

