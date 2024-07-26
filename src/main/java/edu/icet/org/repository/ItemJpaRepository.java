package edu.icet.org.repository;

import edu.icet.org.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemJpaRepository extends CrudRepository<ItemEntity,Long> {
}
