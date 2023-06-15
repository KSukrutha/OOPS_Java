package customsorting;
import java.util.Comparator;
import hdbms.Patient;

public class SortPatientByAge implements Comparator <Patient> {
	
	public int compare(Patient x,Patient y) {
		return x.getAge() -y.getAge();
	}
	

}
