package com.gg.sample.secure;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gg.secure.keygenerator.KeyStoreKeyGenerator;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String key = "default";
        try {
            key = KeyStoreKeyGenerator.get((Application)getApplicationContext(), "testname").loadOrGenerateKeys();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((TextView)findViewById(android.R.id.text1)).setText(key);
    }
}
