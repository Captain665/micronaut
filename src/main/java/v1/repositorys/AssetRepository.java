package v1.repositorys;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import v1.models.AssetModel;

@Repository
public interface AssetRepository extends CrudRepository<AssetModel, Long> {
}
