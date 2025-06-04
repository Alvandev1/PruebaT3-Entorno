package Codigo;

//Paciente.java (versión inicial)
public class paciente {
 // Variables con nombres ambiguos
 String n;
 String m;
 int p;

 public paciente(String n, String m, int p) {
     this.n = n;
     this.m = m;
     this.p = p;
 }
}
/*
 CODIGO REFACTORIZADO
 package codigo;

//Paciente.java (refactorizado)
public class paciente {
 private String nombre;
 private String motivoConsulta;
 private int prioridad; // 1: alta, 2: media, 3: baja

 public paciente(String nombre, String motivoConsulta, int prioridad) {
     this.nombre = nombre;
     this.motivoConsulta = motivoConsulta;
     this.prioridad = prioridad;
 }

 public String getNombre() {
     return nombre;
 }

 public String getMotivoConsulta() {
     return motivoConsulta;
 }

 public int getPrioridad() {
     return prioridad;
 }
}


 */
