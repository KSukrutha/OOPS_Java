package customsorting;
import java.util.Comparator;
import hdbms.Patient;
public class SortPatientByTotalBill implements Comparator <Patient>{
	public int compare(Patient x, Patient y) {
		return x.getTotBill()- y.getTotBill();
	}

}
