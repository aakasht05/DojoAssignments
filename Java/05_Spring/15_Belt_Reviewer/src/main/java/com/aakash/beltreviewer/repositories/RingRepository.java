package com.tony.beltreviewer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tony.beltreviewer.models.Ring;

@Repository
public interface RingRepository extends CrudRepository<Ring,Long>{
	@Query(value="SELECT ring.id,ring.name FROM user JOIN users_roles ON user.id=users_roles.user_id JOIN role ON role.id=users_roles.role_id JOIN ring ON ring.user_id=user.id WHERE role.name = 'ROLE_ADMIN'",nativeQuery=true)	
	List<Object[]> ringsNotPickedUp();
	
	@Modifying
	@Query(value="DELETE FROM ring WHERE ring.user_id = ?1",nativeQuery=true)
	int deleteRingWhere(Long id);
}
