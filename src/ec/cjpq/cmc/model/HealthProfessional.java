package ec.cjpq.cmc.model;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

import org.openxava.annotations.*;

import ec.cjpq.core.model.GeneralTable;
import ec.cjpq.core.model.Person;

/**
 * Community Medical Center module
 * Person entity
 * @author carper
 * 2016-09-17, 18, 19, 27
 * 2017-01-22 Groovy change
 * 2017-01-23
 * 2017-02-02, 3
 */
@Entity
@Table(name="HEALTH_PROFESSIONAL")
//@Tab(properties="person.id, person.surnames, person.names, person.occupation")
@Tab(properties="person.id, person.surnames, person.names")
public class HealthProfessional{

	@Id @ReadOnly
	@GeneratedValue(strategy=GenerationType.IDENTITY) @Getter @Setter
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@ReferenceView("Simple") @NoFrame @NoCreate @NoModify @Getter @Setter
	private Person person;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="value", condition="${name} = 'specialty'" )
 	@NoCreate @NoModify @Getter @Setter
	private GeneralTable specialty;

}
