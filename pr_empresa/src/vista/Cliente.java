/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author ANDRES
 */
public class Cliente extends persona{
    
    private String nit;
    
    public Cliente(){}
    

    public Cliente(String nit, String nombres, String apellidos, String direccion, String numero_de_telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, numero_de_telefono, fecha_nacimiento);
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
     @Override
    public void agregar (){
    System.out.println("nit:  "+this.getNit());
    System.out.println("nombres:  "+this.getNombres());
    System.out.println("apellidos:  "+this.getApellidos());
    System.out.println("direccion:  "+this.getDireccion());
    System.out.println("numero de telefono: "+this.getNumero_de_telefono());
    System.out.println("fecah de nacimiento: "+this.getFecha_nacimiento());
    
    }
    
}
