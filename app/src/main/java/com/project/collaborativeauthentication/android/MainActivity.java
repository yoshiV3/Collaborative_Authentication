package com.project.collaborativeauthentication.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.connector_implementation.AndroidMainConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.MainConnector;

public class MainActivity extends AppCompatActivity {


    private MainConnector connector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.connector = new AndroidMainConnector(this);
        this.connector.startAuthenticationService();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickDistributedKeyGenerationButton(View view)
    {
        Intent intent = new Intent(this, DistributedKeyGenerationActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }



    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem stop      = menu.findItem(R.id.listener_stop);
        MenuItem start     = menu.findItem(R.id.listener_start);
        MenuItem bluetooth = menu.findItem(R.id.enable_bluetooth);

        adaptVisibilityMenuItem(stop, shouldDisplayStop());
        adaptVisibilityMenuItem(start, shouldDisplayStart());
        adaptVisibilityMenuItem(bluetooth, shouldDisplayBluetooth());

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId)
        {
            case R.id.listener_stop:
                this.connector.stopAuthenticationService();
                break;
            case R.id.listener_start:
                this.connector.startAuthenticationService();
                break;
            case R.id.enable_bluetooth:
                this.connector.enableBluetooth();
                break;
            default:
                showTextWithToast("This functionality is not available on your device.");
                showTextWithToast("Please update the application");
        }
        return super.onOptionsItemSelected(item);
    }


    public void showTextWithToast(String text)
    {
        Toast toast = new Toast(this);
        toast.setText(text);
        toast.show();
    }
    /*
           PRIVATE METHODS FOR MAIN MENU
     */
    private void adaptVisibilityMenuItem(MenuItem item, boolean shouldBeDisplayed) {
        if(shouldBeDisplayed)
        {
            item.setVisible(true);
        }
        else
        {
            item.setVisible(false);
        }
    }
    private boolean shouldDisplayStop()
    {
        return this.connector.isAuthenticationServiceRunning();
    }

    private boolean shouldDisplayBluetooth()
    {
        return (!this.connector.isBluetoothEnabled() && this.connector.isBluetoothAvailable());
    }

    private boolean shouldDisplayStart()
    {
        return ((!this.connector.isAuthenticationServiceRunning()) && this.connector.isBluetoothEnabled());
    }

}