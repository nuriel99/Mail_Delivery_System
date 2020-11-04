package model;

import java.util.*;

public class QueuePerson 
{
	
	public static List <PersonDetails> list =new ArrayList <PersonDetails>();
	
	public static int numQueue=1;

	public static int numQueueOfEmployee=1; 
	
	public static void addPersonDetails(String id)
	{
		
		PersonDetails myDetails= new PersonDetails();
		myDetails.id=id;
		
		Date date= new Date();
		
		myDetails.startWaitInMinute=date.getMinutes();
		myDetails.startWaitInHour=date.getMinutes();
		 
		myDetails.inLine=numQueue;
		numQueue++;
		list.add(myDetails);
		
	}
	
	public static void prepareNext()
    {
		
		numQueueOfEmployee++;
		
	}
}




