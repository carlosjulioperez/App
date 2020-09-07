package ec.cjpq.cmc.model;

import java.util.*;
import javax.persistence.*;
import lombok.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.model.*;

/**
 * Community Medical Center module
 * Prescription entity
 * @author carper
 * 2017-02-02, 3
 */
@Entity
@Tab(properties="date, patient.fullName, healthProfessional.person.surnames, healthProfessional.person.names")
@View(members="date, healthProfessional; patient; details")
public class Prescription extends Identifiable{

	@DefaultValueCalculator(CurrentDateCalculator.class)
	@Required @Getter @Setter
	private Date date;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@ReferenceView("Simple") @NoFrame @NoCreate @NoModify @Getter @Setter
	private Patient patient;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="person.fullName") @NoCreate @NoModify @Getter @Setter
	private HealthProfessional healthProfessional;

	@OneToMany (mappedBy="prescription", cascade=CascadeType.ALL) @Getter @Setter
	@ListProperties("totalUnits, medicament.description, disease.description, dosis, doseUnit.value, drugForm.value, medicationDosage.value, treatmentDuration, frequencyUnit.value")
	private Collection<PrescriptionDetail> details;

}
