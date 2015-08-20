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
import persistencia.tables.Tiempos;
import static persistencia.tables.Tiempos.TIEMPOS;
import persistencia.tables.records.TiemposRecord;

/**
 *
 * @author luisito
 */
public class TiemposDAO {
    
    /*Metodo que trae el listado de todos los tiempos*/
    public List<TiemposRecord> ConsultarTiempos() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<TiemposRecord> listadoTiempos= new ArrayList<TiemposRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(TIEMPOS).fetch();
        for(Record r : result){
            TiemposRecord Tiempos = new TiemposRecord();
            Tiempos.setTiemposid(r.getValue(TIEMPOS.TIEMPOSID));
            Tiempos.setNombretiempo(r.getValue(TIEMPOS.NOMBRETIEMPO));
            Tiempos.setNemotecnicotiempo(r.getValue(TIEMPOS.NEMOTECNICOTIEMPO));
            listadoTiempos.add(Tiempos);
        }
        conexion.close();
        return listadoTiempos;
    }
    
    /*Metodo que trae un tiempo Especifico*/
    public List<TiemposRecord> ConsultarTiemposEspecifico(TiemposRecord TiempoIngreso) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<TiemposRecord> listadoTiempos= new ArrayList<TiemposRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(TIEMPOS).where(TIEMPOS.TIEMPOSID.equal(TiempoIngreso.getTiemposid()).or(TIEMPOS.NOMBRETIEMPO.equal(TiempoIngreso.getNombretiempo())).or(TIEMPOS.NEMOTECNICOTIEMPO.equal(TiempoIngreso.getNemotecnicotiempo()))).fetch();
        for(Record r : result){
            TiemposRecord Tiempos = new TiemposRecord();
            Tiempos.setTiemposid(r.getValue(TIEMPOS.TIEMPOSID));
            Tiempos.setNombretiempo(r.getValue(TIEMPOS.NOMBRETIEMPO));
            Tiempos.setNemotecnicotiempo(r.getValue(TIEMPOS.NEMOTECNICOTIEMPO));
            listadoTiempos.add(Tiempos);
        }
        conexion.close();
        return listadoTiempos;
    }
    
    /*Metodo Para almacenar los tiempos*/
    public boolean grabarTiempo(TiemposRecord tiempo) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.insertInto(Tiempos.TIEMPOS, Tiempos.TIEMPOS.NOMBRETIEMPO,Tiempos.TIEMPOS.NEMOTECNICOTIEMPO).values(tiempo.getNombretiempo(),tiempo.getNemotecnicotiempo()).execute();
        conexion.close();
        return true;
    }
    
    /*Metodo para actualizar los tiempos*/
    public boolean ActualizarTiempo(TiemposRecord tiempo) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.update(TIEMPOS).set(TIEMPOS.NOMBRETIEMPO,tiempo.getNombretiempo()).set(TIEMPOS.NEMOTECNICOTIEMPO,tiempo.getNemotecnicotiempo()).where(TIEMPOS.TIEMPOSID.equal(tiempo.getTiemposid())).execute();
        conexion.close();
        return true;
    }
    
     public boolean EliminarTiempos(TiemposRecord tiempo) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.delete(TIEMPOS).where(TIEMPOS.TIEMPOSID.equal(tiempo.getTiemposid())).execute();
        return true;
    }
}
