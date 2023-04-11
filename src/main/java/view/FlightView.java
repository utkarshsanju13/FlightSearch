package view;

import java.util.List;

import model.FlightDetails;

/**
 * Final Output that user wants as per the inputs
 * @author utkarshgupta01
 * 
 */
public class FlightView {
	
	public void viewFlights(List <FlightDetails> flightList)
	{
			
			if (flightList.isEmpty()) {
				System.out.println("-------------------------------FLIGHT NOT AVAILABLE-----------------------------------------");
			}else {
				
				System.out.println("-----------------------------------AVAILABLE FLIGHTS--------------------------------------------");
				System.out.printf("\n|%-10s | %-28s |%-12s |%-15s |%-10s |%-8s|\n", "FLIGHT NO", "VALID TILL",
						"FLIGHT TIME", "FLIGHT DURATION", "FARE", "CLASS");
				
				for (FlightDetails flight : flightList) {
					
					System.out.printf("|%-10s | %-28s |%-12s |%-15s |%-10s |%-8s|\n", flight.getFlightNo(),
							flight.getValidTill(), flight.getFlightTime(),flight.getFlightDur(), flight.getFare(),
							flight.getClassAvailable());
					
				}
			}
		}
	}


