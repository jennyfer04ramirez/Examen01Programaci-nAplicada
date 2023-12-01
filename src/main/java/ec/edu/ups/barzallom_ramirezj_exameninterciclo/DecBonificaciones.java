/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.barzallom_ramirezj_exameninterciclo;

/**
 *
 * @author casa
 */
public class DecBonificaciones extends DecoradorEmpleado {

    private int bonificaciones;

    public DecBonificaciones(IEmpleado empleado, int bonificaciones) {
        super(empleado);
        this.bonificaciones = bonificaciones;
    }

    @Override
    public double getSueldo() {
        double sueldo = super.getSueldo();
        double bono = sueldo;
        if (empleado.getTipo().equals("Tiempo Completo")) {
            int bonoPorBonificacion = (int) bono / 3;
            bono += bonoPorBonificacion;
            int bonoRes = bonificaciones % 3;
            if (bonoRes > 0) {
                bono += bonoRes * 0.40;
            }
        }else {
            int bonoPorBonificacion = bonificaciones / 2;
            bono += bonoPorBonificacion;
        } 
        return bono;
    }

}
