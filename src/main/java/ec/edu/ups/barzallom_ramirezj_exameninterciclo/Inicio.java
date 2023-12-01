/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.ups.barzallom_ramirezj_exameninterciclo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author casa
 */
public class Inicio {

    public static void main(String[] args) {
        List<IEmpleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\ec\\edu\\ups\\barzallom_ramirezj_exameninterciclo\\Empleados.txt")); BufferedWriter bw = new BufferedWriter(new FileWriter("src\\main\\java\\ec\\edu\\ups\\barzallom_ramirezj_exameninterciclo\\Sueldos.txt"))) {
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                String lineaEscribir = "";
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    String nombre = datos[0];
                    lineaEscribir += "Nombre: " + nombre;
                    String tipo = datos[1];
                    lineaEscribir += " Tipo: " + tipo;
                    int minutosT = Integer.parseInt(datos[2]);
                    Integer minutosExtra = datos[3].equals("null") ? null : Integer.parseInt(datos[3]);
                    boolean seguro = datos[4].equals("SI");
                    int bonificaciones = Integer.parseInt(datos[5]);
                    IEmpleado empleado;
                    if (tipo.equals("Tiempo Completo")) {
                        empleado = new EmpleadoTiempoCompleto(nombre, minutosT);
                        lineaEscribir += " Sueldo basico: " + empleado.getSueldo();
                        if (minutosExtra != null && minutosExtra > 0) {
                            empleado = new DecMinutosExtra(empleado, minutosExtra);
                            lineaEscribir += " Sueldo horas extra: " + empleado.getSueldo();
                        } else {
                            lineaEscribir += " Sueldo horas extra: NO";
                        }
                    } else {
                        empleado = new EmpleadoTiempoParcial(nombre, minutosT);
                        if(minutosT/60>10){
                            minutosExtra=minutosT-600;
                        }
                        lineaEscribir += " Sueldo basico: " + empleado.getSueldo();
                        if (minutosExtra != null && minutosExtra > 0) {
                            empleado = new DecMinutosExtra(empleado, minutosExtra);
                            lineaEscribir += " Sueldo horas extra: " + empleado.getSueldo();
                        } else {
                            lineaEscribir += " Sueldo horas extra: NO";
                        }
                    }
                    if (seguro) {
                        empleado = new DecSeguroMedico(empleado);
                        lineaEscribir += " Sueldo seguro: " + empleado.getSueldo();
                    } else {
                        lineaEscribir += " Sueldo seguro: NO";
                    }
                    if (bonificaciones > 0) {
                        empleado = new DecBonificaciones(empleado, bonificaciones);
                        lineaEscribir += " Sueldo bonificaciones: " + empleado.getSueldo();
                    } else {
                        lineaEscribir += " Sueldo bonificaciones: " + empleado.getSueldo();
                    }
                    empleados.add(empleado);
                }
                bw.write(lineaEscribir);
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        for (IEmpleado empleado : empleados) {
            double sueldo = empleado.getSueldo();
            System.out.println("Nombre: " + empleado.getNombre() + " - Tipo: " + empleado.getTipo() + " - Sueldo: " + empleado.getSueldo());
        }
    }
}
