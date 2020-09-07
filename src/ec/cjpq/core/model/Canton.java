package ec.cjpq.core.model;

import javax.persistence.*;
import lombok.*;

import org.openxava.annotations.*;

/**
 * Core module
 * Canton 
 * @author carper
 * 2017-02-01
 */
@Entity
public class Canton {
	
	@Id @Column(length=3) @ReadOnly @Getter @Setter
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short id;
	
	@Column(length=50) @Required @Getter @Setter
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@DescriptionsList @Getter @Setter
	private Province province;
}

