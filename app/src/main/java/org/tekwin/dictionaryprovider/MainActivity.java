package org.tekwin.dictionaryprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the TextView which will be populated with the Dictionary ContentProvider data.
        ListView dictListView = (ListView) findViewById(R.id.dictionary_list_view);


        // Get the ContentResolver which will send a message to the ContentProvider
        ContentResolver resolver = getContentResolver();


        // Get a Cursor containing all of the rows in the Words table
        Cursor cursor = resolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);


        // For the SimpleCursorAdapter to match the UserDictionary columns to layout items.
          String[] COLUMNS_TO_BE_BOUND  = new String[] {
                UserDictionary.Words.WORD,
                UserDictionary.Words.FREQUENCY
        };

        int[] LAYOUT_ITEMS_TO_FILL = new int[] {
                android.R.id.text1,
                android.R.id.text2
        };

        // Set the Adapter to fill the standard two_line_list_item layout with data from the Cursor.
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                                          android.R.layout.two_line_list_item,
                                          cursor, COLUMNS_TO_BE_BOUND,
                                          LAYOUT_ITEMS_TO_FILL, 0);

        dictListView.setAdapter(adapter);

        // Don't forget to attach the adapter to the ListView
    }
}




