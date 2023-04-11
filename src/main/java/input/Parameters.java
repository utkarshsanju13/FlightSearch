package input;

/**
 * Base class for user input 
 * @author utkarshgupta01
 *
 */
public class Parameters {
	
	String depLoc;
	String arrLoc;
	String date;
	String flightClass;
	int outputPreference;
	
	public Parameters(String depLoc, String arrLoc, String date, String flightClass, int outputPreference) {
		this.depLoc = depLoc;
		this.arrLoc = arrLoc;
		this.date = date;
		this.flightClass = flightClass;
		this.outputPreference = outputPreference;
	}

	public Parameters() {

	}

	public String getDepLoc() {
		return depLoc;
	}

	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}

	public String getArrLoc() {
		return arrLoc;
	}

	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}

	public String getFlightDate() {
		return date;
	}

	public void setFlightDate(String flightDate) {
		this.date = flightDate;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public int getOutputPreference() {
		return outputPreference;
	}

	public void setOutputPreference(int outputPreference) {
		this.outputPreference = outputPreference;
	}
																		
	
}
