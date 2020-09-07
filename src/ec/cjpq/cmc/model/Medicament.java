package ec.cjpq.cmc.model;

import javax.persistence.*;
import lombok.*;
import org.openxava.annotations.*;

/**
 * Community Medical Center module
 * Medicament
 * @author carper
 * 2017-01-24
 * 2017-02-02
 */
@Entity
@View(name="Simple", members="id, description" )
public class Medicament {

	@Id @Column(length=4) @ReadOnly
	@GeneratedValue(strategy=GenerationType.IDENTITY) @Getter @Setter
	private short id;
	
	@Column(length=60) @Required @Getter @Setter
	private String description;
}
