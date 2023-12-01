/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.barzallom_ramirezj_exameninterciclo;

/**
 *
 * @author casa
 */
public class EmpleadoTiempoCompleto implements IEmpleado {

    private String nombre;
    private int minutosT;

    public EmpleadoTiempoCompleto(String nombre, int minutosT) {
        this.nombre = nombre;
        this.minutosT = minutosT;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getSueldo() {
        int horas = minutosT / 60;
        return horas * 1.50;
    }

    @Override
    public String getTipo() {
        return "Tiempo Completo";
    }
    
}
