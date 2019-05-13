/*
 * Written by Sandy Grayson-s3364895, Kimberley Thomson-s3427286,and
 * Boruch Shmaya Grossbaum-s3549187 for
 * Cinco Ticketing Console-Based Software Project, RMIT CPT330 SEPM SP1 2019
 * File created 19 April 2019
 * Version 2.0 uploaded 10 May 2019
 *
 * Copyright (C) 2019
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class PepPepTicket {	

	// Instance variables - defines attributes (fields) of objects
	// Private fields only accessed by other methods in the class
	// Static variables have the same value for every object
	// Protected means that this value can only be accessed by other code
	static Scanner userInput = new Scanner(System.in);
	// Create Pep-Pep Ticket ArrayList of arrays
	private static ArrayList<PepPepTicket[][]> ticketList = new ArrayList<PepPepTicket[][]>();
	// Declare object count
	private static int ticketCount = 0;	
	private static long ticketID;
	private static int targetID;
	private static double ticketCost = 8;
	private static double balance = 0;
	private static double credit;
	private static int transactionID = 1000;
	protected static int numberOfTickets = 0;
	protected static int numberOfTransacations = 0;
	private static int transactionCount = 0;
	private static String pass1 = "2 Hour Zone 1 Pass";
	private static String pass2 = "2 Hour Zones 1 & 2 Pass";
	private static String pass3 = "All Day Zone 1 Pass";
	private static String pass4 = "All Day Zones 1 & 2 Pass";
	private static double pass1Cost = 3.50;
	private static double pass2Cost = 6.00;
	private static double pass3Cost = 7.00;
	private static double pass4Cost = 12.00;
	static String pass = pass1;
	static double charge = pass1Cost;
	static Date transactionDate = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat ("hh:mm:ss a z, E dd.MM.yyyy");
	static int i = 0;
	int j = 0;
	
	public static ArrayList<PepPepTicket[][]> getTicketList(long ticketID, double balance, int transactionID, 
			Date transactionDate, String pass, double passCost, double charge) {
		PepPepTicket.ticketID = ticketID;
	    PepPepTicket.balance = balance;
	    PepPepTicket.transactionID = transactionID;
	    PepPepTicket.transactionDate = transactionDate;
	    PepPepTicket.pass = pass;
	    PepPepTicket.charge = charge;
		return ticketList;
	}


	// Constructor
	public PepPepTicket(int ticketCount, long ticketID, double balance) {
		PepPepTicket.ticketID = ticketID;
	    PepPepTicket.balance = balance;
	}
	
	// Accessor/Getter for ticket ID
	public static long getTicketID() {
		return ticketID;
	}
	
	// Method overloading allows different input to be accepted into the same method name
	public void setTicketID(long ticketID) {
		PepPepTicket.ticketID = ticketID;
	}
	
	public static long setTicketID() {
		long minNumber = 100000;
		long maxNumber = 1000000;
		
		// Generate a random number between 100000 and 1000000
		PepPepTicket.ticketID = minNumber + (long)(Math.random() * ((maxNumber - minNumber) + 1));
		return ticketID;
	}
	
	// Accessor/Getter for balance
	public static double getBalance() {
		return balance;
	}
	
	// Setter for balance
	public void setBalance(double balance) {
		PepPepTicket.balance = balance;
	}
	
	// Accessor/Getter for transaction ID
	public long getTransactionID() {
		return transactionID;
	}
	
	// Method overloading allows different input to be accepted into the same method name
	public void setTransactionID(int transactionID) {
		PepPepTicket.transactionID = transactionID;
	}
	
	// Accessor/Getter for credit
	public double getCredit(){
		return credit;
	}
	
	// Accessor/Getter for pass1Cost
	public double getPass1Cost() {
		return pass1Cost;
	}
	
	// Accessor/Getter for pass2Cost
	public double getPass2Cost() {
		return pass2Cost;
	}
				
	// Accessor/Getter for pass3Cost
	public double getPass3Cost() {
		return pass3Cost;
	}
	
	// Accessor/Getter for pass4Cost
	public double getPass4Cost() {
		return pass4Cost;
	}
	
	// Getter for transaction count
	public static int getTransactionCount() {
		return transactionCount;
	}

	// Setter for transaction count
	public static void setTransactionCount(int transactionCount) {
		PepPepTicket.transactionCount = transactionCount;
	}

	// Getter for transaction date
	public static Date getTransactionDate() {
		return transactionDate;
	}

	// Setter for transaction date
	public static void setTransactionDate(Date transactionDate) {
		PepPepTicket.transactionDate = transactionDate;
	}
	
	// Method for purchasing a Pep-Pep Ticket
	private static void purchaseTicket() {
		System.out.println();
		System.out.println("PEP-PEP TICKET INFORMATION:");
		System.out.println("--------------------------");
		System.out.println();
		System.out.println("Cost of a Pep-Pep Ticket is $8, starting balance will be $0.");
		System.out.println("Add credits to buy travel passes.");
		System.out.println("\n");
		System.out.println("Y - Continue to purchase Pep-Pep Ticket");
		System.out.println("N - Cancel to return to main menu");
		System.out.println("\n");
		System.out.print("Enter your selection: ");	
		
		String purchaseSelection = userInput.nextLine();
		purchaseSelection = purchaseSelection.toUpperCase();
		
		while  (!purchaseSelection.contentEquals("Y") && !purchaseSelection.contentEquals("N")) {
			System.out.println("Error: purchase selection must be Y or N! Please try again.");
			break;			
		}
		
		if (purchaseSelection.contentEquals("Y")) {
			System.out.print("Please enter payment amount:  $");
			try {
				ticketCost = userInput.nextInt();
				System.out.println();					
				while (ticketCost != 8) {
					System.out.println("Amount invalid, please try again.");
					System.out.print("Please re-enter payment amount:  $");
					ticketCost = userInput.nextInt();
					System.out.println();				
				}
				if (ticketCost == 8) {
					System.out.println("Pep-Pep Ticket purchase successful!");
					System.out.print("Your Ticket ID is: " + setTicketID() + ". ");
					System.out.printf("Current ticket credit balance is: $%.2f", balance = 0, ".");
					System.out.println();
					System.out.println("Thank you, please take your ticket.");
					System.out.println();
				
					// Create new Pep-Pep Ticket and store it in array
					//ticketList.add(new PepPepTicket(ticketID, balance));
					//ticketCount++;
					// This for loop is for testing the array list
					for (ticketCount = 0; ticketCount <= ticketList.size(); ticketCount++) {
						System.out.println("(Ticket " + ticketID + " is stored at array position: "+ PepPepTicket.ticketCount + ")");
						System.out.println();
						ticketCount++;
						break;
					}
				}
			}
			catch (InputMismatchException exception) {
				System.out.println("That is not an integer!");
				return;
			}
			// Clears any trailing lines, so doesn't interfere with next entry;
			userInput.nextLine();
		}		
		
		else if (purchaseSelection.contentEquals("N")) {
			System.out.println("No purchase made, returning to Main Menu ... ");
			return;
		}
	}
	

	// Method for adding credit to the Pep-Pep Ticket
	private static void addCredits() {
		System.out.println();
		System.out.println("ADD CREDITS INFORMATION:");
		System.out.println("-----------------------");
		System.out.println();
		System.out.println("Credits are required to be able to purchase Travel Passes.");
		System.out.println("Credit amounts must be in multiples of $5.");
		System.out.println("Ticket credit limit is $100 in total.");
		System.out.println();
		System.out.println("Y - Continue to add credit Pep-Pep Ticket");
		System.out.println("N - Cancel to return to main menu");
		System.out.println("\n");        			  
		System.out.print("Enter your selection: ");
		
		String optionSelection = userInput.nextLine();
		optionSelection = optionSelection.toUpperCase();
		
		// Set temporary reference to null (acts as a "not found" signal)
		PepPepTicket[][] temp = null;
		
		while (!optionSelection.contentEquals("Y") && !optionSelection.contentEquals("N")) {
			System.out.println();
			System.out.println("Error - invalid selection, feature exited!");
			break;
		}
		
		if (optionSelection.contentEquals("Y")) {
			try {
				System.out.println();
				// Prompt user to enter target Pep-Pep Ticket ID to search for
				System.out.print("Please enter your ticket ID: ");
				targetID = userInput.nextInt();			
			
				// Uses array length to control the search loop to find a match
				for (int i = 0; i < ticketCount && temp == null; i++) {
				
					// Check the current ticket to see if it has the ID specified by the user
					if (ticketID == targetID) {
						// Attach temp reference to matching PepPepTicket object
						temp = ticketList.get(i);
					}
				}
			
				// Check to see if search was unsuccessful
				if (temp == null) {
					System.out.println("Pep-Pep Ticket ID \"" + targetID + "\" not found!");
					// Consume trailing new line
					userInput.nextLine();
				}
				else {
					// Matching PepPepTicket object found, so prompt the user to enter the credit amount
					System.out.println();
					System.out.print("Matching ticket ID found! ");
					System.out.printf("The current credit balance on your ticket is: $%.2f", balance, ".");
					System.out.println();
					System.out.print("Enter an amount to credit: $");
					credit = userInput.nextDouble();
				
					// Consume trailing new line
					userInput.nextLine();
				
					// Credit specified amount to the matching ticket
					while ((credit % 5 != 0) || ((credit + balance) > 100)) {
						if (credit % 5 !=0) {
							System.out.println();
							System.out.println("Credit amount must be a multiple of $5.");
							System.out.print("Please re-enter the amount: ");
							credit = userInput.nextDouble();
						}
						else if (credit + balance > 100) {
							System.out.println();
							System.out.printf("The current credit balance on your ticket is: $%.2f", balance);
							System.out.println();
							System.out.print("Total allowable credit is $100. Please enter a lesser amount: ");
							credit = userInput.nextDouble();
						}
						// Consume trailing new line
						userInput.nextLine();
					}
				}
				if ((credit % 5 == 0) && ((credit + balance) <= 100) && (ticketID == targetID)) {
					// Increase credit is valid so add it to the ticket balance
					PepPepTicket.balance = PepPepTicket.balance + credit;
					System.out.println();
					System.out.printf("Transaction successful! Your new credit balance is: $%.2f", getBalance());
					System.out.println();
					return;
				}
			}			
			catch (InputMismatchException exception) {
				System.out.println("That is not a valid input! The addCredits exception caught it."); 
				// Consume trailing new line
				userInput.nextLine();
			}
		}		
		
		else if (optionSelection.contentEquals("N")) {
			System.out.println("No credits added, returning to Main Menu ... ");
			return;
		}
	}


	// Method for checking the balance of credit on the Pep-Pep Ticket
	private static void checkBalance() {
		System.out.println();
		System.out.println("CHECK CREDIT BALANCE:");
		System.out.println("--------------------");
		System.out.println();
		
		// Set temporary reference to null (acts as a "not found" signal)
		PepPepTicket[][] temp = null;
				
		System.out.print("Please enter your ticket ID: ");
		try {
			// Prompt user to enter target Pep-Pep Ticket ID to search for
			targetID = userInput.nextInt();
		
			// Uses array length to control the search loop to find a match
			for (int i = 0; i < ticketCount && temp == null; i++) {
			
				// Check the current ticket to see if it has the ID specified by the user
				if (ticketID == targetID) {
					// Attach temp reference to matching PepPepTicket object
					temp = ticketList.get(i);
				}
			}
				
			// Check to see if search was unsuccessful
			if (temp == null) {
				System.out.print("Pep-Pep Ticket ID \"" + targetID + "\" not found!");
			}
			else {
				System.out.println();
				// Matching PepPepTicket object found, so prompt the user to enter the credit amount
				System.out.print("Matching ticket ID found ...");
				System.out.println();
				System.out.printf("The current credit balance on your ticket is: $%.2f", balance);
			}
		}
		catch (InputMismatchException exception) {
			System.out.println("That is not a valid input!");
		}				
		System.out.println();
		// Consume trailing new line
		userInput.nextLine();
	}
		

	// Method for buying travel passes with the Pep-Pep Ticket
	private static void buyPass() {
		String passSelection;
		String confirmation;
		
		System.out.println();
		System.out.println("BUY A TRAVEL PASS:");
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.println("What type of travel pass would you like to buy?");
		System.out.println();
		System.out.println("A - 2 Hour Pass for Zone 1 (Costs $3.50)");
		System.out.println("B - All Day Pass for Zone 1 (Costs $6.00)");
		System.out.println("C - 2 Hour Pass for Zones 1 & 2 (Costs $7.00)");
		System.out.println("D - All Day Pass for Zones 1 & 2 (Costs $12.00)");
		System.out.println("X - Cancel and return to Main Menu");
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.print("Enter your selection: ");
		passSelection = userInput.nextLine();
		passSelection = passSelection.toUpperCase();
		System.out.println();
		
		// Validate passSelection input length
		if (passSelection.length() != 1) {
			System.out.println("Invalid entry - selection must be a single letter");
			return;
		}
		
		else {		
			// Process user's selection
			switch (passSelection) {
			case "A":
				searchID();
				System.out.println();
				if (ticketID !=targetID) {
					System.out.println("I'm being booted out of case A!!!");
					return;
				}
				else {
					System.out.println();
					System.out.printf("You are purchasing a " + pass1 + ", $%.2f", pass1Cost);
					System.out.print(" will be charged to Pep-Pep Ticket " + ticketID + ". Confirm - Y / N: ");
					confirmation = userInput.nextLine();
					confirmation = confirmation.toUpperCase();
					System.out.println();
					while (!confirmation.contentEquals("Y") && !confirmation.contentEquals("N")) {
						System.out.println("Invalid response - returning to Main Menu from A!");
						return;
					}
					if (confirmation.contentEquals("Y")) {
						if (balance < pass1Cost) {
							System.out.println("Transaction failed!");
							System.out.println();
							System.out.print("PepPepTicket " + ticketID + " has not been charged as there is insufficient credit. ");
							System.out.printf("Ticket balance is currently $%.2f", balance);
							System.out.println();
							System.out.println("Please top up ticket credits and try again.");
							System.out.println();
							System.out.println("Exiting to Main Menu . . .");
							return;
						}
						else if (balance >= pass1Cost) {
							balance = balance - pass1Cost;
							System.out.println("Thank you, your transaction has been successful!");
							System.out.println();
							System.out.printf("Your receipt number is: " + transactionID + ", (" + dateFormat.format(transactionDate));
							System.out.printf("). Credit balance remaining on Pep-Pep Ticket is $%.2f", balance);
							transactionID++;
							System.out.println();
							return;
						}
					}
					else if (confirmation.contentEquals("N")) {
						System.out.println("No pass bought, returning to travel pass selections . . .");
						return;
					}
				}
				break;
				
			case "B":
				searchID();
				if (ticketID !=targetID) {
					System.out.println();
					return;
				}
				else {
					System.out.println();
					System.out.printf("You are purchasing a " + pass2 + ", $%.2f", pass2Cost);
					System.out.print(" will be charged to Pep-Pep Ticket " + ticketID + ". Confirm - Y / N: ");
					confirmation = userInput.nextLine();
					confirmation = confirmation.toUpperCase();
					System.out.println();
					while (!confirmation.contentEquals("Y") && !confirmation.contentEquals("N")) {
						System.out.println("Invalid response - returning to Main Menu from B!");
						return;
					}
					if (confirmation.contentEquals("Y")) {
						if (balance < pass2Cost) {
							System.out.println("Transaction failed!");
							System.out.println();
							System.out.print("PepPepTicket " + ticketID + " has not been charged as there is insufficient credit. ");
							System.out.printf("Ticket balance is currently $%.2f", balance);
							System.out.println();
							System.out.println("Please top up ticket credits and try again.");
							System.out.println();
							System.out.println("Exiting to Main Menu . . .");
							return;
						}
						else if (balance >= pass2Cost) {
							balance = balance - pass2Cost;
							System.out.println("Thank you, your transaction has been successful!");
							System.out.println();
							System.out.printf("Your receipt number is: " + transactionID + ", (" + dateFormat.format(transactionDate));
							System.out.printf("). Credit balance remaining on Pep-Pep Ticket is $%.2f", balance);
							transactionID++;
							System.out.println();
							return;
						}
					}
					else if (confirmation.contentEquals("N")) {
						System.out.println("No pass bought, returning to travel pass selections . . .");
						return;
					}
				}
				break;
				
			case "C":
				searchID();
				if (ticketID !=targetID) {
					System.out.println();
					return;
				}
				else {
					System.out.println();
					System.out.printf("You are purchasing an " + pass3 + ", $%.2f", pass3Cost);
					System.out.print(" will be charged to Pep-Pep Ticket " + ticketID + ". Confirm - Y / N: ");
					confirmation = userInput.nextLine();
					confirmation = confirmation.toUpperCase();
					System.out.println();
					while (!confirmation.contentEquals("Y") && !confirmation.contentEquals("N")) {
						System.out.println("Invalid response - returning to Main Menu from C!");
						return;
					}
					if (confirmation.contentEquals("Y")) {
						if (balance < pass3Cost) {
							System.out.println("Transaction failed!");
							System.out.println();
							System.out.print("PepPepTicket " + ticketID + " has not been charged as there is insufficient credit. ");
							System.out.printf("Ticket balance is currently $%.2f", balance);
							System.out.println();
							System.out.println("Please top up ticket credits and try again.");
							System.out.println();
							System.out.println("Exiting to Main Menu . . .");
							return;
						}
						else if (balance >= pass3Cost) {
							balance = balance - pass3Cost;
							System.out.println("Thank you, your transaction has been successful!");
							System.out.println();
							System.out.printf("Your receipt number is: " + transactionID + ", (" + dateFormat.format(transactionDate));
							System.out.printf("). Credit balance remaining on Pep-Pep Ticket is $%.2f", balance);
							transactionID++;
							System.out.println();
							return;
						}
					}
					else if (confirmation.contentEquals("N")) {
						System.out.println("No pass bought, returning to travel pass selections . . .");
						return;
					}
				}
				break;
				
			case "D":
				searchID();
				if (ticketID !=targetID) {
					System.out.println();
					return;
				}
				else {
					System.out.println();
					System.out.printf("You are purchasing an " + pass4 + ", $%.2f", pass4Cost);
					System.out.print(" will be charged to Pep-Pep Ticket " + ticketID + ". Confirm - Y / N: ");
					confirmation = userInput.nextLine();
					confirmation = confirmation.toUpperCase();
					System.out.println();
					while (!confirmation.contentEquals("Y") && !confirmation.contentEquals("N")) {
						System.out.println("Invalid response - returning to Main Menu from D!");
						return;
					}
					if (confirmation.contentEquals("Y")) {
						if (balance < pass4Cost) {
							System.out.println("Transaction failed!");
							System.out.println();
							System.out.print("PepPepTicket " + ticketID + " has not been charged as there is insufficient credit. ");
							System.out.printf("Ticket balance is currently $%.2f", balance);
							System.out.println();
							System.out.println("Please top up ticket credits and try again.");
							System.out.println();
							System.out.println("Exiting to Main Menu . . .");
							return;
						}
						else if (balance >= pass4Cost) {
							balance = balance - pass4Cost;
							System.out.println("Thank you, your transaction has been successful!");
							System.out.println();
							System.out.printf("Your receipt number is: " + transactionID + ", (" + dateFormat.format(transactionDate));
							System.out.printf("). Credit balance remaining on Pep-Pep Ticket is $%.2f", balance);
							transactionID++;
							System.out.println();
							return;
						}
					}
					else if (confirmation.contentEquals("N")) {
						System.out.println("No pass bought, returning to travel pass selections . . .");
						return;
					}
				}
				break;
				
			case "X":
				System.out.println("Returning to Main Menu ... ");
				break;
				
			default:
				System.out.println("Selection error - that is not a valid travel pass selection!");
				return;
			}
		} while (!passSelection.equals("X"));
		
	}
	

	// Method for Administrator's to view the transactions on a Pep-Pep Ticket
	private static void viewTransactions() {
		String outputSelection;
		do {
			System.out.println();
			System.out.println("VIEW TICKET TRANSACTIONS:");
			System.out.println("-------------------------------------------------");
			System.out.println();
			System.out.println("D - Output transactions sorted by date");
			System.out.println("T - Output transactions sorted by transaction ID");
			System.out.println("X - Cancel and return to Main Menu");
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println();
			System.out.print("Enter your selection: ");
			outputSelection = userInput.nextLine();
			outputSelection = outputSelection.toUpperCase();
			System.out.println();

			// Validate outputSelection input length
			if (outputSelection.length() != 1) {
				System.out.println("Invalid entry - selection must be a single character");
				return;
			}
		
			else {
				// Process user's selection
				switch (outputSelection) {
				case "D": 
					searchID();
					if (ticketID !=targetID) {
						return;
					}
					else {
						System.out.println();
						System.out.println("Transactions on this ticket sorted by DATE OF TRANSACTION are:");
						System.out.println();
						
						// For loop
						for (ticketCount = 0; ticketCount < ticketList.size(); ticketCount++) {
							System.out.printf("%20s%s\n", "Transaction ID:  ", transactionID);
							System.out.printf("%20s%s\n", "Date:  ", transactionDate);
							System.out.printf("%20s%s\n", "Pass:  ", pass);
							System.out.printf("%20s%s %.2f\n", "Cost:  ", "$", charge);
							System.out.printf("%20s%s\n", "Index:  ", ticketCount);
							System.out.println();
						}
						System.out.println();
						System.out.println("End of transactions for Ticket ID: " + ticketID + ".   Exiting to viewing menu . . .");
					}				
					break;
				
				case "T":
					searchID();
					if (ticketID != targetID) {
						return;
					}
					else {
						System.out.println();
						System.out.println("Transactions on this ticket sorted by TRANSACTION ID are:");
						System.out.println();
						
						// For loop
						for (ticketCount = 0; ticketCount < ticketList.size(); ticketCount++) {
							System.out.printf("%20s%s\n", "Date:  ", transactionDate);
							System.out.printf("%20s%s\n", "Transaction ID:  ", transactionID);
							System.out.printf("%20s%s\n", "Pass:  ", pass);
							System.out.printf("%20s%s %.2f\n", "Cost:  ", "$", charge);
							System.out.printf("%20s%s\n", "Index:  ", ticketCount);
							System.out.println();
						}
						System.out.println();
						System.out.println("End of transactions for Ticket ID: " + ticketID + ".   Exiting to viewing menu . . .");
					}
				break;
			
				case "X":
					System.out.println("Returning to Main Menu ... ");
					break;
				default:
					System.out.println("Selection error - that is not a valid selection to view transactions!");
					//return;
				}
			}
		}
		while (!outputSelection.equals("X"));	
		return;
	}
	
	
	// Method to print transactions by DATE - not utilized at present
	private static void printDetailsByDate() {
		System.out.println();
		System.out.println("Transactions on this ticket sorted by DATE OF TRANSACTION are:");
		System.out.println();
		
		// For loop
		for (ticketCount = 0; ticketCount < ticketList.size(); ticketCount++) {
			System.out.printf("%20s%s\n", "Transaction ID:  ", transactionID);
			System.out.printf("%20s%s\n", "Date:  ", transactionDate);
			System.out.printf("%20s%s\n", "Pass:  ", pass);
			System.out.printf("%20s%s %.2f\n", "Cost:  ", "$", charge);
			System.out.printf("%20s%s\n", "Index:  ", ticketCount);
			System.out.println();
		}
		// Consume trailing new line
		userInput.nextLine();
		return;
	}
	
	
	// Method to print transactions by ID - not utilized at present
	private static void printDetailsByTransactionID() {
		System.out.println();
		System.out.println("Transactions on this ticket sorted by TRANSACTION ID are:");
		System.out.println();
		
		// For loop
		for (ticketCount = 0; ticketCount < ticketList.size(); ticketCount++) {
			System.out.printf("%20s%s\n", "Date:  ", transactionDate);
			System.out.printf("%20s%s\n", "Transaction ID:  ", transactionID);
			System.out.printf("%20s%s\n", "Pass:  ", pass);
			System.out.printf("%20s%s %.2f\n", "Cost:  ", "$", charge);
			System.out.printf("%20s%s\n", "Index:  ", ticketCount);
			System.out.println();
		}
		// Consume trailing new line
		userInput.nextLine();
		return;
	}
	
	// Method to trial print array details - not utilized at present
	public static void printArrayList(ArrayList<PepPepTicket[][]> ticketList) {
		for (int i = 0; i < ticketList.size(); i++) {
			System.out.printf("List position " + ticketCount +") is " + "Ticket ID: " + ticketID + 
				" that has a balance of " + "$%.2f", balance);
			ticketCount++;
			System.out.println();
		}
		
		System.out.println();
		System.out.println("ArrayList contains " + ticketList.size() + " arrays.");
		System.out.println();
			
		// Iterate through ArrayList of arrays
		for (PepPepTicket[][] ticketArray : ticketList) {
			System.out.print("Array size is: " + ticketArray.length);
			System.out.print(" [");
				
			// Iterate through array using its length
			for (int i = 0; i < ticketArray.length; i++) {
				System.out.println( ticketArray[i] + " " + ticketID + " " + balance);					
			}
			System.out.println("]");
			return;
		}
		// Consume trailing new line
		userInput.nextLine();
		return;
	}
	
	
	// Method to search the user entered ID
	public static void searchID() {
		
		// Set temporary reference to null (acts as a "not found" signal)
		PepPepTicket[][] temp = null;
						
		System.out.print("Please enter your ticket ID: ");
		try {
			// Prompt user to enter target Pep-Pep Ticket ID to search for
			targetID = userInput.nextInt();
				
			// Uses array length to control the search loop to find a match
			for (int i = 0; i < ticketCount && temp == null; i++) {
					
				// Check the current ticket to see if it has the ID specified by the user
				if (ticketID == targetID) {
					// Attach temp reference to matching PepPepTicket object
					temp = ticketList.get(i);
				}
			}
						
			// Check to see if search was unsuccessful
			if (temp == null) {
				System.out.print("Pep-Pep Ticket ID " + targetID + " not found! (Message from searchID)");
				System.out.println();
				// Consume trailing new line
				userInput.nextLine();
				return;
			}
			else {
				System.out.println();
				for (int i = 0; i < ticketCount; i++) {
					// Matching PepPepTicket object found, so let the user know how much credit is on the ticket
					System.out.printf("The current credit balance on Ticket: " + ticketID + " is: $%.2f", balance);
					// Consume trailing new line
					userInput.nextLine();
					return;
				}
			}
		}
		catch (InputMismatchException exception) {
			System.out.print("That is not an integer! The searchID exception is catching it.");
			// Consume trailing new line
			//userInput.nextLine();
			//return;
		}
//		// Consume trailing new line
		userInput.nextLine();
		return;
	}	


	// Main method to run the Main Menu and program
	public static void main(String[] args) {
		
		userInput = new Scanner(System.in);
		
		// Hard coded array items to help with testing features in the program
		ticketList.add(new PepPepTicket[][]{});
		ticketList.add(new PepPepTicket[][]{});		
		
		// Declare variables
		String menuSelection;

		// Display initial header
		System.out.println("Welcome to Cinco Public Transport Ticket System");		

		// Do-while loop for Main Menu
		do {
			// Print main menu to screen
			System.out.println();
			System.out.println("MAIN MENU: ");
			System.out.println("=============================");
			System.out.println();
			System.out.println("1 - Purchase a Pep-Pep Ticket");
			System.out.println("2 - Add Credits");
			System.out.println("3 - Check Credit Balance");
			System.out.println("4 - Buy Travel Passes");
			System.out.println("5 - View Transactions");
			System.out.println("6 - Exit");
			System.out.println();
			System.out.println("=============================");
			System.out.println();
			System.out.print("Enter your selection: ");
			menuSelection = userInput.nextLine();
			menuSelection = menuSelection.toUpperCase();
			System.out.println();

			// Validate menuSelection input length
			if (menuSelection.length() != 1) {
				System.out.println("Incorrect entry - selection must be a single digit!");
			} 
			
			else {				
				// Process user's selection
				switch (menuSelection) {
				case "1":
					purchaseTicket();
					break;
				case "2":
					addCredits();
					break;
				case "3":
					checkBalance();
					break;
				case "4":
					buyPass();
					break;
				case "5":
					viewTransactions();
					break;
				case "6":
					System.out.println("Exiting the program ... ");
					break;
				default:
					System.out.println("Error - that is not a valid menu selection!");
				}
			}
		} while (!menuSelection.equals("6"));
	}
}
