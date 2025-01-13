package v1.repositories;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import v1.models.AssetModel;
import v1.models.EmployeeModel;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface EmployeeRepository extends CrudRepository<EmployeeModel, Long> {

	@Join(value = "asset", type = Join.Type.LEFT_FETCH)
	@Join(value = "salary", type = Join.Type.LEFT_FETCH)
	List<EmployeeModel> findByCompanyId(Long companyId);

	@Join(value = "asset", type = Join.Type.LEFT_FETCH)
	@Join(value = "salary", type = Join.Type.LEFT_FETCH)
	Optional<EmployeeModel> findByMobile(String mobile);

	@Transactional
	default EmployeeModel updateEmployeeDetails(EmployeeModel model) {
		return update(model);
	}

	@Transactional
	default EmployeeModel insertEmployeeInfo(EmployeeModel model) {
		return save(model);
	}

}
