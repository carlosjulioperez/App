package ec.cjpq.core.model;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

import org.openxava.annotations.*;
//import org.openxava.calculators.*

import org.joda.time.LocalDate;
import org.joda.time.Years;

/**
 * Core module
 * Person entity
 * @author carper
 * 2016-09-14, 18, 27
 * 2016-10-01 getAge()
 * 2017-01-22 Groovy change
 * 2017-01-29
 * 2017-02-01
 */
@Entity
@Tab(properties="id, surnames, names")
@Views({
	@View(members=
		"id, surnames, names, occupation; gender, birthDate;" +
		"canton, address; phone, cellPhone; email"
	),
	@View(name="Simple", members="id, fullName, occupation, age" )
})
public class Person{
	
	@LabelFormat(LabelFormatType.SMALL)	
	@Id @Column(length=10) @Getter @Setter
	private String id;

	@LabelFormat(LabelFormatType.SMALL)	
	@Column(length=40) @Required @Getter @Setter
	private String names;
	
	@LabelFormat(LabelFormatType.SMALL)	
	@Column(length=40) @Required @Getter @Setter
	private String surnames;
	
	@LabelFormat(LabelFormatType.SMALL)
    public String getFullName(){
		//def s1 = ( secondSurName ?: '' ) + ' '
		//def s2 = ( secondName ?: '' ) + ' '
        return surnames + ' ' + names;
    }
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="value", condition="${name} = 'gender'" )
 	@NoCreate @NoModify @Getter @Setter
	private GeneralTable gender;

	//@DefaultValueCalculator(CurrentDateCalculator.class)
	@Column(name="BIRTH_DATE") @Required @Getter @Setter
	private Date birthDate;

	@LabelFormat(LabelFormatType.SMALL)	@DisplaySize(3)
	public int getAge(){
		LocalDate localBirthDate = new LocalDate (birthDate);
		LocalDate localDateNow = new LocalDate();
		Years age = Years.yearsBetween(localBirthDate , localDateNow);
		return age.getYears();
	}

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@DescriptionsList @NoCreate @NoModify @Getter @Setter
	private Canton canton;

	@Column(length=200) @Required @Getter @Setter
	private String address;
	
	@LabelFormat(LabelFormatType.SMALL)	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="value", condition="${name} = 'occupation'" )
 	@NoCreate @NoModify @Getter @Setter
	private GeneralTable occupation;

	@Column(length=30) @Required @Getter @Setter
	private String phone;

	@Column(name="CELL_PHONE", length=30) @Required @Getter @Setter
	private String cellPhone;

	@Column(length=100, unique=true) @Stereotype("EMAIL") @Required @Getter @Setter
	private String email;
}
