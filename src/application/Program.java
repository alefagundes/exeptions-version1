package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number:");
		Integer roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy):");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Checkout date (dd/MM/yyyy):");
		Date checkout = sdf.parse(sc.next());
		
		
		if (!checkout.after(checkin)) {
			System.out.println("Check-our date must be after check-in date");
		}
		else {
			Reservation reserve = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reserve);
			
			System.out.println();
			System.out.println("Enter with the update checkin and checkout:");
			System.out.print("Check-in date (dd/MM/yyyy):");
			checkin = sdf.parse(sc.next());
			System.out.print("Checkout date (dd/MM/yyyy):");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in the Reservation: Reservation dates for the update must be future");
			}
			else if(checkin.before(now) || checkout.before(now)) {
			System.out.println("Error in reservation: check-out date mustbe after check-in date");	
			}
			else {
			reserve.upDateDates(checkin, checkout);
			System.out.println();
			System.out.println("Reservation: " + reserve);
		}
		
	}

}
}
