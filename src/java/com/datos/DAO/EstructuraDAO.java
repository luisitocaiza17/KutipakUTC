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
import persistencia.tables.Estructura;
import static persistencia.tables.Estructura.ESTRUCTURA;
import persistencia.tables.records.EstructuraRecord;

/**
 *
 * @author luisito
 */
public class EstructuraDAO {
    public List<EstructuraRecord> ConsultarEstrutura () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
    List<EstructuraRecord>listadoEstructuras= new ArrayList<EstructuraRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(ESTRUCTURA).fetch();
         for(Record r : result){
             EstructuraRecord lasEstructuras = new EstructuraRecord();
             lasEstructuras.setEstructuraid(r.getValue(ESTRUCTURA.ESTRUCTURAID));
             lasEstructuras.setFormula(r.getValue(ESTRUCTURA.FORMULA));
             lasEstructuras.setIdiomaid(r.getValue(ESTRUCTURA.IDIOMAID));
             lasEstructuras.setNombreestructura(r.getValue(ESTRUCTURA.NOMBREESTRUCTURA));
             listadoEstructuras.add(lasEstructuras);
         }
         conexion.close();
         return listadoEstructuras;
    }
    public List<EstructuraRecord> ConsultarEstructuraEspecifica (EstructuraRecord miEstructura) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
       
        ConectarBD con = new ConectarBD();
        List<EstructuraRecord>listadoEstructuras= new ArrayList<EstructuraRecord>();
        Connection conexion= con.realiza_conexion();
        DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(ESTRUCTURA).
                where(ESTRUCTURA.ESTRUCTURAID.equal(miEstructura.getEstructuraid()).
                        or(ESTRUCTURA.FORMULA.equal(miEstructura.getFormula()).
                                or(ESTRUCTURA.IDIOMAID.equal(miEstructura.getIdiomaid()))).
                        or(ESTRUCTURA.NOMBREESTRUCTURA.equal(miEstructura.getNombreestructura()))).fetch();
         for(Record r : result){
             EstructuraRecord lasEstructuras = new EstructuraRecord();
             lasEstructuras.setEstructuraid(r.getValue(ESTRUCTURA.ESTRUCTURAID));
             lasEstructuras.setFormula(r.getValue(ESTRUCTURA.FORMULA));
             lasEstructuras.setIdiomaid(r.getValue(ESTRUCTURA.IDIOMAID));
             lasEstructuras.setNombreestructura(r.getValue(ESTRUCTURA.NOMBREESTRUCTURA));
             listadoEstructuras.add(lasEstructuras);
         }
         conexion.close();
         return listadoEstructuras;
    }
    
    public boolean GrabarEstructura(EstructuraRecord miEstructura) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.insertInto(Estructura.ESTRUCTURA,Estructura.ESTRUCTURA.ESTRUCTURAID,Estructura.ESTRUCTURA.FORMULA,Estructura.ESTRUCTURA.IDIOMAID,Estructura.ESTRUCTURA.NOMBREESTRUCTURA)
                .values(miEstructura.getEstructuraid(),miEstructura.getFormula(),miEstructura.getIdiomaid(),miEstructura.getNombreestructura()).execute();
        conexion.close();
        return true;
    }
    
    public boolean ActualizarEstructura(EstructuraRecord miEstructura) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        ConectarBD con = new ConectarBD();
        Connection conexion = con.realiza_conexion();
	DSLContext create = DSL.using(conexion, SQLDialect.MYSQL);
        create.update(ESTRUCTURA).set(ESTRUCTURA.FORMULA,miEstructura.getFormula()).set(ESTRUCTURA.IDIOMAID,miEstructura.getIdiomaid()).set(ESTRUCTURA.NOMBREESTRUCTURA,miEstructura.getNombreestructura()).where(ESTRUCTURA.ESTRUCTURAID.equal(miEstructura.getEstructuraid())).execute();
        conexion.close();
        return true;
    }

}
