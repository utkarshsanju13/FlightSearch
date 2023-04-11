package input;

import java.io.*;

import validator.FlightValidator;

/**
 * Input from the user 
 * @author utkarshgupta01
 *
 */
public class UserInput {
	
	private UserInput() {
	}
	
	public static Parameters userInp() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String deptLocation;
		String arrivalLocation;
		String date;
		String flightClass;
		int choiceCode;
		
		FlightValidator validate = new FlightValidator();
		
		do {
			System.out.print("ENTER DEPARTURE LOCATION  : ");
			deptLocation = br.readLine().toUpperCase();
		} while (!validate.departLoc(deptLocation));

		do {
			System.out.print("ENTER ARRIVAL LOCATION  :");
			arrivalLocation = br.readLine().toUpperCase();
		} while (!validate.arrivalLoc(arrivalLocation));

		do {
			System.out.print("ENTER DATE  (DD-MM-YYYY) : ");
			date = br.readLine().toUpperCase();
		} while (!validate.flightDate(date));

		do {
			System.out.print("ENTER CLASS : (E or B) : ");
			flightClass = br.readLine().toUpperCase();
		} while (!validate.flightClass(flightClass));

		do {
			System.out.print(
					"ENTER OUTPUT PREFERENCES :   1. FARE \t 2. FLIGHT DURATION \nENTER PREFERENCE : ");
			choiceCode = Integer.parseInt(br.readLine());
		} while (choiceCode != 1 && choiceCode != 2);

		return new Parameters(deptLocation, arrivalLocation, date, flightClass, choiceCode);
		
	}

}
