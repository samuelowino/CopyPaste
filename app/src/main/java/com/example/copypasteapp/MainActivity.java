package com.example.copypasteapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_copy,btn_paste;
    TextView txttext;
    EditText ettext;
    ClipboardManager clipboardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_copy = findViewById(R.id.btn_copy);
        btn_paste = findViewById(R.id.btn_paste);
        txttext = findViewById(R.id.textDisplay);
        ettext = findViewById(R.id.textWrite);

        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);


        if(!clipboardManager.hasPrimaryClip())
        {
            btn_paste.setEnabled(false);

        }

        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = ettext.getText().toString();

                if(!text.equals( ""))
                {
                    ClipData clipData = ClipData.newPlainText("text", text);
                    clipboardManager.setPrimaryClip(clipData);

                    ClipData clipData1 = ClipData.n


                    Toast.makeText(MainActivity.this,"Copied",Toast.LENGTH_SHORT ).show();
                    btn_paste.setEnabled(true);
                }
            }
        });


        btn_paste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData clipData = clipboardManager.getPrimaryClip();
                ClipData.Item item = clipData.getItemAt(0);


                txttext.setText(item.getText().toString());

                Toast.makeText(MainActivity.this,"Pasted",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
