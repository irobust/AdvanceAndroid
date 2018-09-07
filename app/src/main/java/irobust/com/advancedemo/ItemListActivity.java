package irobust.com.advancedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import irobust.com.advancedemo.adapter.ProductListAdapter;

public class ItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        String[] items = getResources()
                            .getStringArray(R.array.items);
        ProductListAdapter adapter = new ProductListAdapter(this,
                                                    R.layout.list_items, items);
        ListView lvItems = (ListView) findViewById(R.id.lvItems);
        lvItems.setAdapter(adapter);
    }
}
