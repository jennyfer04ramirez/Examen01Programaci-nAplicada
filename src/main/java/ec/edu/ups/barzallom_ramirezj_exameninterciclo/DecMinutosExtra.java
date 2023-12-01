/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.barzallom_ramirezj_exameninterciclo;

/**
 *
 * @author casa
 */
public class DecMinutosExtra extends DecoradorEmpleado {
    private int minutosExtra;
    
    public DecMinutosExtra(IEmpleado empleado, int minutosExtra) {
        super(empleado);
        this.minutosExtra = minutosExtra;
    }
    
    @Override
    public double getSueldo() {
        double sueldo = super.getSueldo();
        double pagoExtra = 0;
        if (empleado.getTipo().equals("Tiempo Completo")) {
            pagoExtra = (minutosExtra/60) * 0.75;
        } else {
            pagoExtra = (minutosExtra/60) * 0.50;
        }
        return sueldo + pagoExtra;
    }
}
