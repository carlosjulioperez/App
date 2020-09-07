package ec.cjpq.core.model;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

/**
 * Core module
 * @author carper
 * 2017-02-21
 * 2017-03-14 Master-Detail
 */
@Entity
@Table(name = "USER_AUTHORISATION")
public class Authorisation{
	
	@Id @Column(length=4) @ReadOnly @Getter @Setter
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short id;
	
	@ManyToOne @Getter @Setter //Sin lazy fetching porque falla al quitar un detalle desde el padre
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@DescriptionsList @Getter @Setter
 	private Role role;

}
