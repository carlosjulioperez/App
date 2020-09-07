package ec.cjpq.cmc.model;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

import ec.cjpq.core.model.GeneralTable;

/**
 * CMC module
 * @author carper
 * 2017-01-29, 30
 * 2017-02-01, 2
 */
@Embeddable
public class FamilyBackground{

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@ReferenceView("Simple") @NoCreate @NoModify @Getter @Setter
	private Disease disease;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="value", condition="${name} = 'parent'" )
 	@NoCreate @NoModify @Getter @Setter
	private GeneralTable maternalOrPaternal;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@DescriptionsList(descriptionProperties="value", condition="${name} = 'familiar'" )
 	@NoCreate @NoModify @Getter @Setter
 	private GeneralTable familiar;

 }
