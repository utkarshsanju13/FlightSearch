package flightComparator;

import java.util.Comparator;

import model.FlightDetails;
/**
 * Sort the output list in increasing flight fare
 * @author utkarshgupta01
 *
 */
public class FareComparator implements Comparator<FlightDetails> {

	public int compare(FlightDetails o1, FlightDetails o2) {
		
		return o1.getFare() - o2.getFare();
	}
	
}
