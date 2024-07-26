package edu.icet.org.repository;

import edu.icet.org.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends CrudRepository<CustomerEntity,Long> {
     void deleteById(Long id) ;

}
