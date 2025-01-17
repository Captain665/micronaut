package v1.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import v1.models.CompanyModel;


@JdbcRepository(dialect = Dialect.POSTGRES)
public interface CompanyRepository extends CrudRepository<CompanyModel, Long> {
}
