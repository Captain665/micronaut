package v1.repositories;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import v1.models.AssetModel;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface AssetRepository extends CrudRepository<AssetModel, Long> {
}
