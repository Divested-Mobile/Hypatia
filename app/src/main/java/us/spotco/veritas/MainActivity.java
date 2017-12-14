package us.spotco.veritas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean scanSystem = true;
    private boolean scanApps = true;
    private boolean scanInternal = true;
    private boolean scanExternal = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView logView = findViewById(R.id.txtLogOutput);
        logView.append("Copyright 2017 Spot Communications, Inc.\n");
        logView.append("License: GPLv3\n");
        logView.append("Powered by ClamAV signatures, License: GPLv3\n");

        final MalwareScanner scanner = new MalwareScanner(this, logView);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!scanner.isScannerRunning()) {
                    scanner.startScanner(scanSystem, scanApps, scanInternal, scanExternal);
                } else {
                    scanner.stopScanner();
                }
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
        switch (item.getItemId()) {
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
