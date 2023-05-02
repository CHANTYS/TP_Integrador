/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_integrador;

import java.sql.*;

import java.util.Scanner;

/**
 *
 * @author amdsa
 */
public class ConexionBD {
    Connection ConexionBd;
    Statement ConsultaBD;
    ResultSet ResultadoBD; 
    String DriverBD;
    String UsuarioBD;
    String ContraseñaBD;
    String DireccionBD;
    String PuertoBD;
    String NombreBD;
    String ProtocoloBD;
    String APIBD;
    
    
    
    
    public ConexionBD(){
        System.out.println("Ingrese el nombre del driver a utilizar");
        
        Scanner entrada=new Scanner(System.in); 
        
            this.DriverBD=entrada.nextLine();
            
            System.out.println("Ingrese la direccion de la BD");
            
            this.DireccionBD=entrada.nextLine();
            
            System.out.println("Ingrese el puerto de la BD");
            
            this.PuertoBD=entrada.nextLine();
            
             System.out.println("Ingrese el nombre de la BD");
            
            this.NombreBD=entrada.nextLine();
            
            System.out.println("Ingrese el nombre de usuario de la BD");
            
            this.UsuarioBD=entrada.nextLine();
            
            System.out.println("Ingrese la contrasena de la BD");
            
            this.ContraseñaBD=entrada.nextLine();
            
            System.out.println("Ingrese la API");
            
            this.APIBD=entrada.nextLine();
             System.out.println("Ingrese el protocolo de la BD");
            
            this.ProtocoloBD=entrada.nextLine();
        
        
    }
    
    public void Conectar(){
        
        try{
         Class.forName(DriverBD);
                 
         this.ConexionBd=DriverManager.getConnection(/*APIBD+":" +ProtocoloBD +"://" +DireccionBD+":"+PuertoBD+"/"+NombreBD,UsuarioBD,ContraseñaBD*/"jdbc:mysql://localhost:3306/bdintegrador","root","1234");
         ConsultaBD=this.ConexionBd.createStatement();
         System.out.println("CONEXION ESTABLECIDA CON LA BD ");
        }catch(Exception e){
            System.out.println("NO SE PUDO CONECTAR A LA BD POR EXCEPCION "+e);
        }
    }
    
        
    public void CerrarConexion(){
        try{
        this.ConexionBd.close();
        }catch(Exception e){ System.out.println("No sepudo cerrar la conexion correctamente");}
    }    
        
  public ResultSet Consultar(String Consulta){
      try{
        ResultadoBD=ConsultaBD.executeQuery(Consulta);
        return ResultadoBD;
      }catch(Exception e){}
      return ResultadoBD;
    }  
  
  public int ModificarBD(String Consulta){
      int completado = 0;
      try{
        completado=ConsultaBD.executeUpdate(Consulta);
        return completado;
      }catch(Exception e){}
      return completado;
    }  
  
  //getters y setters

    public Connection getConexionBd() {
        return ConexionBd;
    }

    public Statement getConsultaBD() {
        return ConsultaBD;
    }

    public ResultSet getResultadoBD() {
        return ResultadoBD;
    }

    public String getDriverBD() {
        return DriverBD;
    }

    public String getUsuarioBD() {
        return UsuarioBD;
    }

    public String getContraseñaBD() {
        return ContraseñaBD;
    }

    public String getDireccionBD() {
        return DireccionBD;
    }

    public String getPuertoBD() {
        return PuertoBD;
    }

    public String getNombreBD() {
        return NombreBD;
    }

    public String getProtocoloBD() {
        return ProtocoloBD;
    }

    public String getAPIBD() {
        return APIBD;
    }

    public void setConexionBd(Connection ConexionBd) {
        this.ConexionBd = ConexionBd;
    }

    public void setConsultaBD(Statement ConsultaBD) {
        this.ConsultaBD = ConsultaBD;
    }

    public void setResultadoBD(ResultSet ResultadoBD) {
        this.ResultadoBD = ResultadoBD;
    }

    public void setDriverBD(String DriverBD) {
        this.DriverBD = DriverBD;
    }

    public void setUsuarioBD(String UsuarioBD) {
        this.UsuarioBD = UsuarioBD;
    }

    public void setContraseñaBD(String ContraseñaBD) {
        this.ContraseñaBD = ContraseñaBD;
    }

    public void setDireccionBD(String DireccionBD) {
        this.DireccionBD = DireccionBD;
    }

    public void setPuertoBD(String PuertoBD) {
        this.PuertoBD = PuertoBD;
    }

    public void setNombreBD(String NombreBD) {
        this.NombreBD = NombreBD;
    }

    public void setProtocoloBD(String ProtocoloBD) {
        this.ProtocoloBD = ProtocoloBD;
    }

    public void setAPIBD(String APIBD) {
        this.APIBD = APIBD;
    }

    

    
  
  
}
