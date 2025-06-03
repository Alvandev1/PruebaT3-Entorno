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

