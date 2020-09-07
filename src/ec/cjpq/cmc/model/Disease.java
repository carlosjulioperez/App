package ec.cjpq.cmc.model;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

/**
 * Community Medical Center module
 * Disease 
 * @author carper
 * 2017-02-01
 */
@Entity
@Table(name="DB29179_CIE10")
@View(name="Simple", members="id, description" )
public class Disease{
	
	@Id @Column(name="ID10", length=10) @Getter @Setter
	private String id;

	@Column(name="DEC10", length=400) @ReadOnly @Getter @Setter
	private String description;

	@Column(name="GRP10", length=200) @ReadOnly @Getter @Setter
	private String group;
}

