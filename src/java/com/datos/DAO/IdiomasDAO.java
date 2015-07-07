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
import static persistencia.Tables.IDIOMAS;
import persistencia.tables.Idiomas;
import persistencia.tables.records.IdiomasRecord;

/**
 *
 * @author luisito
 */
public class IdiomasDAO {
    
    public List<IdiomasRecord> ConsultarIdiomas() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<IdiomasRecord>listadoIdiomas= new ArrayList<IdiomasRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(IDIOMAS).fetch();
         for(Record r : result){
             IdiomasRecord IdiomasEncontrados= new IdiomasRecord();
             IdiomasEncontrados.setIdiomaid(r.getValue(IDIOMAS.IDIOMAID));
             IdiomasEncontrados.setNombre(r.getValue(IDIOMAS.NOMBRE));
             listadoIdiomas.add(IdiomasEncontrados);
         }
          conexion.close();
          return listadoIdiomas;
    }
    
    public List<IdiomasRecord> ConsultarIdiomasEspecificos(IdiomasRecord IdiomasParametros) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        List<IdiomasRecord>listadoIdiomas= new ArrayList<IdiomasRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(IDIOMAS).where(IDIOMAS.IDIOMAID.equal(IdiomasParametros.getIdiomaid()).or(IDIOMAS.NOMBRE.equal(IdiomasParametros.getNombre()))).fetch();
         for(Record r : result){
             IdiomasRecord IdiomasEncontrados= new IdiomasRecord();
             IdiomasEncontrados.setIdiomaid(r.getValue(IDIOMAS.IDIOMAID));
             IdiomasEncontrados.setNombre(r.getValue(IDIOMAS.NOMBRE));
             listadoIdiomas.add(IdiomasEncontrados);
         }
          conexion.close();
          return listadoIdiomas;
    }
    
    public boolean GrabarIdioma(IdiomasRecord misIdiomas) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.insertInto(Idiomas.IDIOMAS,Idiomas.IDIOMAS.NOMBRE)
                .values(misIdiomas.getNombre()).execute();
        conexion.close();
        return true;
    }
    public boolean ActualizarIdioma(IdiomasRecord misIdiomas) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.update(IDIOMAS).set(IDIOMAS.NOMBRE,misIdiomas.getNombre()).where(IDIOMAS.IDIOMAID.equal(misIdiomas.getIdiomaid()).or(IDIOMAS.NOMBRE.equal(misIdiomas.getNombre()))).execute();
        conexion.close();
        return true;
    }
    
    public boolean EliminarIdioma(IdiomasRecord idioma) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.delete(IDIOMAS).where(IDIOMAS.IDIOMAID.equal(idioma.getIdiomaid()));
        return true;
    }
}
