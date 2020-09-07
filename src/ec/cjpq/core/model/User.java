package ec.cjpq.core.model;

import java.util.*;
import javax.persistence.*;
import lombok.*;

import org.openxava.annotations.*;

/**
 * Core module
 * User 
 * @author carper
 * 2017-02-21
 * 2017-03-14 Master-Detail
 */
@Entity
public class User {

	@Id @Column(length=40) @Getter @Setter
	private String username;
	
	@Column(length=40) @Required @Getter @Setter
	private String password;
	
	@Column(length=1) @Required @Getter @Setter
	private short active;

	@OneToMany (mappedBy="user", cascade=CascadeType.ALL) @Getter @Setter
	@ListProperties("role.description")
	private Collection<Authorisation> authorisation;

}
