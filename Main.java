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
public class Main {

    /**
     * @param args the command line arguments
     */
    static int VariableEleccion;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        Profesor profesor = new Profesor();
        Conexion conexion = new Conexion();
        System.out.println("Elija la forma en la que desea entrar\nAlumno(1)\nProfesor(2)");
        VariableEleccion = sc.nextInt();
        if (VariableEleccion == 1){
            alumno.Menu();
        } else if (VariableEleccion == 2){
            profesor.Menu();
        }
    }
}
