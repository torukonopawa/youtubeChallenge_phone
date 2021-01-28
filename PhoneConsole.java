package youtube.toruko.phone;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneConsole {
	
	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> numbers = new ArrayList<>();
		
		names.add("Alperen"); names.add("Sarah"); names.add("Meisam");
		numbers.add("7"); numbers.add("70"); numbers.add("5352");
		
		Database database = new Database(names, numbers);
		PhoneActivity phone = new PhoneActivity(database);
		MessageActivity message = new MessageActivity(database);
		
		
		System.out.println("1. Manage Contacts\t2. Messages\t3.Quit");
		
		boolean isQuited = false;
		Scanner scanner = new Scanner(System.in);
		while(!isQuited)
		{
			switch(scanner.nextInt())
			{
			case 1:
				System.out.println("\t1. Show all contacts");
				System.out.println("\t2. Add a new contact");
				System.out.println("\t3. Search for a contact");
				System.out.println("\t4. Delete a contact");
				System.out.println("\t5. RETURN");
				switch(scanner.nextInt())
				{
				case 1:
					phone.ShowContacts();
					
					break;
				case 2:
					String tempName = new String(), number = new String();
					System.out.println("\tEnter the name");
					scanner.next();
					System.out.println("\tEnter the number");
					scanner.next();
					
					phone.AddContact(tempName, number);
					
					break;
				case 3:
					String tempName1 = new String();
					System.out.println("\tEnter the name");
					scanner.next();
					
					phone.SearchContact(tempName1);
					
					break;
				case 4:
					String tempName11 = new String();
					System.out.println("\tEnter the name");
					scanner.next();
					
					phone.DeleteContact(tempName11);
					
					break;
				case 5:
					break;
				}
				
				break;	
			case 2:
				System.out.println("\t1. Show all messages");
				System.out.println("\t2. Send a new message");
				System.out.println("\t3. RETURN");
				switch(scanner.nextInt())
				{
				case 1:
					message.ShowMessages();
					
					break;
				case 2:
					String toWho = new String(), theWhat = new String(), theTime = new String();
					System.out.println("\tEnter the name");
					toWho = scanner.next();
					System.out.println("\tEnter the time");
					theTime = scanner.next();
					System.out.println("\tEnter the message");
					theWhat = scanner.next();
		
					message.SendMessage(toWho, theWhat, theTime);
					
					break;
				case 3:
					String tempName1 = new String();
					System.out.println("\tEnter the name");
					scanner.next();
					phone.SearchContact(tempName1);
					
					break;
				}
				
				break;
			case 3:
				isQuited = true;
				break;
			}
			System.out.println("1. Manage Contacts\t2. Messages\t3.Quit");
		}
		
	}
	

}
