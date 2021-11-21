/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patron_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zonia Roldan
 */
public class PatronDAOIMPL extends Conexion implements InterfazDAO {

    @Override
    public void registrar(Alumno alumno) throws Exception {
        try{
        this.EstablerConexion();
        PreparedStatement st = this.conectar.prepareStatement("insert into Alumno (nombre) values (?);");
        st.setString(1, alumno.getNombre());
        st.executeUpdate();
        } catch (Exception e){
        throw e;
        }finally {
        this.cerrar();
        }
    }

    @Override
    public void modificar(Alumno alumno) throws Exception {
         try{
        this.EstablerConexion();
        PreparedStatement st = this.conectar.prepareStatement("update Alumno set nombre = ? where id = ?");
        st.setString(1, alumno.getNombre());
        st.setInt(2, alumno.getId());
        st.executeUpdate();
        } catch (Exception e){
        throw e;
        }finally {
        this.cerrar();
        }
    }

    @Override
    public void eliminar(Alumno alumno) throws Exception {
        try{
        this.EstablerConexion();
        PreparedStatement st = this.conectar.prepareStatement("delete from Alumno where id = ? ");
        st.setInt(1, alumno.getId());
        st.executeUpdate();
        } catch (Exception e){
        throw e;
        }finally {
        this.cerrar();
        }
    }

    @Override
    public List<Alumno> listar() throws Exception {
           List <Alumno> lista = new ArrayList();
        try{
        this.EstablerConexion();
        PreparedStatement st = this.conectar.prepareStatement("select * from Alumno");
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            Alumno alumn = new Alumno();
            alumn.setId(rs.getInt("id"));
            alumn.setNombre(rs.getString("nombre"));
            lista.add(alumn);
        }
        rs.close();
        st.close();
        } catch (Exception e){
        throw e;
        }finally {
        this.cerrar();
        }
        return lista;
    }

    @Override
    public void registrar(Profesor profesor) throws Exception {
        try{
        this.EstablerConexion();
        PreparedStatement st = this.conectar.prepareStatement("insert into Profesor (nombre) values (?);");
        st.setString(1, profesor.getNombre());
        st.executeUpdate();
        } catch (Exception e){
        throw e;
        }finally {
        this.cerrar();
        }
    }

    @Override
    public void modificar(Profesor profesor) throws Exception {
        try{
        this.EstablerConexion();
        PreparedStatement st = this.conectar.prepareStatement("update Profesor set nombre = ? where id = ?");
        st.setString(1, profesor.getNombre());
        st.setInt(2, profesor.getId());
        st.executeUpdate();
        } catch (Exception e){
        throw e;
        }finally {
        this.cerrar();
        }
    }

    @Override
    public void eliminar(Profesor profesor) throws Exception {
        try{
        this.EstablerConexion();
        PreparedStatement st = this.conectar.prepareStatement("delete from Profesor where id = ? ");
        st.setInt(1, profesor.getId());
        st.executeUpdate();
        } catch (Exception e){
        throw e;
        }finally {
        this.cerrar();
        }
    }

    @Override
    public List<Profesor> listado() throws Exception {
        List <Profesor> listado = new ArrayList();
        try{
        this.EstablerConexion();
        PreparedStatement st = this.conectar.prepareStatement("select * from Profesor");
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            Profesor profesor = new Profesor();
            profesor.setId(rs.getInt("id"));
            profesor.setNombre(rs.getString("nombre"));
            listado.add(profesor);
        }
        rs.close();
        st.close();
        } catch (Exception e){
        throw e;
        }finally {
        this.cerrar();
        }
        return listado;
    }

    }
