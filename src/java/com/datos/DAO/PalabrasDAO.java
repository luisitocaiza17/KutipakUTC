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
import persistencia.tables.Palabras;
import static persistencia.tables.Palabras.PALABRAS;
import persistencia.tables.records.PalabrasRecord;

/**
 *
 * @author luisito
 */
public class PalabrasDAO {
    
   public List<PalabrasRecord> ConsultarPalabras() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<PalabrasRecord>listadoPalabras= new ArrayList<PalabrasRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(PALABRAS).fetch();
         for(Record r : result){
             PalabrasRecord palabrasEncontradas= new PalabrasRecord();
             palabrasEncontradas.setPalabraid(r.getValue(PALABRAS.PALABRAID));
             palabrasEncontradas.setIdiomaid(r.getValue(PALABRAS.IDIOMAID));
             palabrasEncontradas.setNombrepalabra(r.getValue(PALABRAS.NOMBREPALABRA));
             palabrasEncontradas.setPalPalabraid(r.getValue(PALABRAS.PAL_PALABRAID));
             palabrasEncontradas.setSinonimo(r.getValue(PALABRAS.SINONIMO));
             palabrasEncontradas.setTiemposid(r.getValue(PALABRAS.TIEMPOSID));
             palabrasEncontradas.setTipoid(r.getValue(PALABRAS.TIPOID));
             listadoPalabras.add(palabrasEncontradas);
         }
          conexion.close();
          return listadoPalabras;
    }  
   
   public List<PalabrasRecord> ConsultarPalabrasEspecificas(PalabrasRecord misPalabras) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<PalabrasRecord>listadoPalabras= new ArrayList<PalabrasRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(PALABRAS).where(PALABRAS.PALABRAID.equal(misPalabras.getPalabraid())
                .or(PALABRAS.IDIOMAID.equal(misPalabras.getIdiomaid())
                        .or(PALABRAS.NOMBREPALABRA.equal(misPalabras.getNombrepalabra())
                                .or(PALABRAS.PAL_PALABRAID.equal(misPalabras.getPalPalabraid())
                                        .or(PALABRAS.SINONIMO.equal(misPalabras.getSinonimo())
                                                .or(PALABRAS.TIEMPOSID.equal(misPalabras.getTiemposid())
                                                        .or(PALABRAS.TIPOID.equal(misPalabras.getTipoid())))))))).fetch();
         for(Record r : result){
             PalabrasRecord palabrasEncontradas= new PalabrasRecord();
             palabrasEncontradas.setPalabraid(r.getValue(PALABRAS.PALABRAID));
             palabrasEncontradas.setIdiomaid(r.getValue(PALABRAS.IDIOMAID));
             palabrasEncontradas.setNombrepalabra(r.getValue(PALABRAS.NOMBREPALABRA));
             palabrasEncontradas.setPalPalabraid(r.getValue(PALABRAS.PAL_PALABRAID));
             palabrasEncontradas.setSinonimo(r.getValue(PALABRAS.SINONIMO));
             palabrasEncontradas.setTiemposid(r.getValue(PALABRAS.TIEMPOSID));
             palabrasEncontradas.setTipoid(r.getValue(PALABRAS.TIPOID));
             listadoPalabras.add(palabrasEncontradas);
         }
          conexion.close();
          return listadoPalabras;
    } 
    
    public boolean GrabarPalabras(PalabrasRecord misPalabras) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.insertInto(Palabras.PALABRAS,Palabras.PALABRAS.IDIOMAID,Palabras.PALABRAS.NOMBREPALABRA,Palabras.PALABRAS.PAL_PALABRAID,PALABRAS.SINONIMO,PALABRAS.TIEMPOSID,PALABRAS.TIPOID)
                .values(misPalabras.getIdiomaid(),misPalabras.getNombrepalabra(),misPalabras.getPalPalabraid(),misPalabras.getSinonimo(),misPalabras.getTiemposid(),misPalabras.getTipoid()).execute();
        conexion.close();
        return true;
    }
    
    public boolean ActualizarPalabras(PalabrasRecord misPalabras) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.update(PALABRAS).set(PALABRAS.IDIOMAID,misPalabras.getIdiomaid())
                .set(PALABRAS.NOMBREPALABRA,misPalabras.getNombrepalabra())
                .set(PALABRAS.PAL_PALABRAID,misPalabras.getPalPalabraid())
                .set(PALABRAS.SINONIMO,misPalabras.getSinonimo())
                .set(PALABRAS.TIEMPOSID,misPalabras.getTiemposid())
                .set(PALABRAS.TIPOID,misPalabras.getTipoid())
                .where(PALABRAS.PALABRAID.equal(misPalabras.getPalabraid())).execute();
        conexion.close();
        return true;
    }
   
}
