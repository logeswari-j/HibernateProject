package main_package.hibernate;

import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DriverClass {

	private static Scanner scan = new Scanner(System.in);	

	public static void main( String[] args )
	{

		try 
		{
			Configuration config = new Configuration().configure().addAnnotatedClass(AirlineReservationSystem.class);
			SessionFactory sessionFact = config.buildSessionFactory(); 
			Session session = sessionFact.openSession();
			AirlineReservationSystem airlineobject = new AirlineReservationSystem();
			airlineobject.checkingcredentials();

			byte adminChoice ;
			do 
			{
				adminChoice = scan.nextByte();

				switch(adminChoice) 
				{

				case 1:

					airlineobject.createAirline(session);
					break;

				case 2:

					airlineobject.displayById(session);
					break;

				case 3:

					airlineobject.deleteById(session);
					break;

				case 4:

					airlineobject.updateById(session);
					break;

				case 5:

					airlineobject.toLogOut();
					break;

				}
			}
			while (adminChoice != 5) ;
			scan.close();
		}
		catch(HibernateException obj) 
		{

		}
		catch(Exception obj) 
		{

		}
	}	
}


