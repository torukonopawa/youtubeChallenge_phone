package youtube.toruko.phone;

import java.util.ArrayList;

import youtube.toruko.phone.Database.Contact;

public class PhoneActivity implements PhoneS {

	private Database database = new Database();
	
	//CONSTRUCTOR
	public PhoneActivity(Database database) {
		this.database = database;
	}

	//METHODS OF INTERFACE
	@Override
	public void ShowContacts() {
		System.out.println("===CONTACTS===");
		for(int i=0; i < this.database.contacts.size() ;i++)
		{
			System.out.println("Name :\t" + this.database.contacts.get(i).contact.keySet()
					+ " , Number : " + this.database.contacts.get(i).contact.values());
		}
	}

	@Override
	public void AddContact(ArrayList<String> names, ArrayList<String> numbers) {
		for(int i=0; i < names.size() ;i++)
		{
			Contact tempContact = this.database.new Contact(names.get(i), numbers.get(i));
			this.database.contacts.add(tempContact);	
		}
		System.out.println("Every element is added to contacts");
	}
	
	@Override
	public void AddContact(String name, String number) {
		Contact tempContact = this.database.new Contact(name, number);
		this.database.contacts.add(tempContact);
		System.out.println("The person shown is added to contacts -> " + name);
	}

	@Override
	public void DeleteContact(String name) {
		boolean isDeleted = false;
		for(int i=0; i < this.database.contacts.size() ;i++)
		{
			Contact tempContact = this.database.contacts.get(i);
			if(tempContact.contact.remove(name) != null)
			{
				isDeleted = true;
			}
		}
		
		if(!isDeleted)
		{
			System.out.println("Could not Found any contact as -> " + name);
		}
		else
		{
			System.out.println("The contanct shown is deleted -> " + name);
		}
	}

	@Override
	public void SearchContact(String name) {
		boolean isFound = false;
		for(int i=0; i < this.database.contacts.size() ;i++)
		{
			Contact tempContact = this.database.contacts.get(i);
			if(tempContact.contact.get(name) != null)
			{
				isFound = true;
				System.out.println(name + " is found, " + " Number : " + tempContact.contact.get(name));
			}
		}
		
		if(!isFound)
		{
			System.out.println("Could not Found any contact as -> " + name);
		}
	}

}
