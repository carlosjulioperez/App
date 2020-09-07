package ec.cjpq.cmc.model;

import java.util.*;
import javax.persistence.*;
import lombok.*;

import org.openxava.annotations.*;

import ec.cjpq.core.model.GeneralTable;
import ec.cjpq.core.model.Person;

/**
 * Community Medical Center module
 * Patient entity
 * @author carper
 * 2016-09-16, 19, 20, 27
 * 2017-01-12, 15
 * 2017-01-30
 * 2017-02-01, 2, 3
 */
@Entity
@Tab(properties="id, person.id, person.surnames, person.names")
@Views({
	@View(members=
		"id;" + 
		"person, bloodType;" +
		"familyBackground {familyBackground}"
	),
	@View(name="Simple", members="id, fullName, bloodTypeValue")
})
public class Patient{
	
	@Id @ReadOnly(notForViews="Simple") @Getter @Setter
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@ReferenceView("Simple") @NoFrame @NoCreate @NoModify @Getter @Setter
	private Person person;

    public String getFullName(){
        return person.getFullName();
    }

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@LabelFormat(LabelFormatType.SMALL)	
	@DescriptionsList(descriptionProperties="value", condition="${name} = 'blood.type'" )
 	@NoCreate @NoModify @Getter @Setter
	private GeneralTable bloodType;

	@DisplaySize(value=3)	
    public String getBloodTypeValue(){
        return bloodType.getValue();
    }

	@ListProperties("disease.id, disease.description, maternalOrPaternal.value, familiar.value")
	@ElementCollection @Getter @Setter
	private Collection<FamilyBackground> familyBackground;

}
