package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import configuration.DBConfigure;
import model.FlightDetails;

public class DatabaseManagerService {
	
	private DatabaseManagerService() {
	}
	/**
	 * get resultant list of flights
	 * @param deptLoc
	 * @param arrivalLoc
	 * @param date
	 * @param flightClass
	 * @param outPrefer
	 * @return
	 */
	public static List<FlightDetails> getList(String deptLoc, String arrivalLoc, Date date, String flightClass,
												int outPrefer){
		
		SessionFactory sessionFactory = DBConfigure.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria query = session.createCriteria(FlightDetails.class);
		query.add(Restrictions.eq("arrLoc",arrivalLoc));
		query.add(Restrictions.eq("deptLoc", deptLoc));
		query.add(Restrictions.like("classAvailable", flightClass,MatchMode.ANYWHERE));
		query.add(Restrictions.ge("validTill", date));
		query.add(Restrictions.eq("seatAvailable","Y"));
		query.addOrder(Order.asc("fare"));
	
		if(outPrefer == 2) {
			query.addOrder(Order.asc("flightDur"));
		}
		
		List<FlightDetails> list = new ArrayList<FlightDetails>();
		for (Object data : query.list()) {
			list.add((FlightDetails) data);
		}
		return list;
	}

}
