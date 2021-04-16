package com.rathika;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Arrays;
import java.util.Scanner;

public class CAB_single {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//Get mobile number and Password
		Long mobile_number,password;
		//Declaring Date and Time
		String date,time;
		System.out.println("Enetr Mobile Number: ");
		mobile_number =sc.nextLong();//Get Mobile Number
		
		System.out.println("Enter password");
		//String mobile_object = String.valueOf(mobile_number);//Convert Long into string 
		password = sc.nextLong();//Get password
		//Call Login_validation for validation
		boolean validate = Login_validation(mobile_number,password);
		if(validate == true) {
			System.out.println("Accepted");
		}
		else {
			System.out.println("Enter valid information");
			System.exit(0);
       }
		//Call Details methode to get car detail and choose cab type
		String type = Details();
		//Call billamount method to caluculate total for a particular cab
		int ans =  billamount(type);
		int gst_percentage = 7;
		//Call gst_Toatal to find amount including GST
		double gst = gst_Total(ans,gst_percentage);
		System.out.println("Enter Date of Birth");
		//Get Date and Time
		String dob = sc.next();
		System.out.println("Enter Journey date in the format of yyy-mm-dd");
		date = sc.next();
		//Call isDateExpired method to find is date is expired or not
		if(isDateExpired(date)) {
			
		}
		
		else {
			System.out.println("Invalid date");
			System.exit(0);
		}

		
		System.out.println("Enter pick up time in the format of HH-MM-SS");
		time = sc.next();
		//Call Time_Booking method to find is the date and time confrimed or not
		Time_Booking(date,time);
		//Call peek_Hours methode to add peek hour charge 
		double peek = Peek_Hours(date,time,gst);
		System.out.println("Total Amount depending on peek hour charge "+peek);
		//Call DOB method to calculate age
		int present_age = DOB(dob);
		System.out.println("Your age is "+present_age);
		if(present_age >= 60) {
			double percentage = 50;
			double Amount_discount = discount(peek,percentage);
			System.out.println("Total Amount "+Amount_discount);
		}
		else {
			System.out.println("Total Amount "+peek);
		}
		System.out.println("Enter card Number");
		long card_num = sc.nextLong();
		//Check is card number is valid
		if(isCardNumValid(card_num)) {
			System.out.println("Card Number is valid");
		}
		else {
			System.out.println("Invalid Card Number");
		}
		System.out.println("Enter card expiredate");
		String cdate = sc.next();
		//Check is Date is expired or not
		if(isDateExpired(cdate)) {
			System.out.println("Enter a amount");
			int amo = sc.nextInt();
			System.out.println("Thank you for booking");
		}
		
		else {
			System.out.println("Expired Date");
		}
		
		
		
		

	}
	/*
	 *Validating mobile number and password
	 *mobile number must be 10 digit number
	 *password must be the 8 digit number
	*/
	public static boolean Login_validation(long mobile,long password) {
		boolean validation = true;
		String mobile_object = String.valueOf(mobile);//Convert long into a String
		String password_object = String.valueOf(password);//Convert Long into a string
		if(password_object.length()==8 && password_object!=null && mobile_object!=null && mobile_object.length()==10) 
		{
		    validation = true;
			
		}
		else {
			validation = false;
		}
		return validation;
		
	}
	/*
	 *View the CAB types and the amount charged per kilometer
	 *Get the CAB type from user like MICRO,MINI,PRIME
	*/
	public static String Details() {
		Scanner sc = new Scanner(System.in);
		int KiloMeter1,ans1;
		String date,time;
		String Cab_Type1 = "MICRO";
		String Cab_Type2 = "MINI";
		String Cab_Type3 = "PRIME";
		String CabTypes[] = new String[3];
		CabTypes[0] = "MICRO";
		CabTypes[1] = "MINI";
		CabTypes[2] = "PRIME";
		System.out.println("Number of Cab types: "+CabTypes.length);
		//Display Number of cabs available
		System.out.println("Cab Names: "+ Arrays.toString(CabTypes));
		//Display Cab Names
		System.out.println("Enter cab type you want");
		//Get the cab that coustumer want
		String type =sc.next();
		if(type.equals(Cab_Type1)) {  //MICRO cab details
			System.out.println("MICRO CABS-10RS/KM");
		}
		else if(type.equals(Cab_Type2)) {  //MINI cab details
			System.out.println("MINI CABS-15RS/KM");
		}
		else if(type.equals(Cab_Type3)) {  //PRIME cab details
			System.out.println("PRIME CABS-20RS/KM"); 
		}
		else {      //Invalid input type
			System.out.println("Invalid Cab Type");
			System.exit(0);
		}
		return type;
		
	}
	/*
	 *Calculate the amount for particular CAB using kilometer
	*/
	public static int billamount(String type) {
		Scanner sc = new Scanner(System.in);
		int KiloMeter1,ans1=0     ;
		String date,time;
		String Cab_Type1 = "MICRO";
		String Cab_Type2 = "MINI";
		String Cab_Type3 = "PRIME";
		String CabTypes[] = new String[3];
		CabTypes[0] = "MICRO";
		CabTypes[1] = "MINI";
		CabTypes[2] = "PRIME";
		//System.out.println("Enetr cab type: ");
		//String type = sc.next();
		     
		if(type.equals(Cab_Type1)) {  //Find bill for MICRO CAB
			//System.out.println("MICRO CABS-10RS/KM");
			System.out.println("Enter number of kiloMeter:");
			//System.out.println("Enter number of kiloMeter:");
			KiloMeter1 = sc.nextInt();// get kilometer
			ans1 = KiloMeter1*10;
			System.out.println("Total amount is: "+ans1);
		}
		else if(type.equals(Cab_Type2)) {    //Find bill for MINI CAB
			//System.out.println("MINI CABS-15RS/KM");
			System.out.println("Enter number of kiloMeter:");
			KiloMeter1 = sc.nextInt();// get kilometer
			ans1 = KiloMeter1*15; //Calculate amount for type2 cab
			System.out.println("Total amount is: "+ans1);
			
		}
		else if(type.equals(Cab_Type3)) {   //Find the bill for PRIME CAB
			//System.out.println("PRIME CABS-20RS/KM"); 
			System.out.println("Enter number of kiloMeter:");
			KiloMeter1 = sc.nextInt();// get kilometer
			ans1 = KiloMeter1*20;//Calculate amount for type3 cab
			System.out.println("Total amount is: "+ans1);

		}
		else {   //Invalid Input
			System.out.println("Invalid Type");
			System.exit(0);
		}
		return ans1;
	}
	/*
	 *Add GST for the CAB charge 
	 *7% GST for CAB
	*/
	public static double gst_Total(int ans1,int percentage) {
		double GST = (ans1+(ans1*(percentage/100)));
		return GST;   
	}
	public static void Time_Booking(String date,String time){ //Book Time
		LocalDate jdate = LocalDate.parse(date); //Parse given date
		LocalTime ptime = LocalTime.parse(time); //parse given time
		LocalDate tdate = LocalDate.now(); //get local date
		LocalTime ttime = LocalTime.now(); //get local time
		if(jdate.isAfter(tdate) && ptime.isAfter(ttime)) {
			System.out.println("Confrim your journey date and time");
		}
		else {
			System.out.println("Invalid Date or Time");
			//Time_Booking(date,time);
			System.exit(0);
			
		}
		
	}
	/*
	 *To find whether the booking time is peek hour or not
	 *Find extra charge for the peek time booking
	 *For peek hours 1.25% charge will be added
	*/
	public static double Peek_Hours(String date,String time,double GST){
    	double finalans;
    	LocalDate jdate = LocalDate.parse(date);
		LocalTime ptime = LocalTime.parse(time);
		LocalDate tdate = LocalDate.now();
		LocalTime ttime = LocalTime.now();
		LocalTime dropTime = LocalTime.parse(time);
		int hour = dropTime.getHour();
		if(hour>=17 && hour<=19) {
			System.out.println("Peek hours");
			finalans = (GST+(GST*0.00125));

		}
		else {
		   finalans = GST;
		}
		return finalans;
	}
	/*
	 *Find age using Date of birth
	*/
	public static int DOB(String dob) {
		LocalDate ldate = LocalDate.now(); //get present date
		LocalDate mydob = LocalDate.parse(dob); //parse given date of birth
		Period p = Period.between(mydob,ldate); //find difference between present date and dob
		int age = p.getYears();
		return age;
		
	}
	/*
	 *Add discount to the total amount for seniour citizen
	*/
	public static double discount(double finalans,double percentage)
	{
		
		double senior = (finalans-(finalans*(percentage/100)));
		System.out.println("You are a seniour citizen");
	    System.out.println("****50% offer****");
		//System.out.println("Total Amount includes peek hours charge 1.25%: "+finalans);
		//System.out.println("BILL AMOUNT: "+senior);
		
		return senior;
	}
	/*
	 *Verify the date which is expired or not
	*/
	public static boolean isDateExpired(String date) {
		LocalDate edate = LocalDate.parse(date);
		LocalDate today = LocalDate.now();
		boolean e_date = true;
		if(edate.isBefore(today)) {
			e_date = false;			
		}
		else {
			e_date = true;		
			}
		return e_date;
		
	}
	/*
	 *Validating the card number
	 *card number must have the 12 digit number
	*/
	public static boolean isCardNumValid(long card_number) {
		String cNum = String.valueOf(card_number);
		boolean valid = true;
		if(cNum.length()==12 && cNum!=null) {
			valid = true;
		}
		else {
			valid = false;
		}
		return valid;
	}
}

