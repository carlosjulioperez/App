package ec.cjpq.core.model;

import javax.persistence.*;
import lombok.*;

import org.openxava.annotations.*;

/**
 * Core module
 * Province
 * @author carper
 * 2017-02-01
 */
@Entity
public class Province {

	@Id @Column(length=2) @ReadOnly @Getter @Setter
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short id;
	
	@Column(length=50) @Required @Getter @Setter
	private String description;
}
