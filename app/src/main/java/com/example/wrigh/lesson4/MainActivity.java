package com.example.wrigh.lesson4;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //各種宣言
        Button button =(Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        mTextView = (TextView)findViewById(R.id.textView);

    }

    @Override
    public void onClick(View v){
        //ボタン1つしかないけど
        if(v.getId()==R.id.button){
            showTimePickerDialog();
        }


    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI",String.valueOf(hourOfDay)+":"+String.valueOf(minute));
                        if(hourOfDay>=2&&hourOfDay<=9){
                            mTextView.setText("おはよう");
                        }
                        else if(hourOfDay>=10&&hourOfDay<=17){
                            mTextView.setText("こんにちは");
                        }
                        else{
                            mTextView.setText("こんばんは");
                        }
                    }
                },0,0,true);
        timePickerDialog.show();
    }
}
