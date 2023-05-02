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
public class Alumno {
    String nombre;
    String legajo;
    ArrayList<Materia> aprobadas=new ArrayList<Materia>();

    public Alumno(String nombre, String legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLegajo() {
        return legajo;
    }
    
    public void addMateriaAprobada(Materia agregar){
       /*Materia nueva=new Materia();
       System.out.println("Ingrese el nombre de la manteria aprobada "+this.aprobadas.size());
       Scanner entrada=new Scanner(System.in);
       
       nueva.setNombre(entrada.nextLine());*/
       this.aprobadas.add(agregar);
   }
    //MOSTRADORES
    public void mostrarAprobadas(){
    System.out.println("Las Materias aprobadas del alumno: "+ this.nombre+" legajo: "+this.legajo+" son: ");
    for(Materia aux:this.aprobadas){
        System.out.println(aux.getNombre());
    }
    }

    public void setAprobadas(ArrayList<Materia> aprobadas) {
        this.aprobadas = aprobadas;
    }

    public ArrayList<Materia> getAprobadas() {
        return aprobadas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
    
    
}
