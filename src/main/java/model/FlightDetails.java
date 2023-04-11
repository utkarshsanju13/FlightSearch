package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FlightDetails {
	
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	private int serialNo;
	
	@Column(name = "FLIGHT_NO", unique = false, nullable = false)
	private String flightNo;
	@Column(name = "DEPATURE_LOC", unique = false, nullable = false)
	private String deptLoc;
	@Column(name = "ARRIVAL_LOC", unique = false, nullable = false)
	private String arrLoc;
	@Column(name = "VALID_TILL", unique = false, nullable = false)
	private Date validTill;
	@Column(name = "FLIGHT_TIME", unique = false, nullable = false)
	private String flightTime;
	@Column(name = "FLIGHT_DUR", unique = false, nullable = false)
	private float flightDur;
	@Column(name = "FARE", unique = false, nullable = false)
	private int fare;
	@Column(name = "SEAT_AVAILABLE", unique = false, nullable = false)
	private String seatAvailable;
	@Column(name = "CLASS_AVAILABLE", unique = false, nullable = false)
	private String classAvailable;
	
	public FlightDetails(String flightNo, String deptLoc, String arrLoc, Date validTill, 
							int fare, float flightDur, String classAvailable) {
		this.flightNo = flightNo;
		this.deptLoc = deptLoc;
		this.arrLoc = arrLoc;
		this.classAvailable = classAvailable;
		this.fare = fare;
		this.flightDur = flightDur;
		this.validTill = validTill;
		
	}

	public FlightDetails() {
		super();
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

	public String getArrLoc() {
		return arrLoc;
	}

	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public float getFlightDur() {
		return flightDur;
	}

	public void setFlightDur(float flightDur) {
		this.flightDur = flightDur;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public String getSeatAvailable() {
		return seatAvailable;
	}

	public void setSeatAvailable(String seatAvailable) {
		this.seatAvailable = seatAvailable;
	}

	public String getClassAvailable() {
		return classAvailable;
	}

	public void setClassAvailable(String classAvailable) {
		this.classAvailable = classAvailable;
	}
}
