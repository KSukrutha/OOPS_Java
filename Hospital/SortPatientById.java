package customsorting;
	import java.util.Comparator;
	import hdbms.Patient;
	public class SortPatientById implements Comparator <Patient>{
		public int compare(Patient x, Patient y) {
			return x.getId().compareTo(y.getId());
		}

	}


