/*
 * Written by Sandy Grayson-s3364895, Kimberley Thomson-s3427286,and
 * Boruch Shmaya Grossbaum-s3549187 for
 * Cinco Ticketing Console-Based Software Project, RMIT CPT330 SEPM SP1 2019
 * File created 19 April 2019
 * Version 2.0 uploaded 10 May 2019
 * Version 3.0 uploaded 17 May 2019
 * Version 3.1 uploaded 18 May 2019
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

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;


public class TicketArrayList {
	// Instance variables - defines attributes (fields) of objects
	// Private fields only accessed by other methods in the class
	// Static variables have the same value for every object
	// Protected means that this value can only be accessed by other code
	static Scanner userInput = new Scanner(System.in);
	ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	int ticketCount = 0;
	long ticketID;
	double ticketCost = 8;
	long targetID;
	double balance = 0.00;
	double credit = 0;
	ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	int transactionCount = 0;
	int transactionID = 1000;
	Date transactionDate = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat ("hh:mm:ss a z, E dd.MM.yyyy");
	String pass;
	String pass1 = "2 Hour Zone 1 Pass";
	String pass2 = "2 Hour Zones 1 & 2 Pass";
	String pass3 = "All Day Zone 1 Pass";
	String pass4 = "All Day Zones 1 & 2 Pass";
	double charge;
	double pass1Cost = 3.50;
	double pass2Cost = 6.00;
	double pass3Cost = 7.00;
	double pass4Cost = 12.00;
	
	
	// Custom data type class
	class Ticket {
		// Global variables of the class
		long ticketID;
		double balance;
		
		// Constructor for Ticket		
		Ticket(long ticketID, double balance){
			// Initialize input variables of the main method to the global variables of the class
			this.ticketID = ticketID;
			this.balance = balance;
		}

		public long getTicketID() {
			// TODO Auto-generated method stub
			return ticketID;
		}
	}
	
	// Getter for ticket ID
	public long getTicketID() {
			return ticketID;
		}
	// Method overloading allows different input to be accepted into the same method name
	public void setTicketID(long ticketID) {
		this.ticketID = ticketID;
		}
	
	public long setTicketID() {
		long minNumber = 100000;
		long maxNumber = 1000000;
		
		// Generate a random number between 100000 and 1000000
		ticketID = minNumber + (long)(Math.random() * ((maxNumber - minNumber) + 1));
		return ticketID;
	}
		
	// Getter for balance
	public double getBalance() {
		return balance;
	}
		
	// Setter for balance
	public void setBalance(double balance) {
		this.balance = balance;
	}
		
	
	class Transaction {
		// Global variables of the class
		long ticketID;
		int transactionID;
		Date transactionDate;
		String pass;
		double charge;
		double balance;
		
		// Constructor for Transaction
		Transaction(int transactionID, Date transactionDate, long targetID, String pass, double charge, double balance) {
			this.transactionID = transactionID;
			this.transactionDate = transactionDate;
			this.ticketID = targetID;
			this.pass = pass;
			this.charge = charge;
			this.balance = balance;
		}		
	}
	
	// Getter for transaction ID
	public long getTransactionID() {
		return transactionID;
	}
		
	// Method overloading allows different input to be accepted into the same method name
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	
	// Getter for credit
	public double getCredit(){
		return credit;
	}
		
	// Getter for pass type
	public String getPass() {
		return pass;
	}
	
	// Getter for charge
		public double getCharge() {
			return charge;
	}
	
	// Getter for transaction date
	public Date getTransactionDate() {
		return transactionDate;
	}	
	
	// Setter for transaction date
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
//-------------------------------------------------------------------------------------------------------------------------------------------------
		
	
	// Method for purchasing a Pep-Pep Ticket
	private void purchaseTicket() {

		System.out.println();
		System.out.println("PEP-PEP TICKET INFORMATION:");
		System.out.println("------------------------------------------------------------");
		System.out.println();
		System.out.println("Cost of a Pep-Pep Ticket is $8, starting balance will be $0.");
		System.out.println("Add credits to buy travel passes.");
		System.out.println("\n");
		System.out.println("     Y - Continue to purchase Pep-Pep Ticket");
		System.out.println("     N - Cancel to return to main menu");
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
					System.out.printf("Current ticket credit balance is: $%.2f", getBalance(), ".");
					System.out.println();
					System.out.println("Thank you, please take your ticket.");
					System.out.println();
					
					// Create an object and send values to the constructor to be saved in the ticket class
					ticketList.add(new Ticket(ticketID, balance));
					
					// This for loop is for testing the array list
					for (int i = 0; i <= ticketCount; i++) {
						System.out.println("(Ticket " + getTicketID() + " is stored at array position: "+ ticketCount + ")");
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
	

//-------------------------------------------------------------------------------------------------------------------------------------------------
		
	
	// Method to search the user entered ID
	public void searchID() {
			
		// Set temporary reference to null (acts as a "not found" signal)
		Ticket temp = null;
						
		System.out.print("Please enter your ticket ID: ");
		try {
			// Prompt user to enter target Pep-Pep Ticket ID to search for
			targetID = userInput.nextInt();
					
			// Uses array length to control the search loop to find a match
			for (int i = 0; i < ticketList.size() && temp == null; i++) {
						
				// Check the current ticket to see if it has the ID specified by the user
				if (ticketID  == targetID) {
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
				for (int i = 0; i < ticketList.size(); i++) {
					// Matching PepPepTicket object found, so let the user know how much credit is on the ticket
					System.out.printf("The current credit balance on Ticket: " + ticketID + " is: $%.2f", balance);
					System.out.println();
					// Consume trailing new line
					userInput.nextLine();
					return;
				}
			}
		}
		catch (InputMismatchException exception) {
			System.out.print("That is not an integer! The searchID exception is catching it.");
			System.out.println();
		}
		// Consume trailing new line
		userInput.nextLine();
		return;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Method for adding credits to the ticket
	private void addCredits() {
		System.out.println();
		System.out.println("ADD CREDITS INFORMATION:");
		System.out.println("----------------------------------------------------------");
		System.out.println();
		System.out.println("Credits are required to be able to purchase Travel Passes.");
		System.out.println("Credit amounts must be in multiples of $5.");
		System.out.println("Ticket credit limit is $100 in total.");
		System.out.println();
		System.out.println("     Y - Continue to add credit Pep-Pep Ticket");
		System.out.println("     N - Cancel to return to main menu");
		System.out.println("\n");        			  
		System.out.print("Enter your selection: ");
		
		String optionSelection = userInput.nextLine();
		optionSelection = optionSelection.toUpperCase();
		
		// Set temporary reference to null (acts as a "not found" signal)
		//Ticket temp = null;
		
		while (!optionSelection.contentEquals("Y") && !optionSelection.contentEquals("N")) {
			System.out.println();
			System.out.println("Error - invalid selection, feature exited!");
			break;
		}
		
		if (optionSelection.contentEquals("Y")) {
			searchID();
			try {
				System.out.println();
				if (ticketID !=targetID) {
					System.out.println();
					return;
				}
				else {
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
				
					if ((credit % 5 == 0) && ((credit + balance) <= 100) && (ticketID == targetID)) {
						// Increase credit is valid so add it to the ticket balance
						balance = balance + credit;
						System.out.println();
						System.out.printf("Transaction successful! Your new credit balance is: $%.2f", balance);
						System.out.println();
						return;
					}			
				}
			}
			catch (InputMismatchException exception) {
				System.out.println("That is not a valid input!"); 
				// Consume trailing new line
				userInput.nextLine();
			}
		}		
		
		else if (optionSelection.contentEquals("N")) {
			System.out.println("No credits added, returning to Main Menu ... ");
			return;
		}
	}
	
	
//-------------------------------------------------------------------------------------------------------------------------------------------------
		
	
	// Method for checking the balance of credit on the Pep-Pep Ticket
	public void checkBalance() {
		System.out.println();
		System.out.println("CHECK CREDIT BALANCE:");
		System.out.println("------------------------------------------------------");
		System.out.println();
		
		searchID();
	}
		
	
//-------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Method for selecting a travel pass to buy on the Pep-Pep Ticket
	private void choosePass() {
		String passSelection;
		do {
			// Print pass selection menu to screen
			System.out.println();
			System.out.println("BUY A TRAVEL PASS:");
			System.out.println("------------------------------------------------------");
			System.out.println();
			System.out.println("What type of travel pass would you like to buy?");
			System.out.println();
			System.out.println("     A - 2 Hour Pass for Zone 1 (Costs $3.50)");
			System.out.println("     B - All Day Pass for Zone 1 (Costs $6.00)");
			System.out.println("     C - 2 Hour Pass for Zones 1 & 2 (Costs $7.00)");
			System.out.println("     D - All Day Pass for Zones 1 & 2 (Costs $12.00)");
			System.out.println("     X - Cancel and return to Main Menu");
			System.out.println();
			System.out.println("------------------------------------------------------");
			System.out.println();
			System.out.print("Enter your selection: ");
			passSelection = userInput.nextLine();
			passSelection = passSelection.toUpperCase();
			System.out.println();
		
			// Validate passSelection input length
			if (passSelection.length() != 1) {
				System.out.println("Invalid entry - selection must be a single letter");
			}
		
			else {				
				// Process user's selection
				switch (passSelection) {
				case "A":
					searchID();	
					pass = pass1;
					charge = pass1Cost;
					System.out.println();
					if (ticketID !=targetID) {
						System.out.println();
						return;
					}
					else {
						buyPass();
					}
					break;
				
				case "B":
					searchID();
					pass = pass2;
					charge = pass2Cost;
					System.out.println();
					if (ticketID !=targetID) {
						System.out.println();
						return;
					}
					else {
						buyPass();
					}
					break;
				
				case "C":
					searchID();
					pass = pass3;
					charge = pass3Cost;
					System.out.println();
					if (ticketID !=targetID) {
						System.out.println();
						return;
					}
					else {
						buyPass();
					}
					break;
				
				case "D":
					searchID();
					pass = pass4;
					charge = pass4Cost;
					System.out.println();
					if (ticketID !=targetID) {
						System.out.println();
						return;
					}
					else {
						buyPass();
					}
					break;
				
				case "X":
					System.out.println("Exiting pass selection.  Returning to Main Menu ... ");
					return;
				
				default:
					System.out.println("Selection error - that is not a valid travel pass selection!");
					break;
				}
			}
		} while (!passSelection.equals("X"));
	}
	
	
//---------------------------------------------------------------------------------------------------------------------------------------
	
	// Method to process the selected travel pass being bought on the ticket
	private void buyPass() {
		String confirmation;
		System.out.printf("You are purchasing a " + pass + ", $%.2f", charge);
		System.out.print(" will be charged to Pep-Pep Ticket " + ticketID + ". Confirm - Y / N: ");
		
		confirmation = userInput.nextLine();
		confirmation = confirmation.toUpperCase();
		
		while (!confirmation.contentEquals("Y") && !confirmation.contentEquals("N")) {
			System.out.println("Invalid response - returning to pass selection menu!");
			return;
		}
		if (confirmation.contentEquals("Y")) {
			if (balance < charge) {
				System.out.println("Transaction failed!");
				System.out.println();
				System.out.print("PepPepTicket " + ticketID + " has not been charged as there is insufficient credit. ");
				System.out.printf("Ticket balance is currently $%.2f", balance, ".");
				System.out.println();
				System.out.println("Please top up ticket credits and try again.");
				System.out.println();
				System.out.println("Returning to pass selection options . . .");
				return;
			}
			else if (balance >= charge) {
				balance = balance - charge;
				System.out.println("Thank you, your transaction has been successful!");
				System.out.println();
				System.out.printf("Your receipt number is: " + transactionID + ", (" + dateFormat.format(transactionDate));
				System.out.printf("). Credit balance remaining on Pep-Pep Ticket is $%.2f", balance, ".");
				transactionList.add(new Transaction(transactionID, transactionDate, targetID, pass, charge, balance));
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
	
	
//-------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Method for Administrator's to view the transactions on a Pep-Pep Ticket
	private void viewTransactions() {
		
		String outputSelection;
		
		do {
			System.out.println();
			System.out.println("VIEW TICKET TRANSACTIONS:");
			System.out.println("------------------------------------------------------");
			System.out.println();
			System.out.println("     D - Output transactions sorted by date");
			System.out.println("     P - Print Arrays to Screen");
			System.out.println("     T - Output transactions sorted by transaction ID");
			System.out.println("     X - Cancel and return to Main Menu");
			System.out.println();
			System.out.println("------------------------------------------------------");
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
						break;
					}
					else {
						System.out.println();
						System.out.println("Transactions on this ticket sorted by DATE OF TRANSACTION are:");
						System.out.println();
							
						// For loop						
						for (int i = 0; i < transactionList.size(); i++) {
							Transaction transaction = transactionList.get(i);
							System.out.printf("At position " + i + " is Transaction ID: " + transaction.transactionID + "  "
									+ transaction.transactionDate+ "  "+ transaction.pass
									+ "  $%.2f", transaction.charge);
							System.out.println();
						}

						System.out.println();
						System.out.println("End of transactions for Ticket ID: " + ticketID + ".   Exiting to viewing menu . . .");
					}				
					break;
				
				case "P":
					System.out.println("Tickets in the array list are:");
					System.out.println();
					printTickets(ticketList);
					System.out.println("\n");
					
					System.out.println("Transaction in the array list are:");
					System.out.println();
					printTransactions(transactionList);
					System.out.println();
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
						
						for (int i = 0; i < transactionList.size(); i++) {
							Transaction transaction = transactionList.get(i);
							System.out.printf("At position " + i + " is Transaction ID: " + transaction.transactionID + "  "
									+ transaction.transactionDate+ "  "+ transaction.pass
									+ "  $%.2f", transaction.charge);
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
				}
			}
		}
		while (!outputSelection.equals("X"));	
		return;
	}
	
//-------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Method for adding tickets into the ticketList array list
	private void addTickets(long ticketID[], double balance[]) {
		// Local ticket array list taking data type from the class
		ArrayList<Ticket> ticketList = new ArrayList<>();
		for (int i = 0; i < ticketCount; i++) {
			// Create an object and send values to the constructor to be save in the ticket class
			ticketList.add(new Ticket(ticketID[i], balance[i]));
		}
	}
	
//-------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Method to add transactions into the transactionList array list
	public void addTransactions(int transactionID[], Date transactionDate[], String pass[], double charge[]) {
		// Local ticket array list taking data type from the class
		ArrayList<Transaction> transactionList = new ArrayList<>();
		for (int i = 0; i < transactionCount; i++) {
			// Create and object and send values to the constructor to be save in the ticket class
			transactionList.add(new Transaction(transactionID[i], transactionDate[i], targetID, pass[i], charge[i], balance));
		}
	}
	
//-------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Method to print the tickets that are in the ticketList array list
	public void printTickets(ArrayList<Ticket> ticketList) {
		// The list is the ticket array list sent from the previous method
		for (int i = 0; i < ticketCount; i++) {
			Ticket ticket = ticketList.get(i);
			System.out.printf("At position " + i + " is Ticket ID: " + ticket.ticketID + " current balance of $%.2f", ticket.balance);
			System.out.println();
		}
	}
	
//-------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Method to print the transactions that are in the transactionList array list
	public void printTransactions(ArrayList<Transaction> transactionList) {
		// The list is the ticket array list sent from the previous method
		for (int i = 0; i < transactionList.size(); i++) {
			Transaction transaction = transactionList.get(i);
			System.out.printf("At position " + i + " is Transaction ID: " + transaction.transactionID + "  "
					+ transaction.transactionDate + "  "+ transaction.pass
					+ "  $%.2f", transaction.charge);
			System.out.println();
		}
	}
	
//-------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Main method of the program that runs the Main Menu for the various functions
	public static void main(String[] args) {
		// Hard coded input data
		long ticketID[] = {225225, 565656, 100001, 364895};
		double balance[] = {23.00, 3.50, 15.00, 2.00};
		int transactionID[] = {};
		Date transactionDate[] = {};
		String pass[] = {};
		double charge[] = {};
		
		
		// Create a ticket object
		TicketArrayList ticket = new TicketArrayList();		
		
		// Call the function to add the values to the array list
		ticket.addTickets(ticketID, balance);
		
		// Create a transaction object
		TicketArrayList transaction = new TicketArrayList();
				
		// Call the function to add the values to the array list
		transaction.addTransactions(transactionID, transactionDate, pass, charge);
		
		userInput = new Scanner(System.in);	
		
		// Declare variables
		String menuSelection;

		// Display initial header
		System.out.println("Welcome to Cinco Public Transport Ticket System");		

		// Do-while loop for Main Menu
		do {
			// Print main menu to screen
			System.out.println();
			System.out.println("MAIN MENU: ");
			System.out.println("===============================");
			System.out.println();
			System.out.println("  1 - Purchase a Pep-Pep Ticket");
			System.out.println("  2 - Add Credits");
			System.out.println("  3 - Check Credit Balance");
			System.out.println("  4 - Buy Travel Passes");
			System.out.println("  5 - View Transactions");
			System.out.println("  6 - Exit");
			System.out.println();
			System.out.println("===============================");
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
					ticket.purchaseTicket();
					break;
				case "2":
					ticket.addCredits();
					break;
				case "3":
					ticket.checkBalance();
					break;
				case "4":
					ticket.choosePass();
					break;
				case "5":
					ticket.viewTransactions();
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
