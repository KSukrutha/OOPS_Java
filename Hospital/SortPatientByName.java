package customsorting;

	import java.util.Comparator;
	import hdbms.Patient;
	public class SortPatientByName implements Comparator <Patient>{
		public int compare(Patient x, Patient y) {
			return x.getName().compareTo(y.getName());
		}

	}




