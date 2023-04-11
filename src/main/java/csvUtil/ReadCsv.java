package csvUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import configuration.DBConfigure;
import model.FlightDetails;

/**
 * load csv data to DB
 * @author utkarshgupta01
 *
 */
public class ReadCsv implements Runnable {
	private static final String DIR = "Resources";
	private static List<String> listOfFile = new ArrayList<String>();
	static List<String> csvData = new ArrayList<String>();
	public static List<String> arr;
	private static BufferedReader br;

	public void run() {
	
			getAllFiles();
			readCSV();
			
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	}
	
	/**
	 * read all CSV files 
	 * @return list of files
	 */
	public static List<String> getAllFiles() {
		File folder = new File(DIR);
		
		for(File file : folder.listFiles()) {
			String name = file.getName();
			if(!listOfFile.contains(name)) {
				listOfFile.add(name);
			}
		}
		
		return listOfFile;
	}

	/**
	 * read CSV file content and save into DB
	 * @return 
	 */
	public static List<String> readCSV() {
		if(!listOfFile.isEmpty()) {
			
			for(int i = 0; i < listOfFile.size(); i++) {
				try {
					br = new BufferedReader(new FileReader(DIR + "/" + listOfFile.get(i)));
					
					String strLine = "";
					br.readLine();
					
					while((strLine = br.readLine()) != null) {
						
						if(!csvData.contains(strLine)) {
							
							StringTokenizer token = new StringTokenizer(strLine, "|");
							arr = new ArrayList<String>(strLine.length());
							
							while(token.hasMoreTokens()) {
								arr.add(token.nextToken());
							}
							Object[] objArr = arr.toArray();
							
							String[] str = Arrays.copyOf(objArr,objArr.length, String[].class);
							
							FlightDetails row = new FlightDetails();
							
							row.setFlightNo(str[0]);
							row.setDeptLoc(str[1]);
							row.setArrLoc(str[2]);
							
							Date date = new SimpleDateFormat("dd-MM-yyyy").parse(str[3]);
							row.setValidTill(date);
							row.setFlightTime(str[4]);
							
							row.setFlightDur(Float.parseFloat(str[5]));
							int fare = Integer.parseInt(str[6]);
							row.setSeatAvailable(str[7]);
							String classType = str[8];
							if(classType.equalsIgnoreCase("EB")) {
								classType = "B";
							}
							row.setClassAvailable(classType);
							if(classType.equalsIgnoreCase("B")) {
								fare *= 1.4; 
							}
							
							row.setFare(fare);
							
							SessionFactory sessionFactory = DBConfigure.getSessionFactory();
							Session session = sessionFactory.openSession();
							
							Transaction tnx = session.beginTransaction();
							
							session.save(row);
							tnx.commit();
							
							csvData.add(strLine);
						}
					}
						
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
		}
		return csvData;	
	}
}
