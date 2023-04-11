package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import flightComparator.DurationComparator;
import flightComparator.FareComparator;
import model.FlightDetails;
import service.DatabaseManagerService;
import view.FlightView;

/**
 *
 * @author utkarshgupta01
 *
 */
public class FlightManager {
	List<FlightDetails> flightList = new ArrayList<FlightDetails>();
	ArrayList<String> arr;
	
	/**
	 * search flight
	 * @param deptLoc
	 * @param arrivalLoc
	 * @param date
	 * @param fligtClass
	 * @param outputPreference
	 */
	public void searchFlight(String deptLoc, String arrivalLoc, String date, String fligtClass, int outputPreference) {

		try {
				Date inputDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
				List<FlightDetails> list = DatabaseManagerService.getList(deptLoc, arrivalLoc, inputDate, fligtClass, outputPreference);
				
				for(FlightDetails data: list) {
					flightList.add(data);
				}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
		
	/**
	 * output preference according to user's choice
	 * @param choiceCode
	 */
	public void updateView(int choiceCode) {
		if(choiceCode == 1) {
			Collections.sort(flightList, new FareComparator());
		}else if(choiceCode == 2) {
			Collections.sort(flightList, new DurationComparator());
		}else {
			System.out.println("Wrong Choice : ");
			return;
		}
		
		FlightView view = new FlightView();
		view.viewFlights(flightList);
	}
}
