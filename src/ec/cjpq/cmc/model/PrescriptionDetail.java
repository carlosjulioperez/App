package ec.cjpq.cmc.model;

import java.math.*;
import java.util.Date;

import javax.persistence.*;
import lombok.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import ec.cjpq.core.model.GeneralTable;

/**
 * Community Medical Center module
 * Prescription detail entity
 * @author carper
 * 2017-01-25, 26
 * 2017-02-02
 */
@Entity
@Table(name = "PRESCRIPTION_DETAILS")
@View(members=
	"disease;" +
	"drugFormAndRoute [medicament, dietTherapeutic; drugForm; drugRoute];" +
	"dosage [dosis, doseUnit, quantity, medicationDosage];" +
	"treatmentTime [initialDate, treatmentDuration, frequencyUnit, totalUnits];" +
	"aditionalIndications"
)
public class PrescriptionDetail extends Identifiable{

	@ManyToOne @Getter @Setter //Sin lazy fetching porque falla al quitar un detalle desde el padre
	private Prescription prescription;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@ReferenceView("Simple") @NoCreate @NoModify @Getter @Setter //@NoFrame
	private Disease disease;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@DescriptionsList @Getter @Setter
	private Medicament medicament;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false) @NoCreate @NoModify @Getter @Setter
	@DescriptionsList(descriptionProperties="value", condition="${name} = 'diet.therapeutic'" )
	private GeneralTable dietTherapeutic;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false) @NoCreate @NoModify @Getter @Setter
	@DescriptionsList(descriptionProperties="value", condition="${name} = 'drug.form'" )
	private GeneralTable drugForm;

	@ManyToOne(fetch=FetchType.LAZY, optional=false) @NoCreate @NoModify @Getter @Setter
	@DescriptionsList(descriptionProperties="value", condition="${name} = 'drug.route'" )
	private GeneralTable drugRoute;
	
	@Digits(integer=3, fraction=2) @Required @Getter @Setter
	//@Column(length=6)
	private BigDecimal dosis;

	@ManyToOne(fetch=FetchType.LAZY, optional=false) @NoCreate @NoModify @Getter @Setter
	@DescriptionsList(descriptionProperties="value", condition="${name} = 'dose.unit'" )
	private GeneralTable doseUnit;

	@Column(length=3) @Required @Getter @Setter
	private short quantity;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false) @NoCreate @NoModify @Getter @Setter
	@DescriptionsList(descriptionProperties="value", condition="${name} = 'medication.dosage'" )
	private GeneralTable medicationDosage;
	
	@Required @Getter @Setter
	private Date initialDate;

	@Column(length=3) @Required @Getter @Setter
	private short treatmentDuration;

	@ManyToOne(fetch=FetchType.LAZY, optional=false) @NoCreate @NoModify @Getter @Setter
	@DescriptionsList(descriptionProperties="value", condition="${name} = 'frequency.unit'" )
	private GeneralTable frequencyUnit;
	
	@Column(length=3) @Required @Getter @Setter
	private short totalUnits;
	
	@Column(length=100) @Stereotype("TEXT_AREA") @Getter @Setter
	private String aditionalIndications;
}
