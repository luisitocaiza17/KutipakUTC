/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import persistencia.tables.Usuario;
import static persistencia.tables.Usuario.USUARIO;
import persistencia.tables.records.UsuarioRecord;

/**
 *
 * @author luisito
 */
public class UsuarioDAO {
    public static List<UsuarioRecord> ConsultarUsuarios() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<UsuarioRecord> listadoUsuarios= new ArrayList<UsuarioRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(USUARIO).fetch();
        for(Record r : result){
            UsuarioRecord losUsuarios = new UsuarioRecord();
            losUsuarios.setUsuarioid(r.getValue(USUARIO.USUARIOID));
            losUsuarios.setNombreusuario(r.getValue(USUARIO.NOMBREUSUARIO));
            losUsuarios.setContrasenia(r.getValue(USUARIO.CONTRASENIA));
            losUsuarios.setRol(r.getValue(USUARIO.ROL));
            losUsuarios.setPersonaid(r.getValue(USUARIO.PERSONAID));
            listadoUsuarios.add(losUsuarios);
        }
        conexion.close();
        return listadoUsuarios;
    }
    
     public static List<UsuarioRecord> ConsultarUsuariosEspecificos(UsuarioRecord usuariosp) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<UsuarioRecord> listadoUsuarios= new ArrayList<UsuarioRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(USUARIO)
                .where(USUARIO.USUARIOID.equal(usuariosp.getUsuarioid())
                        .or(USUARIO.ROL.equal(usuariosp.getRol())
                                .or(USUARIO.PERSONAID.equal(usuariosp.getPersonaid())
                                        .or(USUARIO.NOMBREUSUARIO.equal(usuariosp.getNombreusuario())
                                                .or(USUARIO.CONTRASENIA.equal(usuariosp.getContrasenia()))))))
                .fetch();
        for(Record r : result){
            UsuarioRecord losUsuarios = new UsuarioRecord();
            losUsuarios.setUsuarioid(r.getValue(USUARIO.USUARIOID));
            losUsuarios.setNombreusuario(r.getValue(USUARIO.NOMBREUSUARIO));
            losUsuarios.setContrasenia(r.getValue(USUARIO.CONTRASENIA));
            losUsuarios.setRol(r.getValue(USUARIO.ROL));
            losUsuarios.setPersonaid(r.getValue(USUARIO.PERSONAID));
            listadoUsuarios.add(losUsuarios);
        }
        conexion.close();
        return listadoUsuarios;
    }
     
    public static List<UsuarioRecord> ConsultarUsuariosEspecificosexistente(UsuarioRecord usuariosp) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<UsuarioRecord> listadoUsuarios= new ArrayList<UsuarioRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(USUARIO)
                .where((USUARIO.NOMBREUSUARIO.equal(usuariosp.getNombreusuario())
                                                .and(USUARIO.CONTRASENIA.equal(usuariosp.getContrasenia()))))
                .fetch();
        for(Record r : result){
            UsuarioRecord losUsuarios = new UsuarioRecord();
            losUsuarios.setUsuarioid(r.getValue(USUARIO.USUARIOID));
            losUsuarios.setNombreusuario(r.getValue(USUARIO.NOMBREUSUARIO));
            losUsuarios.setContrasenia(r.getValue(USUARIO.CONTRASENIA));
            losUsuarios.setRol(r.getValue(USUARIO.ROL));
            losUsuarios.setPersonaid(r.getValue(USUARIO.PERSONAID));
            listadoUsuarios.add(losUsuarios);
        }
        conexion.close();
        return listadoUsuarios;
    } 
     
     
    /*Metodo Para almacenar los Personas*/
    public boolean grabarUsuarios(UsuarioRecord usuariosp) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.insertInto(Usuario.USUARIO, Usuario.USUARIO.USUARIOID,Usuario.USUARIO.ROL,Usuario.USUARIO.PERSONAID,Usuario.USUARIO.NOMBREUSUARIO,Usuario.USUARIO.CONTRASENIA)
                .values(usuariosp.getUsuarioid(),usuariosp.getRol(),usuariosp.getPersonaid(),usuariosp.getNombreusuario(),usuariosp.getContrasenia()).execute();
        conexion.close();
        return true;
    }
    
     public boolean ActualizarUsuarios(UsuarioRecord usuariosp) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.update(USUARIO).set(USUARIO.ROL,usuariosp.getRol())
                .set(USUARIO.PERSONAID,usuariosp.getPersonaid())
                .set(USUARIO.NOMBREUSUARIO,usuariosp.getNombreusuario())
                .set(USUARIO.CONTRASENIA,usuariosp.getContrasenia())
                .where(USUARIO.USUARIOID.equal(usuariosp.getUsuarioid())).execute();
        conexion.close();
        return true;
    }
    
      public boolean EliminarUsuarios(UsuarioRecord usuariosp) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.delete(USUARIO).where(USUARIO.USUARIOID.equal(usuariosp.getUsuarioid()));
        return true;
    }
}
