package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="recovery_room_type")
public class RecoveryRoomType extends BaseEntity{
    
	@Id
	Integer id;
	
	@NotNull
	@Size(min=5, max=50)
	@Column(name="name", unique =true)
    String name;
}
