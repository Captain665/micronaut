package v1.repositorys;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import v1.models.CompanyModel;

import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyModel, Long> {
//	@Query("SELECT c FROM CompanyModel c WHERE c.id = :id")
	Optional<CompanyModel> findById(Long id);
}
