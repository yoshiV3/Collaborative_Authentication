package com.project.collaborativeauthentication.android.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.Constants;
import com.project.collaborativeauthentication.android.presenter_implementations.CustomHomePresenter;
import com.project.collaborativeauthentication.android.presenter_interfaces.HomePresenter;
import com.project.collaborativeauthentication.android.view_interfaces.HomeView;
import com.project.collaborativeauthentication.android.presenter_interfaces.ViewController;
import com.project.collaborativeauthentication.android.presenter_interfaces.ViewStarter;

public class MainActivity extends AppCompatActivity implements HomeView {


    private final HomePresenter presenter;

    private boolean visibilityStopAuthenticationServiceOption  = false;
    private boolean visibilityStartAuthenticationServiceOption = false;
    private boolean visibilityBluetoothOption                  = false;


    public MainActivity()
    {
        MainActivity  currentView = this;
        this.presenter = new CustomHomePresenter
                (
                        this,
                        (ViewStarter) () -> {
                            Intent intent = new Intent(currentView, DistributedKeyGenerationActivity.class);
                            currentView.startActivity(intent);
                        },
                        (ViewStarter) () -> {
                            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                            startActivityForResult(enableIntent, Constants.BT_REQUEST_CODE);

                        },
                        new ViewController() {
                            @Override
                            public void stopView()
                            {
                                Intent intent = new Intent(currentView, AuthenticationForegroundService.class);
                                intent.setAction(Constants.STOP_ACTION);
                                startForegroundService(intent);
                            }

                            @Override
                            public void startNewView()
                            {
                                Intent intent = new Intent(currentView, AuthenticationForegroundService.class);
                                intent.setAction(Constants.START_ACTION);
                                startForegroundService(intent);
                            }
                        }
                );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainActivity currentView = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter.onStartAuthenticationService();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode == Constants.BT_REQUEST_CODE)
        {
            this.presenter.bluetoothResult(resultCode);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onClickDistributedKeyGenerationButton(View view)
    {
        presenter.onStartDistributedKeyGeneration();
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
        presenter.onPrepareOptionsMenu();

        MenuItem stop      = menu.findItem(R.id.listener_stop);
        MenuItem start     = menu.findItem(R.id.listener_start);
        MenuItem bluetooth = menu.findItem(R.id.enable_bluetooth);

        stop.setVisible(visibilityStopAuthenticationServiceOption);
        start.setVisible(visibilityStartAuthenticationServiceOption);
        bluetooth.setVisible(visibilityBluetoothOption);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId)
        {
            case R.id.listener_stop:
                this.presenter.onStopAuthenticationService();
                break;
            case R.id.listener_start:
                this.presenter.onStartAuthenticationService();
                break;
            case R.id.enable_bluetooth:
                this.presenter.onEnableBluetooth();
                break;
            default:
                this.presenter.onUnsupportedAction();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void setVisibilityStopAuthenticationServiceOption(boolean visibility)
    {
        this.visibilityStopAuthenticationServiceOption = visibility;
    }

    @Override
    public void setVisibilityStartAuthenticationServiceOption(boolean visibility)
    {
        this.visibilityStartAuthenticationServiceOption = visibility;
    }

    @Override
    public void setVisibilityBluetoothOption(boolean visibility)
    {
        this.visibilityBluetoothOption = visibility;
    }

    @Override
    public void showTextOnToast(String text) {
        Toast toast = new Toast(this);
        toast.setText(text);
        toast.show();
    }
}