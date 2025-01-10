package v1.repositories;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import v1.models.EmployeeSalary;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface SalaryRepository extends CrudRepository<EmployeeSalary, Long> {
	
}
