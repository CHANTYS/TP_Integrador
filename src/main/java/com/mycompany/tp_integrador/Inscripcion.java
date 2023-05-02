/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_integrador;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author amdsa
 */
public class Inscripcion {
    Materia inscripcionMateria;
    Alumno alumno;
    Date fecha;
    

    public Inscripcion(Materia inscripcionMateria, Alumno alumno) {
        this.inscripcionMateria = inscripcionMateria;
        this.alumno = alumno;
    }
            
    public boolean aprobada (){
        if(true==inscripcionMateria.puedeCursar(alumno)){
            fecha=new Date();
            System.out.println("Se inscribio correctamente a la materia:"+inscripcionMateria.nombre+" el dia "+fecha);
            return true;
        }else{
            System.out.println("No se inscribio correctamente a la materia el dia "+fecha);
            return false;
        }
    }

    public void setInscripcionMateria(Materia inscripcionMateria) {
        this.inscripcionMateria = inscripcionMateria;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Materia getInscripcionMateria() {
        return inscripcionMateria;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Date getFecha() {
        return fecha;
    }

}