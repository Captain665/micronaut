package v1.repositories;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import v1.models.AssetModel;
import v1.models.EmployeeModel;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface EmployeeRepository extends CrudRepository<EmployeeModel, Long> {
	@Join(value = "asset", type = Join.Type.LEFT_FETCH)
	@Join(value = "salary", type = Join.Type.LEFT_FETCH)
	List<EmployeeModel> findByCompanyId(Long companyId);
}
