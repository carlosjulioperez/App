package ec.cjpq.core.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import ec.cjpq.cmc.model.HealthProfessional;
import ec.cjpq.cmc.model.Medicament;
import ec.cjpq.cmc.model.Patient;
import ec.cjpq.cmc.model.Prescription;
import ec.cjpq.cmc.model.PrescriptionDetail;
import ec.cjpq.core.model.GeneralTable;
import ec.cjpq.core.model.Person;

/**
 * Community Medical Center module
 * JRDataSourceFactory utility class
 * @author carper
 * 2017-02-09
 */
public class JRDataSourceFactory {

	private static GeneralTable getGeneralTable(String value){
		GeneralTable generalTable = new GeneralTable();
		generalTable.setValue(value);
		return generalTable;
	}

	private static Date getDate(String value){
		Date date = null;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			date = sdf.parse(value);
		}catch(Exception e){
			e.printStackTrace();
		}
		return date;
	}

	private static Person getPerson(String id, String surnames, String names, String birthDate, String occupation){
		Person person = new Person();	
		person.setId(id);
		person.setSurnames(surnames);
		person.setNames(names);
		person.setBirthDate(getDate(birthDate));
		person.setOccupation( getGeneralTable(occupation) );
		return person;
	}
	
	private static Prescription getPrescription(){
		Prescription prescription = new Prescription();

		prescription.setDate ( getDate("09/02/2017") );

		Patient patient = new Patient();
		patient.setPerson(getPerson("0918056664", "Pérez Quizhpe", "Carlos Julio", "03/03/1979", "Arquitecto de software"));
		prescription.setPatient(patient);

		HealthProfessional healthProfessional = new HealthProfessional();
		healthProfessional.setPerson(getPerson("1234567890", "Loor", "Lorena", "01/01/1979", "Doctor (Médico)"));
		prescription.setHealthProfessional(healthProfessional);

		PrescriptionDetail pd = new PrescriptionDetail();
		pd.setTotalUnits((short)10);
		
		Medicament medicament = new Medicament();
		medicament.setDescription("Aspirina");
		pd.setMedicament(medicament);

		pd.setDosis(new BigDecimal("250.56"));

		pd.setDoseUnit (getGeneralTable("mg."));
		pd.setDrugForm (getGeneralTable("Polvo para suspensión de liberación controlada"));
		pd.setDrugRoute (getGeneralTable("Bucal"));
		pd.setMedicationDosage (getGeneralTable("1 vez al día por la mañana"));
		pd.setTreatmentDuration((short)10);
		pd.setFrequencyUnit (getGeneralTable("cuando sea necesario"));
		pd.setDietTherapeutic (getGeneralTable("Dieta Líquida / Sin azúcares concentrados"));
		pd.setInitialDate ( getDate("13/02/2017") );

		Collection<PrescriptionDetail> details = new ArrayList<PrescriptionDetail>();
		details.add(pd);
		prescription.setDetails(details);

		return prescription;
	}
	
	public static Collection createBeanCollection(){
		Vector collection = new Vector();
		collection.add( getPrescription() );
		return collection;
	}
}
