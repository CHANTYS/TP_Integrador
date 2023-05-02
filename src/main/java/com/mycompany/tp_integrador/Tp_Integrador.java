/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tp_integrador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author amdsa
 */
public class Tp_Integrador {

    public static void main(String[] args) throws JsonProcessingException, SQLException, IOException {
        // PARA INICIAR EL PROGRAMA SE NECESITA DISPONER DE UNA BD VACIA--------
        //Instanciamos 2 arrayslists para trabajar
        ArrayList<Materia> MateriasCreadas =new ArrayList<Materia>();
        ArrayList<Alumno> AlumnosCreados =new ArrayList<Alumno>();
        
        //Creamos el objeto conexion para trabajar on la BD
        ConexionBD MySQL=new ConexionBD();
        //Conectamos con la BD
        MySQL.Conectar();
        //Construimos las tablas en la BD
        System.out.println("Seleccione según corresponda: ");
        System.out.println("1- Primera ejecucion del programa");
        System.out.println("2- He ejecutado el programa anteriormente");
        
        Scanner Opcion=new Scanner(System.in);
        if(1==Opcion.nextInt()){
        MySQL.ModificarBD("CREATE TABLE Materias(IdMateria INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "Materia JSON);");
        MySQL.ModificarBD("CREATE TABLE Alumnos(IdAlumno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "Alumno JSON);");
        MySQL.ModificarBD("CREATE TABLE Inscripciones(IdInscripcion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "Inscripcion JSON);");}
        
        
        //Construimos las tablas en la BD
       /* MySQL.ModificarBD("CREATE TABLE Materias(IdMateria INT NOT NULL AUTO_INCREMENT,"
                + "Materia JSON"
                + "PRIMARY KEY (IdMateria));");
        MySQL.ModificarBD("CREATE TABLE Alumnos(IdAlumno INT NOT NULL AUTO_INCREMENT,"
                + "Alumno JSON"
                + "primary key (IdAlumno));");
        MySQL.ModificarBD("CREATE TABLE Inscripciones(IdInscripcion INT NOT NULL AUTO_INCREMENT,"
                + "Inscripcion JSON"
                + "primary key (IdMateria));");*/
        //ResultSet respuesta;
        
        //Refrescamos ambos arraylists para cargarlos en memoria (Pierde el sentido el ingresar campo y nombre de tabla al hacer cada funcion por separado)
        RefrescarTablaAlumnos(MySQL, AlumnosCreados, "Alumnos", "Alumno");
        RefrescarTablaMaterias(MySQL, MateriasCreadas, "Materias", "Materia");
        
        
        /*Materia materiacorrelativa1=new Materia();
        Materia materiacorrelativa2=new Materia();
        Materia materiacorrelativa3=new Materia();
        materiacorrelativa1.setNombre("m1");
        materiacorrelativa2.setNombre("m2");
        materiacorrelativa3.setNombre("m3");
        ArrayList<Inscripcion> ListaDeInscripciones=new ArrayList<Inscripcion>();
        Materia materiaIncribir1=new Materia();
        
        materiaIncribir1.setNombre("matematica4");
        materiaIncribir1.addCorrelativa(materiacorrelativa1);
        materiaIncribir1.addCorrelativa(materiacorrelativa2);
        materiaIncribir1.addCorrelativa(materiacorrelativa3);
        materiaIncribir1.mostrarCorrelativas();
        
        Alumno Alejo=new Alumno("Alejo Rojo", "EISI20");
        Alejo.addMateriaAprobada(materiacorrelativa1);
        Alejo.addMateriaAprobada(materiacorrelativa2);
        Alejo.addMateriaAprobada(materiacorrelativa3);
        Alejo.mostrarAprobadas();
        //Alejo.mostrarAprobadas();
        
       System.out.println(materiaIncribir1.puedeCursar(Alejo));
       /* Materia materiaIncribir2=new Materia();
        materiaIncribir2.setNombre("lengua4");
        materiaIncribir2.addCorrelativa();
        materiaIncribir2.addCorrelativa();
        materiaIncribir2.addCorrelativa();
        materiaIncribir2.addCorrelativa();
        materiaIncribir2.mostrarCorrelativas();
        Alumno Alejo=new Alumno("Alejo Rojo", "EISI20");
        Alejo.addMateriaAprobada();
        Alejo.addMateriaAprobada();
        Alejo.addMateriaAprobada();
        Alejo.mostrarAprobadas();
        
        Inscripcion inscripcion1=new Inscripcion(materiaIncribir1,Alejo);
        Inscripcion inscripcion2=new Inscripcion(materiaIncribir2,Alejo);
        
        ListaDeInscripciones.add(inscripcion1);
        ListaDeInscripciones.add(inscripcion2);
        
        
        for(Inscripcion aux:ListaDeInscripciones){
            aux.aprobada();
            
        }*/
       
       
         
        
           
                   
           boolean salir=false;
          
                        
           
           
       while(!salir){
           System.out.println("DIGITE UN NUMERO DEL MENÚ: \n");
           System.out.println("1- Crear una Materia ");
           System.out.println("2- Crear un Alumno ");
           System.out.println("3- Inscribir un Alumno en una Materia ");
           System.out.println("0- Salir del Menu ");
           
           int opc=Opcion.nextInt();
           
           switch(opc){
               
               case 1 -> {
                   System.out.println("Escriba el nombre de la Nueva Materia");
                   //scan que ingresa el nombre
                   Opcion.nextLine();
                   String NombreMateriaNueva=Opcion.nextLine();
                   Materia NuevaMateria=new Materia();
                   NuevaMateria.setNombre(NombreMateriaNueva);
                  
                   
                    if (MateriasCreadas.isEmpty()==false) {
                        //sout para correlativas
                        //do while para agregado de correlativas
                        do{
                            //menu para correlativas puede ser un if con scan
                            
                            System.out.println("Desea agregar correlativas a la Nueva Materia?");
                            
                            System.out.println("1- SI");
                            System.out.println("2- NO");
                            
                            opc=Opcion.nextInt();
                            if(opc==1){
                                //si entro en el si
                                //printear la lista de matereias disponibles for each 
                                int indice=0;
                                System.out.println("Ingrese el numero de la materia que desea agregar como correlativa:\n");
                                for(Materia Aux:MateriasCreadas){
                                    
                                    System.out.println(indice + "- " + Aux.getNombre());
                                    indice++;
                                }
                                //scan para la seleccion de la materia
                                //agregar a la lista dela materia nueva y usar numero en arraylist.getindex
                                int opcMateria=Opcion.nextInt();
                                if(!(NuevaMateria.correlativas.contains(MateriasCreadas.get(opcMateria)))){
                                    NuevaMateria.correlativas.add(MateriasCreadas.get(opcMateria));
                                    //se inserta la nueva materia enla BD con el objeto que creamos
                                    //1-convertimos aJSON con la funcion que creamos
                                    /*       String NuevaMateriaJSON=ConvertirJSON(NuevaMateria);
                                    //2-mandamos la query con el objeto de conexion
                                    
                                    
                                    MySQL.ModificarBD("INSERT INTO materias (\"Materia\") VALUES ('"+NuevaMateriaJSON+"');");
                                    //agregar la nueva materia a la lasita refrescando la lista
                                    RefrescarTablaMaterias(MySQL,MateriasCreadas,"materias","Materia");*/
                                }
                            }
                        }while(opc==1 && NuevaMateria.correlativas.size()!= MateriasCreadas.size());
                        
                        
                    } //else {
                        //MateriasCreadas.add(NuevaMateria);
                        
                        //se inserta la nueva materia enla BD con el objeto que creamos
                        //1-convertimos aJSON con la funcion que creamos
                        String NuevaMateriaJSON=ConvertirJSON(NuevaMateria);
                        //2-mandamos la query con el objeto de conexion
                        MySQL.ModificarBD("INSERT INTO materias (Materia) VALUES ('"+NuevaMateriaJSON+"');");
                        
                         System.out.println("Se creo la materia");
                        //agregar la nueva materia a la lasita refrescando la lista
                        RefrescarTablaMaterias(MySQL,MateriasCreadas,"materias","Materia"); 
                        
                        System.out.println("Mostramos las materias creadas hasta el momento: \n");
                        
                        int indice=0;
                        for(Materia Aux:MateriasCreadas){
                            System.out.println(indice + "- " + Aux.getNombre());
                            indice++;
                        }
                    //}/// deberia ir el brake!!!!!
                    
                    //se refresca la lista de materias con la funcion de instanciacion de arraylist que debemos crear
                    
                }
               case 2 -> {
                   // AGREGANDO REGEX-------
                    String nombAlumno;
                    String numLegajo;
                    String regexNombre="^([A-Z]{1}[a-z]+[ ]?)";
                    String regexLegajo="^[0-9]{5}";
                    Opcion.nextLine();
                   do{
                       System.out.println("Escriba el nombre del Nuevo Alumno");
                       
                       
       
                   //scan que ingresa el nombre
                    nombAlumno=Opcion.nextLine();
                   
                    if(!nombAlumno.matches(regexNombre)){
                        
                        System.out.println("Nombre no valido");
                    }
                        
                   }while(!nombAlumno.matches(regexNombre));
                   
                   do{
                       
                       System.out.println("Escriba su legajo");
                   
                       numLegajo=Opcion.nextLine();
                       
                        if(!numLegajo.matches(regexLegajo)){
                        
                        System.out.println("Legajo no valido");
                    }
                       
                   }while(!numLegajo.matches(regexLegajo));
                   
                             
                   Alumno NuevoAlumno=new Alumno(nombAlumno,numLegajo);
                   
                    if (MateriasCreadas.isEmpty()==false) {
                   //sout para correlativas
                   //do while para agregado de correlativas
                   
                   
                   do{
                       //menu para correlativas puede ser un if con scan
                       System.out.println("Desea agregar Materia aprobada ?");
                       System.out.println("1- SI");
                       System.out.println("2- NO");
                       
                       if(Opcion.nextInt()==1){
                           //si entro en el si
                           //printear la lista de matereias disponibles for each
                           int indice=0;
                           System.out.println("Ingrese el numero de la materia que desea agregar como correlativa:");
                           for(Materia Aux:MateriasCreadas){
                               
                               System.out.println(indice + "- " + Aux.getNombre());
                               indice++;
                           }
                           //scan para la seleccion de la materia
                           //agregar a la lista dela materia nueva y usar numero en arraylist.getindex
                           
                           int opcMateria=Opcion.nextInt();
                           if(!(NuevoAlumno.aprobadas.contains(MateriasCreadas.get(opcMateria)))){
                               NuevoAlumno.aprobadas.add(MateriasCreadas.get(opcMateria));
                               
                           }
                       }
                   }while(opc==1 && NuevoAlumno.aprobadas.size()!= MateriasCreadas.size());
                   
                }
                   //se inserta la nueva materia enla BD con el objeto que creamos
                   //1-convertimos aJSON con la funcion que creamos
                   String NuevoAlumnoJSON=ConvertirJSON(NuevoAlumno);
                   //2-mandamos la query con el objeto de conexion
                   MySQL.ModificarBD("INSERT INTO alumnos (Alumno) VALUES ('"+NuevoAlumnoJSON+"');");
                   //agregar la nueva materia a la lasita refrescando la lista
                   RefrescarTablaAlumnos(MySQL,AlumnosCreados,"alumnos","alumno");
                }
                       
                       
                       
               case 3 -> {
                   System.out.println("Seleccione el Alumno que desea Inscribir: ");
                   int indice=0;
                   for(Alumno Aux:AlumnosCreados){
                       System.out.println(indice + "- " + Aux.getNombre());
                       indice++;
                   }
                   
                   int opcAlumno=Opcion.nextInt();
                   
                   System.out.println("Seleccione la Materia que desea Inscribir: ");
                   indice=0;
                   for(Materia Aux:MateriasCreadas){
                       System.out.println(indice + "- " + Aux.getNombre());
                       indice++;
                   }
                   int opcMateria=Opcion.nextInt();
                   
                   //creamos una nueva inscripcion
                   Inscripcion NuevaInscripcion= new Inscripcion(MateriasCreadas.get(opcMateria), AlumnosCreados.get(opcAlumno));
                   //Intentamos hacer la Inscripcion y si es correta la guardamos en la BD
                   if(NuevaInscripcion.aprobada()==true){
                       String NuevaInscripcionJSON=ConvertirJSON(NuevaInscripcion);
                       MySQL.ModificarBD("INSERT INTO inscripciones (\"Inscripcion\") VALUES ('"+NuevaInscripcionJSON+"');");
                       //en este caso no hay tabla de inscripciones por lo tanto no refrescamos tabla
                   }
                }
                       
                       
               case 0 -> {
                   salir=true;
                   MySQL.CerrarConexion();
                }
                       
               default -> System.out.println("Elegir una opcion valida entre 0 y 3");
                   
            }
          
       }
    }   
    //CODIFICADORES Y DECODIFICADORES JSON
    public static String ConvertirJSON(Object Variable) throws JsonProcessingException{
        ObjectMapper Mapeador=new ObjectMapper();
        String JSONResult=Mapeador.writeValueAsString(Variable);
        return JSONResult;
    }
    
    public static Materia ParseJSONMateria(String Variable) throws IOException{
        Materia Aux;
        ObjectMapper Mapeador=new ObjectMapper();
        Aux=Mapeador.readValue(Variable,Materia.class);
        return Aux;
    }
    
    public static Alumno ParseJSONAlumno(String Variable) throws IOException{
        Alumno Aux;
        ObjectMapper Mapeador=new ObjectMapper();
        Aux=Mapeador.readValue(Variable,Alumno.class);
        return Aux;
    }
    
    public Inscripcion ParseJSON(String Variable, Inscripcion a) throws IOException{
        Inscripcion Aux;
        ObjectMapper Mapeador=new ObjectMapper();
        Aux=Mapeador.readValue(Variable,a.getClass());
        return Aux;
    }
       
    public static void RefrescarTablaMaterias(ConexionBD Conexion,ArrayList<Materia> Lista, String NombreTabla, String NombreCampo) throws SQLException, IOException  {
        try{
        ResultSet respuesta=Conexion.Consultar("SELECT "+NombreCampo+" FROM "+NombreTabla+";");
        
        Lista.clear();
        while(respuesta.next()){
            System.out.println(respuesta.toString());
            Lista.add(ParseJSONMateria(respuesta.getString(NombreCampo)));
        }
        }catch(Exception e){}
    }
     public static void RefrescarTablaAlumnos(ConexionBD Conexion,ArrayList<Alumno> Lista, String NombreTabla, String NombreCampo) throws SQLException, IOException  {
        try{
         ResultSet respuesta=Conexion.Consultar("SELECT "+NombreCampo+" FROM "+NombreTabla+";");
        Lista.clear();
        while(respuesta.next()){
            Lista.add(ParseJSONAlumno(respuesta.getString(NombreCampo)));
        }
        }catch(Exception e){}
    }
  }
    
    

