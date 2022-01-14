package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="recovery_room")
public class RecoveryRoom extends BaseEntity{
    
	@Id
	Integer id;
    
	@NotNull
	@Size(min=3, max=50)
	@Column(name="name")
	String name;
    
	@NotNull
	@Min(0)
	@Column(name="size")
	double size;
    
	@NotNull
	@Column(name="secure")
    boolean secure;
    
	@ManyToOne
    @JoinColumn(name= "recovery_room_type")
    @Transient
    RecoveryRoomType roomType;
}
