package ec.cjpq.parrot.sl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.jdbi.v3.core.Jdbi;

import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import org.junit.Test;

import ec.cjpq.parrot.sl.model.Employee;

public class EmployeeDaoTest{

    private static final Logger logger = LogManager.getLogger(EmployeeDaoTest.class);
    
    @Test
    public void dao(){

        Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/oymar", "postgres", "");
        jdbi.installPlugin(new SqlObjectPlugin());

        Employee employee = jdbi.withExtension(EmployeeDao.class, dao -> {
           return dao.getByLogin("carper"); 
        });

        logger.warn(employee.getName());
        logger.warn(employee.getP12Archivo() );
        logger.warn(employee.getP12Clave() );
        logger.warn(employee.getCodEstabl() );
    }
}
