package main_package.hibernate;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DynamicUpdate
public class AirlineReservationSystem {

	private static  Scanner constant = new Scanner(System.in);	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer airline_Id;

	@Column(name = "airline_name", length = 20, nullable = false)
	private String airline_Name;

	@Column(name = "airline_origin", unique = true)
	private String origin;

	@Column(name = "airline_destination", unique = true)
	private String destination;

	private Integer seating_availability;

	private Integer fare;

	public  void loginDetails(String admin_name,String admin_password) 
	{
		if(admin_name.equals("ROYAL") && admin_password.equals("Logu0499@" ))  
		{
			System.out.println("\nYOU HAVE SUCCESSFULLY LOGGED IN..");
			System.out.println("\n..........| WELCOME TO ROYAL AIRLINES |..........\n");
			//These statement are used to get the input from the user to perform the followings.
			System.out.println(" * TO ADD AN AIRLINE      --> PRESS 1");
			System.out.println(" * TO SEARCH AN AIRLINE   --> PRESS 2");
			System.out.println(" * TO DELETE AN AIRLINE   --> PRESS 3");
			System.out.println(" * TO UPDATE AN AIRLINE   --> PRESS 4");
			System.out.println(" * TO LOGOUT              --> PRESS 5");

		}
		else
		{
			System.out.println("\nPLEASE CHECK YOUR CREDENTIALS");
			checkingcredentials();
		}
	}
	public void checkingcredentials() {

		System.out.print("\nENTER THE ADMIN NAME: ");
		String admin_name = constant.next();

		System.out.print("\nENTER THE ADMIN PASSWORD: ");
		String admin_password = constant.next();

		loginDetails(admin_name,admin_password);
	}
	public void toLogOut() {

		System.out.println("Logged out successfully.");

	}

	public void createAirline(Session session) {

		session.beginTransaction();
		@SuppressWarnings("deprecation")
		Integer id = (Integer) session.save(getAirlineReservationSystem());
		System.out.println("Airline is created with id :"+id);
		session.getTransaction().commit();

	}
	public AirlineReservationSystem getAirlineReservationSystem() {

		AirlineReservationSystem airline = new AirlineReservationSystem();

		System.out.println("ENTER THE AIRLINE_NAME:");
		String airline_Name = constant.next();
		airline.setAirline_Name(airline_Name);
		System.out.println("ENTER THE AIRLINE_ORIGIN:");
		String origin = constant.next();
		airline.setOrigin(origin);
		System.out.println("ENTER THE AIRLINE_DESTINATION:");
		String destination = constant.next();
		airline.setDestination(destination);
		System.out.println("ENTER THE AIRLINE_SEATING_CAPACITY:");
		Integer availability = constant.nextInt();
		airline.setSeating_availability(availability);
		System.out.println("ENTER THE AIRLINE_FARE:");
		Integer fare = constant.nextInt();
		airline.setFare(fare);

		return airline;

	}
	public void deleteById(Session session) {
		System.out.println("Enter the Airline_id:");
		int airlineId = constant.nextInt();
		AirlineReservationSystem airline = session.get(AirlineReservationSystem.class,airlineId);

		if(airline != null) {
			session.beginTransaction();
			session.remove(airline);
			session.getTransaction().commit();
			System.out.println("Airline Detail is deleted successfully. ");
		}
		else {
			System.out.println("Airline id does not exist");

		}	
	}
	public void updateById(Session session) {
		System.out.println("Enter the Airline_id:");
		int airlineId = constant.nextInt();

		AirlineReservationSystem airline = session.get(AirlineReservationSystem.class,airlineId);
		if(airline != null) {
			session.beginTransaction();
			System.out.println("ENTER THE AIRLINE_ORIGIN TO UPDATE :");
			String origin = constant.next();
			airline.setOrigin(origin);
			System.out.println("ENTER THE AIRLINE_DESTINATION TO UPDATE:");
			String destination = constant.next();
			airline.setDestination(destination);
			System.out.println("ENTER THE AIRLINE_SEATING_CAPACITY TO UPDATE:");
			Integer availability = constant.nextInt();
			airline.setSeating_availability(availability);
			System.out.println("ENTER THE FARE TO UPDATE:");
			Integer fare = constant.nextInt();
			airline.setFare(fare);
			//airline.setOrigin(constant.next());
			
			session.persist(airline);
			session.getTransaction().commit();
			System.out.println("AIRLINE DETAILS ARE UPDATED ");
		}
		else {
			System.out.println("Airline id does not exist");

		}	
	}
	public void displayById(Session session){
		System.out.println("Enter the Airline_id:");
		int airlineId = constant.nextInt();
		AirlineReservationSystem airline = session.get(AirlineReservationSystem.class,airlineId);
		if(airline != null) {
			System.out.println(airline);
		}
		else {
			System.out.println("Airline id does not exist");

		}
	}

	/*getter and setters */
	public Integer getAirline_Id() {
		return airline_Id;
	}

	public void setAirline_Id(Integer airline_Id) {
		this.airline_Id = airline_Id;
	}

	public String getAirline_Name() {
		return airline_Name;
	}

	public void setAirline_Name(String airline_Name) {
		this.airline_Name = airline_Name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getSeating_availability() {
		return seating_availability;
	}

	public void setSeating_availability(Integer seating_availability) {
		this.seating_availability = seating_availability;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "AirlineReservationSystem [airline_Id=" + airline_Id + ", airline_Name=" + airline_Name + ", origin="
				+ origin + ", destination=" + destination + ", seating_availability=" + seating_availability + ", fare="
				+ fare + "]";
	}
}

