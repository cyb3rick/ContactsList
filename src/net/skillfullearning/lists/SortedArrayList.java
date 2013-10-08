package net.skillfullearning.lists;

import java.util.ArrayList;
import java.util.Iterator;

import net.skillfullearning.contactslist.Contact;

public class SortedArrayList implements SortedList<Contact> {
	
	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	@Override 
	public Iterator<Contact> iterator() {
		return contacts.iterator();
	}

	/**
	 * Add
	 * Inserts a new contact into the list 
	 * in a way that the resulting list contains 
	 * a sorted collection of contacts.
	 * 
	 * It doesn't allow insertion of contacts
	 * with equal firstname and lastname.
	 */
	public boolean add(Contact obj) {
		// If the list is empty, add it.
		if (isEmpty()) { 
			contacts.add(obj);
			return true;
		}
		// Otherwise
		else { 
			// Get list's iterator
			Iterator<Contact> it = iterator();
			
			// Initialize index 
			int position = 0; // where the new element is to be inserted
			
			do {				
				// Compare new contact with next contact in the list
				int result = obj.compareTo(it.next());
				
				
				// If equal, don't add new element, return false
				if (result == 0) { 					
					return false;
				}				
				
				// If greater than next one, increase index
				else if (result > 0) {
					position++;
				}
				
				// If less than next one, it is in the correct position, 
				// stop comparing to next contact
				else {
					break;
				}
				
			} while (it.hasNext());
			
			// Add new contact if it was less than next one -OR-
			// if end of list was reached
			contacts.add(position, obj);			
			return true;
		}
	}

	@Override
	public int size() {
		return contacts.size();
	}

	@Override
	public boolean remove(Contact obj) {
		return contacts.remove(obj);		
	}

	@Override
	public boolean remove(int index) {
		try {
			contacts.remove(index);
		} catch(Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public int removeAll(Contact obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact get(int index) {		
		return contacts.get(index);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Contact e) {
		return contacts.contains(e);
	}

	@Override
	public boolean isEmpty() {
		return contacts.size() == 0;
	}

	@Override
	public Iterator<Contact> iterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int firstIndex(Contact e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndex(Contact e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}