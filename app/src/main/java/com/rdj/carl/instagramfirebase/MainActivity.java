package com.rdj.carl.instagramfirebase;

import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.crash.FirebaseCrash;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText etNumber1;
    private EditText etNumber2;
    private Button bDivide;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber1 = (EditText) findViewById(R.id.etNumber1);
        etNumber2 = (EditText) findViewById(R.id.etNumber2);
        bDivide = (Button) findViewById(R.id.bDivide);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    public void divide(View view){
        int n1 = Integer.parseInt(etNumber1.getText().toString());
        int n2 = Integer.parseInt(etNumber2.getText().toString());

        try {
            tvResult.append(String.valueOf(n1/n2));
        }catch (NumberFormatException nfe){
            //Log.e(TAG, "NumberFormatException");
            FirebaseCrash.report(nfe);
            FirebaseCrash.log("log/Ocurrió un NumberFormatException");
            FirebaseCrash.logcat(Log.ERROR, TAG, "logcat/Ocurrió un NumberFormatException");
            nfe.printStackTrace();
        }catch (NullPointerException npe){
            //Log.e(TAG, "NullPointerException");
            FirebaseCrash.report(npe);
            FirebaseCrash.log("log/Ocurrió un NullPointerException");
            FirebaseCrash.logcat(Log.ERROR, TAG, "logcat/Ocurrió un NullPointerException");
            npe.printStackTrace();
        }catch (Exception e){
            //Log.e(TAG, "Exception");
            FirebaseCrash.report(e);
            FirebaseCrash.log("log/Ocurrió un Exception");
            FirebaseCrash.logcat(Log.ERROR, TAG, "logcat/Ocurrió un Exception");
            e.printStackTrace();
        }

    }
}
