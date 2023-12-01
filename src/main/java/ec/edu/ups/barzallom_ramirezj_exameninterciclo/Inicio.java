/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.ups.barzallom_ramirezj_exameninterciclo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author casa
 */
public class Inicio {

    public static void main(String[] args) {
        List<IEmpleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\ec\\edu\\ups\\barzallom_ramirezj_exameninterciclo\\Empleados.txt"))) {
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    String nombre = datos[0];
                    String tipo = datos[1];
                    int minutosT = Integer.parseInt(datos[2]);
                    Integer minutosExtra = datos[3].equals("null") ? null : Integer.parseInt(datos[3]);
                    boolean seguro = datos[4].equals("SI");
                    int bonificaciones = Integer.parseInt(datos[5]);
                    IEmpleado empleado;
                    if (tipo.equals("Tiempo Completo")) {
                        empleado = new EmpleadoTiempoCompleto(nombre, minutosT);
                        if (minutosExtra != null && minutosExtra > 0) {
                            empleado = new DecMinutosExtra(empleado, minutosExtra);
                        }
                    } else {
                        empleado = new EmpleadoTiempoParcial(nombre, minutosT);
                        if (minutosExtra != null && minutosExtra > 0) {
                            empleado = new DecMinutosExtra(empleado, minutosExtra);
                        }
                    }
                    if (seguro) {
                        empleado = new DecSeguroMedico(empleado);
                    }
                    if (bonificaciones > 0) {
                        empleado = new DecBonificaciones(empleado, bonificaciones);
                    }
                    empleados.add(empleado);
                }

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
