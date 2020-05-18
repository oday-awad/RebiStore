package net.rebi.estore.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import net.rebi.estore.R;

public class SplashScreen extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.splash_screen );

        handler = new Handler ( );
        handler.postDelayed ( new Runnable ( ) {
            @Override
            public void run ( ) {
                int term = 1;
                try {
                    Intent i;
                    if ( term == 1 ) {
                        i = new Intent ( getBaseContext ( ) , Main.class );
                    }
                    else {
                        i = new Intent ( getBaseContext ( ) , Main.class );
                    }
                    startActivity ( i );
                    finish ( );

                }
                catch ( Exception e ) {
                    e.printStackTrace ( );
                    Intent i;
                    if ( term == 1 ) {
                        i = new Intent ( getBaseContext ( ) , Main.class );
                    }
                    else {
                        i = new Intent ( getBaseContext ( ) , Main.class );
                    }
                    startActivity ( i );
                    finish ( );

                }
            }
        } , 3500 );


    }

    @Override
    public void onBackPressed ( ) {

        //        super.onBackPressed ( );
    }


}
