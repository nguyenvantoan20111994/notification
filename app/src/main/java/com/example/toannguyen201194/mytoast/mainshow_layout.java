package com.example.toannguyen201194.mytoast;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;

import java.io.IOException;

/**
 * Created by toannguyen201194 on 05/05/2016.
 */
public class mainshow_layout extends AppCompatActivity {
    Intent emailintent;
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    String[]auto={"android","java","html","ruby","css","ios","swift"};
    ArrayAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainshow_layout);
        Button btnsend =(Button) findViewById(R.id.btnsend);
        autoCompleteTextView=(AutoCompleteTextView) findViewById(R.id.txtautext);
        multiAutoCompleteTextView=(MultiAutoCompleteTextView) findViewById(R.id.mutitext);
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,auto);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendemail();
            }
        });
    }
    public void sendemail() {
        emailintent = new Intent(Intent.ACTION_SEND);
        emailintent.setData(Uri.parse("mailto:"));
        emailintent.setType("text/plain");
        emailintent.putExtra(Intent.EXTRA_EMAIL, "");
        emailintent.putExtra(Intent.EXTRA_CC, "");
        emailintent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailintent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
        startActivity(Intent.createChooser(emailintent, "Send email..."));
        finish();
    }
}
