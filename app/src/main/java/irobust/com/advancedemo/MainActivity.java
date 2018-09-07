package irobust.com.advancedemo;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private static final int MENU_LOGOUT = 9999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button btn = (Button) findViewById(R.id.btnTest);
        TextView txt = (TextView) findViewById(R.id.txtHello);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);

        registerForContextMenu(layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(0, MENU_LOGOUT, 105, "Logout");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.action_settings:
                Toast.makeText( this,
                                "Select settings menu",
                                 Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_about:
                Toast.makeText( this,
                                "Select about menu",
                                 Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_shopping:
                Toast.makeText(this, "Select shopping menu", Toast.LENGTH_SHORT).show();
                return true;
            case MENU_LOGOUT:
                Toast.makeText(this,
                                "Customer need to logout",
                                Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_context_help:
                Toast.makeText( this,
                                "Open Help on browser",
                                Toast.LENGTH_LONG).show();

                return true;
            case R.id.action_context_delete:
                Toast.makeText( this,
                                "Delete this item",
                                Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    public void showPopup(View view){
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.getMenuInflater().inflate(R.menu.context_menu,
                                        popup.getMenu());
        popup.show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch(id){
            case R.id.action_context_help:
                Toast.makeText(MainActivity.this,
                        "Help Click",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_context_delete:
                Toast.makeText(MainActivity.this,
                        "Delete Click",
                        Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
