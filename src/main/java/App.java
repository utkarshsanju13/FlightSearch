import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.FlightManager;
import csvUtil.ReadCsv;
import input.Parameters;
import input.UserInput;
import service.FolderWatcherService;

/**
 * 
 * @author utkarshgupta01
 *
 */
public class App {

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		int again;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Parameters para = new Parameters();
		
		do
		{
			
			FolderWatcherService watch = new FolderWatcherService();
			Thread watcher = new Thread(watch);
			watcher.start();
			
			ReadCsv read = new ReadCsv();
			Thread thread = new Thread(read);
			thread.start();
			
			
			Thread.sleep(2500);
		
			
			try {
				para = UserInput.userInp();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			FlightManager flightController = new FlightManager();
			
			flightController.searchFlight(para.getDepLoc(), para.getArrLoc(), para.getFlightDate(), para.getFlightClass(), para.getOutputPreference());
			
			flightController.updateView(para.getOutputPreference());
			
			
			
			System.out.println("PLEASE ENTER 1 TO SEARCH MORE FLIGHT");
			again = Integer.parseInt(br.readLine());
		
		}while(again == 1);
		
		
	}
}
