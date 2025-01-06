package v1.repositorys;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import v1.models.EmployeeModel;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, Long> {
}
