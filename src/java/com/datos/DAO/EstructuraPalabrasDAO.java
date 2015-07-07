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
import persistencia.tables.Estructurapalabras;
import static persistencia.tables.Estructurapalabras.ESTRUCTURAPALABRAS;
import persistencia.tables.records.EstructurapalabrasRecord;
import persistencia.tables.records.TipospalabrasRecord;

/**
 *
 * @author luisito
 */
public class EstructuraPalabrasDAO {
    public List<EstructurapalabrasRecord> ConsultarEstruturaPalabras() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<EstructurapalabrasRecord>listadoEstructuraPalabras= new ArrayList<EstructurapalabrasRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(ESTRUCTURAPALABRAS).fetch();
         for(Record r : result){
             EstructurapalabrasRecord lasEstructurasPalabras= new EstructurapalabrasRecord();
             lasEstructurasPalabras.setEstructuraid(r.getValue(ESTRUCTURAPALABRAS.ESTRUCTURAID));
             lasEstructurasPalabras.setTipoid(r.getValue(ESTRUCTURAPALABRAS.TIPOID));
             listadoEstructuraPalabras.add(lasEstructurasPalabras);
         }
          conexion.close();
          return listadoEstructuraPalabras;
    }
    
    public List<EstructurapalabrasRecord> ConsultarEstruturaPalabrasEspecificas(EstructurapalabrasRecord misEstructurasPalabras) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<EstructurapalabrasRecord>listadoEstructuraPalabras= new ArrayList<EstructurapalabrasRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(ESTRUCTURAPALABRAS).where(ESTRUCTURAPALABRAS.ESTRUCTURAID.equal(misEstructurasPalabras.getEstructuraid()).or(ESTRUCTURAPALABRAS.TIPOID.equal(misEstructurasPalabras.getTipoid()))).fetch();
         for(Record r : result){
             EstructurapalabrasRecord lasEstructurasPalabras= new EstructurapalabrasRecord();
             lasEstructurasPalabras.setEstructuraid(r.getValue(ESTRUCTURAPALABRAS.ESTRUCTURAID));
             lasEstructurasPalabras.setTipoid(r.getValue(ESTRUCTURAPALABRAS.TIPOID));
             listadoEstructuraPalabras.add(lasEstructurasPalabras);
         }
          conexion.close();
          return listadoEstructuraPalabras;
    }
    
    public boolean GrabarEstructura(EstructurapalabrasRecord misEstructurasPalabras) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.insertInto(Estructurapalabras.ESTRUCTURAPALABRAS,Estructurapalabras.ESTRUCTURAPALABRAS.ESTRUCTURAID,Estructurapalabras.ESTRUCTURAPALABRAS.TIPOID)
                .values(misEstructurasPalabras.getEstructuraid(),misEstructurasPalabras.getTipoid()).execute();
        conexion.close();
        return true;
    }
    
    public boolean ActualizarEstructura(EstructurapalabrasRecord misEstructurasPalabras) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.update(ESTRUCTURAPALABRAS)
                .set(ESTRUCTURAPALABRAS.ESTRUCTURAID,misEstructurasPalabras.getEstructuraid())
                .set(ESTRUCTURAPALABRAS.TIPOID,misEstructurasPalabras.getTipoid())
                .where(ESTRUCTURAPALABRAS.TIPOID.equal(misEstructurasPalabras.getTipoid())
                        .and(ESTRUCTURAPALABRAS.ESTRUCTURAID.equal(misEstructurasPalabras.getEstructuraid())))
                .execute();
        conexion.close();
        return true;
    }
    
     public boolean EliminarEstructura(EstructurapalabrasRecord estructuraPalabra,TipospalabrasRecord tipos) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.delete(ESTRUCTURAPALABRAS).where(ESTRUCTURAPALABRAS.ESTRUCTURAID.equal(estructuraPalabra.getEstructuraid()).and(ESTRUCTURAPALABRAS.TIPOID.equal(tipos.getTipoid())));
        return true;
    }
}
