/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.barzallom_ramirezj_exameninterciclo;

/**
 *
 * @author casa
 */
public class EmpleadoTiempoParcial implements IEmpleado {
    private String nombre;
    private int minutosT;

    public EmpleadoTiempoParcial(String nombre, int minutosT) {
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
        return Math.min(horas * 1.00, 10.00);
    }

    @Override
    public String getTipo() {
        return "Tiempo Parcial";
    }

    
}
