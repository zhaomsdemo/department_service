package orz.ootb.department.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import orz.ootb.department.model.Department;

@RepositoryRestResource
public interface DepartmentRepository extends CrudRepository<Department,String> {
}
