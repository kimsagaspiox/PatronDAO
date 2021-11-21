/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patron_DAO;

import java.util.List;

/**
 *
 * @author Zonia Roldan
 */
public interface InterfazDAO {
     public void registrar (Alumno alumno) throws Exception;
    public void modificar (Alumno alumno) throws Exception;
    public void eliminar (Alumno alumno) throws Exception;
    public List<Alumno> listar() throws Exception;
    
    public void registrar (Profesor profesor) throws Exception;
    public void modificar (Profesor profesor) throws Exception;
    public void eliminar (Profesor profesor) throws Exception;
    public List<Profesor> listado() throws Exception;
}
