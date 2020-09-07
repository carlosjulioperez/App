package ec.cjpq.cmc.model;

import javax.persistence.*;
import lombok.*;
import org.openxava.annotations.*;

import ec.cjpq.core.model.Canton;

/**
 * Community Medical Center module
 * Medical Center
 * @author carper
 * 2017-02-01
 */
@Entity
@Table(name="MEDICAL_CENTER")
public class CmcMedicalCenter {

	@Id @Column(length=3) @ReadOnly
	@GeneratedValue(strategy=GenerationType.IDENTITY) @Getter @Setter
	private short id;
	
	@Column(length=100) @Required @Getter @Setter
	private String description;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@DescriptionsList @Getter @Setter
	private Canton canton;

	@Column(length=200) @Required @Getter @Setter
	private String address;

	@Column(length=30) @Required @Getter @Setter
	private String phone;

}
