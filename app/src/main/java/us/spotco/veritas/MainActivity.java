package us.spotco.veritas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private boolean scanSystem = true;
    private boolean scanApps = true;
    private boolean scanInternal = true;
    private boolean scanExternal = true;

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
                Snackbar.make(view, "COMMENCING SCAN!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.mnuScanSystem:
                scanSystem = !item.isChecked();
                break;
            case R.id.mnuScanApps:
                scanApps = !item.isChecked();
                break;
            case R.id.mnuScanInternal:
                scanInternal = !item.isChecked();
                break;
            case R.id.mnuScanExternal:
                scanExternal = !item.isChecked();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
