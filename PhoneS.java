package youtube.toruko.phone;

import java.util.ArrayList;

public interface PhoneS {
	public void ShowContacts();
	public void AddContact(ArrayList<String> names, ArrayList<String> numbers);
	public void AddContact(String name, String number);
	public void DeleteContact(String name);
	public void SearchContact(String name);
}
