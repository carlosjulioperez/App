package ec.cjpq.core.model;

import javax.persistence.*;
import lombok.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

/**
 * Core module
 * General table entity
 * @author carper
 * 2017-01-30
 */
@Entity
@Table(name="GENERAL_TABLE")
public class GeneralTable{
	
	@Id @ReadOnly @Getter @Setter
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=100) @Required @Getter @Setter
	private String name;

	@Column(length=50) @Required @Getter @Setter
	private String value;
}
