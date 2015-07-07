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
import persistencia.tables.Tipospalabras;
import static persistencia.tables.Tipospalabras.TIPOSPALABRAS;
import persistencia.tables.records.TipospalabrasRecord;

/**
 *
 * @author luisito
 */
public class TiposPalabrasDAO {
    /*Metodo que trae el listado de todos los tipos de palabras*/
    public List<TipospalabrasRecord> ConsultarTiposPalabras() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<TipospalabrasRecord> listadoTiposPalabras= new ArrayList<TipospalabrasRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(TIPOSPALABRAS).fetch();
        for(Record r : result){
            TipospalabrasRecord tipos = new TipospalabrasRecord();
            tipos.setTipoid(r.getValue(TIPOSPALABRAS.TIPOID));
            tipos.setNombretipo(r.getValue(TIPOSPALABRAS.NOMBRETIPO));
            listadoTiposPalabras.add(tipos);
        }
        conexion.close();
        return listadoTiposPalabras;
    }
    
    /*Metodo que trae el listado de todos los tipos palabras*/
    public List<TipospalabrasRecord> ConsultarTiposPalabrasEspecificas(TipospalabrasRecord tipospalabras) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<TipospalabrasRecord> listadoTiposPalabras= new ArrayList<TipospalabrasRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(TIPOSPALABRAS).where(TIPOSPALABRAS.TIPOID.equal(tipospalabras.getTipoid()).or(TIPOSPALABRAS.NOMBRETIPO.equal(tipospalabras.getNombretipo()))).fetch();
        for(Record r : result){
            TipospalabrasRecord tipos = new TipospalabrasRecord();
            tipos.setTipoid(r.getValue(TIPOSPALABRAS.TIPOID));
            tipos.setNombretipo(r.getValue(TIPOSPALABRAS.NOMBRETIPO));
            listadoTiposPalabras.add(tipos);
        }
        conexion.close();
        return listadoTiposPalabras;
    }
    
    public boolean grabartiposPalabras(TipospalabrasRecord tipos) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.insertInto(Tipospalabras.TIPOSPALABRAS, Tipospalabras.TIPOSPALABRAS.NOMBRETIPO).values(tipos.getNombretipo()).execute();
        conexion.close();
        return true;
    }
    
    /*Metodo para actualizar los tiposPalabras*/
    public boolean ActualizarTipos(TipospalabrasRecord tipos) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.update(TIPOSPALABRAS).set(TIPOSPALABRAS.NOMBRETIPO,tipos.getNombretipo()).where(TIPOSPALABRAS.TIPOID.equal(tipos.getTipoid())).execute();
        conexion.close();
        return true;
    }
    
    public boolean EliminarTipos(TipospalabrasRecord tipos) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.delete(TIPOSPALABRAS).where(TIPOSPALABRAS.TIPOID.equal(tipos.getTipoid()));
        return true;
    }
}
