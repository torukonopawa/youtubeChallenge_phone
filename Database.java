package youtube.toruko.phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {
	
	//INNER CLASS
		//Contact = NAME - NUMBER
	public class Contact {
		public Map<String, String> contact = new HashMap<>();
		
		public Contact(String name, String number) {
			this.contact.put(name, number);
		}
		
	}
	
		//Message = DATE - MESSAGE
	public class Message {
		public Map<String, String> message = new HashMap<>();

		public Message(String date, String message) {
			this.message.put(date, message);
		}
		
	}
	
	
	// - - - -
	
	public ArrayList<Contact> contacts = new ArrayList<>();
	public ArrayList<Message> messages = new ArrayList<>();

	//CONSTRUCTOR
	public Database() {
		//System.out.println("Database created, waiting for data...");
	}
	
	public Database(ArrayList<String> names, ArrayList<String> numbers) {
		for(int i=0; i < names.size() ;i++)
		{
			Contact tempContact = new Contact(names.get(i), numbers.get(i));
			this.contacts.add(tempContact);
		}
		
	}
	
	public Database(ArrayList<String> names, ArrayList<String> numbers, ArrayList<String> dates, ArrayList<String> messages) {
		for(int i=0; i < names.size() ;i++)
		{
			Contact tempContact = new Contact(names.get(i), numbers.get(i));
			Message tempMessage = new Message(dates.get(i), messages.get(i));
			
			this.contacts.add(tempContact);
			this.messages.add(tempMessage);
		}
		
	}
	
}
