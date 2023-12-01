/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.barzallom_ramirezj_exameninterciclo;

/**
 *
 * @author casa
 */
public class DecSeguroMedico extends DecoradorEmpleado {

    public DecSeguroMedico(IEmpleado empleado) {
        super(empleado);
    }

    @Override
    public double getSueldo() {
        return super.getSueldo() - 30.00;
    }
}
