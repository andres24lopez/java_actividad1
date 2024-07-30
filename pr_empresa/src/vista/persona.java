/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author ANDRES
 */
abstract class persona {
    private String nombres,apellidos,direccion,numero_de_telefono,fecha_nacimiento;
    
    public persona() {}
    
    public persona(String nombres, String apellidos, String direccion, String numero_de_telefono, String fecha_nacimiento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.numero_de_telefono = numero_de_telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero_de_telefono() {
        return numero_de_telefono;
    }

    public void setNumero_de_telefono(String numero_de_telefono) {
        this.numero_de_telefono = numero_de_telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    
    protected void agregar (){}
    
    
}
