package com.visualizerbd.threadexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;



public class MainActivity extends ActionBarActivity {

     Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView txtChangeMe = (TextView) findViewById(R.id.txtChangeMe);
            txtChangeMe.setText("How could you do that o_O");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void clickWaitAndChange( View view ){

        Runnable r = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis() + 10000;
                while( System.currentTimeMillis() < futureTime ){
                    synchronized (this){
                        try {
                            wait( 10000 );
                        } catch (Exception e){
                            // Do Something
                        }
                    }
                }
                handler.sendEmptyMessage(0);
            }
        };

        Thread theThread = new Thread(r);
        theThread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
