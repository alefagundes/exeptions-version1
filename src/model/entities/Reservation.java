package model.entities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation(){
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		super();
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}


	public Date getCheckout() {
		return checkout;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}
	
	public long duration() {
		long diff = checkout.getTime()-checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void upDateDates(Date checkin, Date checkout) {
		this.checkout = checkout;
		this.checkin = checkin;
	}
	
	@Override
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Number Room:" + roomNumber + " ,");
		sb.append("check-in: " + sdf.format(checkin) + " ,");
		sb.append("check-out: " + sdf.format(checkout) + " ,");
		sb.append(" duration: " + duration() + " nights");
		return sb.toString();
	}
	
	

}