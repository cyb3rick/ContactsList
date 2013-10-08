package net.skillfullearning.contactslist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author cyb
 */
public class ContactManager extends Activity {

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_listview);

	    final ListView listview = (ListView) findViewById(R.id.listView);
	    String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
	        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
	        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
	        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
	        "Android", "iPhone", "WindowsMobile" };

	    final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	    	list.add(values[i]);
	    }
	    //final StableArrayAdapter adapter = new StableArrayAdapter(this,
	    	//	android.R.layout.simple_list_item_1, list);
	    final StableArrayAdapter adapter = new StableArrayAdapter(this, list);
	    listview.setAdapter(adapter);
	    
	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	    	
	    	@Override
	    	public void onItemClick(AdapterView<?> parent, final View view,
	    			int position, long id) {	    	  
	    		// TODO: Open activity with contact index
	    		
	    		// Get clicked item
	    		final String item = (String) parent.getItemAtPosition(position);
	    		
	    		// Remove item from the list. TODO: Display Edit Activity instead of removing it
	    		list.remove(item);
	    		
	    		Toast.makeText(getBaseContext(), "Deleting?", Toast.LENGTH_LONG).show();

	    		// Let the adapter know of changes in underlying data structure
	    		adapter.notifyDataSetChanged(); 
	    	}
	    });
	  }
	  
	  private class StableArrayAdapter extends ArrayAdapter<String> {		
		  
		  private final Context context;
		  //private final String[] values;
		  private final ArrayList<String> values;
		  
		  public StableArrayAdapter(Context context, ArrayList<String> values) {
			  super(context, R.layout.row_layout, values);
			  this.context = context;
			  this.values = values;
		  }

		  @Override
		  public View getView(int position, View convertView, ViewGroup parent) {
		    
			  LayoutInflater inflater = (LayoutInflater) context
					  .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			  View rowView = inflater.inflate(R.layout.row_layout, parent, false);
			  
			  TextView textView = (TextView) rowView.findViewById(R.id.full_name);
			  ImageView imageView = (ImageView) rowView.findViewById(R.id.quickContactBadge);
			  textView.setText(values.get(position));		    
			  imageView.setImageResource(R.drawable.ic_launcher);
			  
			  return rowView;
		  }
		  
		  
	  }	  
} 