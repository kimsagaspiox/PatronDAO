/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patron_DAO;

import java.util.Scanner;

/**
 *
 * @author Zonia Roldan
 */
public class Alumno {
    private int VariableEleccion;
    private int id;
    private String nombre;
    static Scanner sc = new Scanner(System.in);
    static Main principal = new Main();
    public void Menu(){
        System.out.println("Seleccione la accion que desea llevar a cabo\nRegistrar (1)\nModificar (2)\nElminar (3)\nListar (4)");
        VariableEleccion = sc.nextInt();
        switch (VariableEleccion){
            case 1:
                RegistrarAlumno();
            break;
            case 2:
                ModificarAlumno();
            break;
            case 3:
                EliminarAlumno();
            break;
            case 4:
                ListarAlumno();
            break;
        }
    }
    
    public void RegistrarAlumno(){
        System.out.println("Ingrese el nombre que desea registrar");
        nombre = sc.next();
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        try {
            InterfazDAO dao = new PatronDAOIMPL();
            dao.registrar(alumno);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("¿Desea realizar otra acción?\nSí (1)\nNo(2)");
        VariableEleccion = sc.nextInt();
        
        if (VariableEleccion == 1){
            Menu();
        }
            
    }
    public void ModificarAlumno(){
        System.out.println("Ingrese el id que desea modificar");
        id = sc.nextInt();
        System.out.println("Ingrese el nombre por el que lo desea modificar");
        nombre = sc.next();
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setId(id);
        try {
            InterfazDAO DAO = new PatronDAOIMPL();
              DAO.modificar(alumno);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("¿Desea realizar otra acción?\nSí (1)\nNo(2)");
        VariableEleccion = sc.nextInt();
        if (VariableEleccion == 1){
            Menu();
        }
    }
    public void EliminarAlumno(){
        System.out.println("Ingrese el id que desea eliminar");
        id = sc.nextInt();
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setId(id);
        try {
            InterfazDAO DAO = new PatronDAOIMPL();
              DAO.eliminar(alumno);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("¿Desea realizar otra acción?\nSí (1)\nNo(2)");
        VariableEleccion = sc.nextInt();
        
        if (VariableEleccion == 1){
            Menu();
        }
    }
    public void ListarAlumno(){
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setId(id);
        try {
            InterfazDAO dao = new PatronDAOIMPL();
                for(Alumno listado : dao.listar()){
                    System.out.println(listado.getNombre());
                }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("¿Desea realizar otra acción?\nSí (1)\nNo(2)");
        VariableEleccion = sc.nextInt();
        
        if (VariableEleccion == 1){
            Menu();
        }
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
