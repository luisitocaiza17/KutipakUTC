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
import persistencia.tables.Personas;
import static persistencia.tables.Personas.PERSONAS;
import persistencia.tables.records.PersonasRecord;

/**
 *
 * @author luisito
 */
public class PersonasDAO {
    
    public List<PersonasRecord> ConsultarPersonas() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<PersonasRecord> listadoPersonas= new ArrayList<PersonasRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(PERSONAS).fetch();
        for(Record r : result){
            PersonasRecord lasPersonas = new PersonasRecord();
            lasPersonas.setPersonaid(r.getValue(PERSONAS.PERSONAID));
            lasPersonas.setApellidos(r.getValue(PERSONAS.APELLIDOS));
            lasPersonas.setCedula(r.getValue(PERSONAS.CEDULA));
            lasPersonas.setCorreoelectronico(r.getValue(PERSONAS.CORREOELECTRONICO));
            lasPersonas.setNombres(r.getValue(PERSONAS.NOMBRES));
            lasPersonas.setPersonaid(r.getValue(PERSONAS.PERSONAID));
            lasPersonas.setTelefono(r.getValue(PERSONAS.TELEFONO));
            listadoPersonas.add(lasPersonas);
        }
        conexion.close();
        return listadoPersonas;
    }
    
    public List<PersonasRecord> ConsultarPersonasEspecificos(PersonasRecord misPersonas) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<PersonasRecord> listadoPersonas= new ArrayList<PersonasRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select()
                .from(PERSONAS)
                .where(PERSONAS.APELLIDOS.equal(misPersonas.getApellidos())
                        .or(PERSONAS.CEDULA.equal(misPersonas.getCedula())
                                .or(PERSONAS.CORREOELECTRONICO.equal(misPersonas.getCorreoelectronico())
                                        .or(PERSONAS.NOMBRES.equal(misPersonas.getNombres())
                                                .or(PERSONAS.PERSONAID.equal(misPersonas.getPersonaid())
                                                        .or(PERSONAS.TELEFONO.equal(misPersonas.getTelefono()))))))).fetch();
        for(Record r : result){
            PersonasRecord lasPersonas = new PersonasRecord();
            lasPersonas.setPersonaid(r.getValue(PERSONAS.PERSONAID));
            lasPersonas.setApellidos(r.getValue(PERSONAS.APELLIDOS));
            lasPersonas.setCedula(r.getValue(PERSONAS.CEDULA));
            lasPersonas.setCorreoelectronico(r.getValue(PERSONAS.CORREOELECTRONICO));
            lasPersonas.setNombres(r.getValue(PERSONAS.NOMBRES));
            lasPersonas.setPersonaid(r.getValue(PERSONAS.PERSONAID));
            lasPersonas.setTelefono(r.getValue(PERSONAS.TELEFONO));
            listadoPersonas.add(lasPersonas);
        }
        conexion.close();
        return listadoPersonas;
    }
    
    /*Metodo Para almacenar los Personas*/
    public boolean grabarPersonas(PersonasRecord misPersonas) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.insertInto(Personas.PERSONAS, Personas.PERSONAS.APELLIDOS,Personas.PERSONAS.CEDULA,Personas.PERSONAS.CORREOELECTRONICO,Personas.PERSONAS.NOMBRES,Personas.PERSONAS.TELEFONO)
                .values(misPersonas.getApellidos(),misPersonas.getCedula(),misPersonas.getCorreoelectronico(),misPersonas.getNombres(),misPersonas.getTelefono()).execute();
        conexion.close();
        return true;
    }
    
     public boolean ActualizarTiempo(PersonasRecord mispersonas) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.update(PERSONAS).set(PERSONAS.APELLIDOS,mispersonas.getApellidos())
                .set(PERSONAS.CEDULA,mispersonas.getCedula())
                .set(PERSONAS.CORREOELECTRONICO,mispersonas.getCorreoelectronico())
                .set(PERSONAS.NOMBRES,mispersonas.getNombres())
                .set(PERSONAS.TELEFONO,mispersonas.getTelefono())
                .where(PERSONAS.PERSONAID.equal(mispersonas.getPersonaid())).execute();
        conexion.close();
        return true;
    }
    
}
