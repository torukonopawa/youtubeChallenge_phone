package youtube.toruko.phone;

import java.util.Scanner;

import youtube.toruko.phone.Database.Message;

public class MessageActivity implements MessageS {
	
	private Database database = new Database();

	//CONSTRUCTOR
	public MessageActivity(Database database) {
		this.database = database;
	}

	//METHODS OF INTERFACE
	@Override
	public void ShowMessages() {
		System.out.println("===MESSAGES===");
		for(int i=0; i < this.database.messages.size() ;i++)
		{
			System.out.println("Name :\t" + this.database.messages.get(i).message.keySet()
					+ " , Message : " + this.database.messages.get(i).message.values());
		}
	}

	@Override
	public void SendMessage(String toWho, String theWhat, String theTime) {
		Message tempMessage = this.database.new Message(theTime, theWhat);	
		boolean isSend = false;
		for(int i=0; i < this.database.contacts.size() ;i++)
		{
			if(this.database.contacts.get(i).contact.get(toWho) != null)
			{
				isSend = true;
				this.database.messages.add(tempMessage);
			}
		}
		
		if(isSend)
		{
			System.out.println("The message is sent. (" + theTime + ")");
		}
		else
		{
			System.out.println("Could not sent, there was a problem/there is no such a contact");
		}
		
	}
	
	@Override
	public void SendMessage() {
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i < database.contacts.size() ;i++)
		{
			System.out.println("\t" + database.contacts.get(i).contact.keySet());
		}
		System.out.println("Tell me, who do you want to send message");
		String toWho = scanner.next();
		System.out.println("What is the current time");
		String theTime = scanner.next();
		System.out.println("Enter the message : ");
		String theWhat = scanner.next();
		
		Message tempMessage = this.database.new Message(theTime, theWhat);
		boolean isSend = false;
		for(int i=0; i < this.database.contacts.size() ;i++)
		{
			if(this.database.contacts.get(i).contact.get(toWho) != null)
			{
				isSend = true;
				this.database.messages.add(tempMessage);
			}
		}
		
		if(isSend)
		{
			System.out.println("The message is sent. (" + theTime + ")");
		}
		else
		{
			System.out.println("Could not sent, there was a problem/there is no such a contact");
		}
	}

}
