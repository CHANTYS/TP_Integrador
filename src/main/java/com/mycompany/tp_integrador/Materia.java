/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_integrador;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author amdsa
 */
public class Materia {
    String nombre;
    ArrayList<Materia> correlativas =new ArrayList<Materia>();
   
   public boolean puedeCursar(Alumno alumno){
       boolean resultado= true;
       
       for(Materia aux:this.correlativas){
           if(resultado==true){
               resultado=alumno.aprobadas.contains(aux);
           }
           
       }
       return resultado;
    }
   public void addCorrelativa(Materia agregar){
       //Materia nueva=new Materia();
       //System.out.println("Ingrese el nombre de la manteria correlativa "+this.correlativas.size());
       //Scanner entrada=new Scanner(System.in);
       
       //nueva.setNombre(entrada.nextLine());
       this.correlativas.add(agregar);
   }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //MOSTRADORES
    public void mostrarCorrelativas(){
    System.out.println("Las Materias correlativas de "+ this.nombre+" son: ");
    for(Materia aux:this.correlativas){
        System.out.println(aux.getNombre());
    }
    }

    public String getNombre() {
        
        return nombre;
    }

    public ArrayList<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(ArrayList<Materia> correlativas) {
        this.correlativas = correlativas;
    }
    
}