package flightComparator;

import java.util.Comparator;

import model.FlightDetails;
/**
 * Sort the output list in increasing flight time duration
 * @author utkarshgupta01
 *
 */
public class DurationComparator implements Comparator<FlightDetails> {

	public int compare(FlightDetails o1, FlightDetails o2) {
		Double comp = (double) (o1.getFlightDur() - o2.getFlightDur());
		if (comp < 0)
			return -1;
		else if (comp > 0)
			return 1;
		else
			return 0;
	}

}
