/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import modelo.conexion;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDRES
 */
public class Cliente extends persona{
    
    private String nit;
    private int id;
    private conexion cn;
    
    public Cliente(){}
    

    public Cliente(int id,String nit, String nombres, String apellidos, String direccion, String numero_de_telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, numero_de_telefono, fecha_nacimiento);
        this.nit = nit;
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    
    
    public DefaultTableModel leer (){
    DefaultTableModel tabla = new DefaultTableModel ();
    try{
    cn =new conexion();
    cn.abrir_coxion();
    String query;
    query ="SELECT clientes.id_cliente,clientes.nit,clientes.nombres,clientes.apellidos,clientes.direccion,clientes.telefono,clientes.fecha_nacimineto \n" +
"FROM db_empresa.clientes;";
    ResultSet consulta =cn.conexionBD.createStatement().executeQuery(query);
   
    String encabezadoo[] ={"id","nit","nombres","apellidos","direccion","telefono","nacimiento"};
    tabla.setColumnIdentifiers(encabezadoo);
    
    String datos []= new String [7];
    
    while (consulta.next()){
    datos [0]=consulta.getString("clientes.id_cliente");
    datos [1]=consulta.getString("clientes.nit");
    datos [2]=consulta.getString("clientes.nombres");
    datos [3]=consulta.getString("clientes.apellidos");
    datos [4]=consulta.getString("clientes.direccion");
    datos [5]=consulta.getString("clientes.telefono");
    datos [6]=consulta.getString("clientes.fecha_nacimineto");
    tabla.addRow(datos);
    
    }
    cn.cerrar_conexion();
    
    }
    
    catch(Exception ex){
    System.out.println("error :"+ex.getMessage());
    }
    return tabla;
    
    }
    
    
     @Override
    public void agregar (){
        try{
        PreparedStatement parametro;
        String query ="INSERT INTO db_empresa.clientes(nit,nombres,apellidos,direccion,telefono,fecha_nacimineto)VALUES(?,?,?,?,?,?,);";
            cn = new conexion();
            cn.abrir_coxion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, this.getNit());
            parametro.setString(2, this.getNombres());
            parametro.setString(3, this.getApellidos());
            parametro.setString(4, this.getDireccion());
            parametro.setString(5, this.getNumero_de_telefono());
            parametro.setString(6, this.getFecha_nacimiento());
            
            int executar = parametro.executeUpdate();
            cn.cerrar_conexion();
            
            JOptionPane.showMessageDialog(null, Integer.toString(executar) +"registro ingresado","egregar",JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch(Exception ex){
        System.out.println("la cagaste "+ ex.getMessage());}
        
    }
    @Override
    public void actualizar (){
        try{
        PreparedStatement parametro;
        String query ="UPDATE db_empresa.clientes SET nit = ?,nombres = ?,apellidos = ?,direccion = ?,telefono = ?,fecha_nacimineto = ? WHERE id_cliente = ?;";
            cn = new conexion();
            cn.abrir_coxion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, this.getNit());
            parametro.setString(2, this.getNombres());
            parametro.setString(3, this.getApellidos());
            parametro.setString(4, this.getDireccion());
            parametro.setString(5, this.getNumero_de_telefono());
            parametro.setString(6, this.getFecha_nacimiento());
            parametro.setInt(7, getId());
            
            int executar = parametro.executeUpdate();
            cn.cerrar_conexion();
            
            JOptionPane.showMessageDialog(null, Integer.toString(executar) +"registro actulizar","actualizar",JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch(Exception ex){
        System.out.println("la cagaste "+ ex.getMessage());}
    }
        
        
        
      @Override
    public void eliminar (){
        try{
        PreparedStatement parametro;
        String query ="DELETE FROM db_empresa.clientes WHERE id_cliente =?;";
            cn = new conexion();
            cn.abrir_coxion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
           
            parametro.setInt(1, getId());
            
            int executar = parametro.executeUpdate();
            cn.cerrar_conexion();
            
            JOptionPane.showMessageDialog(null, Integer.toString(executar) +"registro eliminar","eliminar",JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch(Exception ex){
        System.out.println("la cagaste "+ ex.getMessage());}
        
  
    }
        
        
        
        
        
        
        
        
        
    
   
    
    
}
