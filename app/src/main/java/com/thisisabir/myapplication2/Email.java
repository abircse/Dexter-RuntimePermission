package com.thisisabir.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends AppCompatActivity {

    private EditText to,subject,details;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        to = findViewById(R.id.tobox);
        subject = findViewById(R.id.subjectbox);
        details = findViewById(R.id.detailsbox);
        send = findViewById(R.id.SEND);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // this code will be used for send email
                String TO = to.getText().toString();
                String SUBJECT = subject.getText().toString();
                String MESSAGE = details.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{TO});
                intent.putExtra(Intent.EXTRA_SUBJECT,SUBJECT);
                intent.putExtra(Intent.EXTRA_TEXT,MESSAGE);
                intent.setType("message/rfc228");
                startActivity(Intent.createChooser(intent,"Select you Email App"));



            }
        });

    }
}
