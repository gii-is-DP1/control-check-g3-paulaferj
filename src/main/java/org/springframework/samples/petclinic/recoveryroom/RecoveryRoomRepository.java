package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    
	@Query("SELECT r from RecoveryRoom r")
	List<RecoveryRoom> findAll();

	@Query("SELECT r from RecoveryRoomType r")
	List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
	Optional<RecoveryRoom> findById(int id);
    
	RecoveryRoom save(RecoveryRoom p);
    
    @Query("SELECT r from RecoveryRoomType r WHERE r.name=:name")
    RecoveryRoomType getRecoveryRoomType(@Param("name") String name);
    
    @Query("SELECT r from RecoveryRoom r WHERE r.size>:size")
    List<RecoveryRoom> findBySizeMoreThan( @Param("size")double size);
}
