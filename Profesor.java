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
public class Profesor {
    public int id;
    public String nombre;
    static int VariableEleccion;
    static Scanner sc = new Scanner (System.in);
    public void Menu(){
        System.out.println("Seleccione la accion que desea llevar a cabo\nRegistrar (1)\nModificar (2)\nElminar (3)\nListar (4)");
        VariableEleccion = sc.nextInt();
        switch (VariableEleccion){
            case 1:
                Registrar();
            break;
            case 2:
                Modificar();
            break;
            case 3:
                Eliminar();
            break;
            case 4:
                Listar();
            break;
        }
    }
    public void Registrar(){
        System.out.println("Ingrese el nombre que desea registrar");
        nombre = sc.next();
        Profesor profesor = new Profesor();
        profesor.setNombre(nombre);
        try {
            InterfazDAO dao = new PatronDAOIMPL();
            dao.registrar(profesor);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("¿Desea realizar otra acción?\nSí (1)\nNo(2)");
        VariableEleccion = sc.nextInt();
        
        if (VariableEleccion == 1){
            Menu();
        }
    }

     public void Modificar(){
        System.out.println("Ingrese el id que desea modificar");
        id = sc.nextInt();
        System.out.println("Ingrese el nombre por el que lo desea modificar");
        nombre = sc.next();
        Profesor profesor = new Profesor();
        profesor.setNombre(nombre);
        profesor.setId(id);
        try {
            InterfazDAO dao = new PatronDAOIMPL();
              dao.modificar(profesor);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("¿Desea realizar otra acción?\nSí (1)\nNo(2)");
        VariableEleccion = sc.nextInt();
        
        if (VariableEleccion == 1){
            Menu();
        }
    }
    public void Eliminar(){
        System.out.println("Ingrese el id que desea eliminar");
        id = sc.nextInt();
        Profesor profesor = new Profesor();
        profesor.setNombre(nombre);
        profesor.setId(id);
        try {
            InterfazDAO dao = new PatronDAOIMPL();
              dao.eliminar(profesor);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("¿Desea realizar otra acción?\nSí (1)\nNo(2)");
        VariableEleccion = sc.nextInt();
        
        if (VariableEleccion == 1){
            Menu();
        }
    }
     public void Listar(){
        Profesor profesor = new Profesor();
        profesor.setNombre(nombre);
        profesor.setId(id);
        try {
            InterfazDAO dao = new PatronDAOIMPL();
                for(Profesor listar : dao.listado()){
                    System.out.println(listar.getNombre());
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
