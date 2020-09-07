package ec.cjpq.core.model;

import javax.persistence.*;
import lombok.*;

import org.openxava.annotations.*;

/**
 * Core module
 * Role
 * @author carper
 * 2017-02-21
 */
@Entity
public class Role {

	@Id @Column(length=2) @ReadOnly @Getter @Setter
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short id;
	
	@Column(length=50) @Required @Getter @Setter
	private String description;
}
