/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.barzallom_ramirezj_exameninterciclo;

/**
 *
 * @author casa
 */
public abstract class DecoradorEmpleado implements IEmpleado {
    protected IEmpleado empleado;

    public DecoradorEmpleado(IEmpleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String getNombre() {
        return empleado.getNombre();
    }

    @Override
    public double getSueldo() {
        return empleado.getSueldo();
    }

    @Override
    public String getTipo() {
        return empleado.getTipo();
    }
    
}
