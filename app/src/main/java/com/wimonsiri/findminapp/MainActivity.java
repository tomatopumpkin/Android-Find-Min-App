package com.wimonsiri.findminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnClear , btnMin , btnAdd ;
    EditText numText ;
    TextView labelShow ; //น้องเหลือง

    final String message = "Value Number Add :";
    int count = 0 , min , numArray[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMin = (Button) findViewById(R.id.btnMin);
        btnClear = (Button) findViewById(R.id.btnClear);

        labelShow = (TextView) findViewById(R.id.labelShow);
        numText = (EditText)  findViewById(R.id.numText);

        btnAdd.setOnClickListener(this);
        btnMin.setOnClickListener(this);
        btnClear.setOnClickListener(this);


        btnMin.setEnabled(false);
        btnClear.setEnabled(false);

        numArray = new int[5];

    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btnAdd){
//            Toast.makeText(this , "Add Button" , Toast.LENGTH_LONG).show();
            if(count == 0){
                btnMin.setEnabled(true);
                btnClear.setEnabled(true);
            }

            numArray[count] = Integer.parseInt(numText.getText().toString());
            labelShow.setText(labelShow.getText().toString() + "\n -> " + numText.getText().toString());

            numText.setText("");
            count++;
            if (count == numArray.length){
                btnAdd.setEnabled(false);
                Toast.makeText(this, "Add 5 Number " , Toast.LENGTH_LONG).show();
            }
        }
            else if (v.getId() == R.id.btnMin){
                min = findMin();
                Toast.makeText(this , "Minimum number : " + min , Toast.LENGTH_LONG).show();
        }
            else if (v.getId() == R.id.btnClear){
                numText.setText("");
                labelShow.setText(message);
                btnMin.setEnabled(false);
                btnClear.setEnabled(false);
                btnAdd.setEnabled(true);
                count = 0;


        }
    }

    public int findMin(){
        int min = numArray[0]; //min ตัวคนเดียว
        for(int i = 1; i < count; i++){
            if(min > numArray[i]) min = numArray[i];
        }
        return min;
    }
}