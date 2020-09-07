package ec.cjpq.cmc.actions;

import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;
 
import org.openxava.actions.*;
import org.openxava.jpa.XPersistence;
import org.openxava.model.*;
import org.openxava.util.*;
import org.openxava.validators.*;

import ec.cjpq.cmc.model.Prescription;
/**
 * Community Medical Center module
 * Prescription report action class
 * @author carper
 * 2017-02-10
 */
public class PrescriptionReportAction extends JasperReportBaseAction {

	private static Log log = LogFactory.getLog(PrescriptionReportAction.class);
	
	private Prescription prescription;

	public Map getParameters() throws Exception {
        Messages errores = MapFacade.validate("Prescription", getView().getValues());
        if (errores.contains()) throw new ValidationException(errores);
        Map parametros = new HashMap();
        //parametros.put("familia", getSubfamilia().getFamilia().getDescripcion());
        //parametros.put("subfamilia", getSubfamilia().getDescripcion());
        return parametros;
    }
	
	protected JRDataSource getDataSource() throws Exception {
		Vector collection = new Vector();
		collection.add( getPrescription() );
        return new JRBeanCollectionDataSource( collection );
    }
	
	protected String getJRXML() {
        return "prescription.jrxml"; // Para leer del classpath
        //return "/home/javi/Products.jrxml"; // Para leer del sistema de ficheros
    }

	private Prescription getPrescription() throws Exception {
		if (prescription == null){
			String id = getView().getValueString("id");
			prescription = (Prescription) XPersistence.getManager().find(Prescription.class, id);
		}
		return prescription;
	}
}
