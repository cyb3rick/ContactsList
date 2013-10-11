package net.skillfullearning.contactslist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Main Activity
 * Handles all operations relating a Contact
 * @author cyb
 */
public class ContactManager extends Activity {
	
	private ListView listview = null;
	private ArrayList<String> list = null;
	private MyArrayAdapter adapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		
		// Init the list view
		listview = (ListView) findViewById(R.id.listView);
		
		// Data
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
	        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
	        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
	        "Android", "iPhone", "WindowsMobile" };

		// Put data in a list (TODO: Get values from ContactStore)
	    list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	    	list.add(values[i]);
	    }
	    
	    // Set custom array adapter
	    adapter = new MyArrayAdapter(this, list);
	    listview.setAdapter(adapter);
	    
	    // Attach click listener for items and define behavior
	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	    	
	    	@Override
	    	public void onItemClick(AdapterView<?> parent, final View view,
	    			int position, long id) {	    	  
	    		// TODO: Open activity with contact index
	    		
	    		// Get clicked item
	    		final String item = (String) parent.getItemAtPosition(position);
	    		
	    		// Remove item from the list. TODO: Display Edit Activity instead of removing it
	    		list.remove(item);
	    		
	    		// Let the adapter know of changes in underlying data structure
	    		adapter.notifyDataSetChanged(); 
	    	}
	    });
	    
	    // Search bar
	    final EditText searchContactEditText = (EditText) findViewById(R.id.searchContactEditText);
	    searchContactEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
				//ContactManager.this.adapter.getFilter().filter(cs);
				// TODO: Implement custom filter method?
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
			}
		});
	  }
	  
	  private class MyArrayAdapter extends ArrayAdapter<String> {		

		  private final ArrayList<String> values;
		  private final LayoutInflater inflater;
		  
		  public MyArrayAdapter(Context context, ArrayList<String> values) {
			  super(context, R.layout.item_layout, values);
			  this.values = values;
			  this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);			  
		  }

		  @Override
		  public View getView(int position, View convertView, ViewGroup parent) {
			 
			  if (convertView == null) {
				  convertView = inflater.inflate(R.layout.item_layout, parent, false);
			  }
			  
			  ((TextView) convertView.findViewById(R.id.full_name)).setText(values.get(position));
			  ((ImageView) convertView.findViewById(R.id.quickContactBadge)).setImageResource(R.drawable.ic_launcher);			  		    
			  			  
			  return convertView;
		    
		  }
	  }	  
} 