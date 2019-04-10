package ec.cjpq.parrot.sl.dao;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import ec.cjpq.parrot.sl.model.Employee;

@RegisterBeanMapper(Employee.class)
public interface EmployeeDao {

    @SqlQuery("SELECT * FROM employee WHERE login = :login")
    Employee getByLogin(@Bind("login") String login);
}

