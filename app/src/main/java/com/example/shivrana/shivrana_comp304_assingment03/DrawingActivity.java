package com.example.shivrana.shivrana_comp304_assingment03;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class DrawingActivity extends AppCompatActivity {
    Bitmap bitmap;
    Canvas canvas;
    ImageView imageView;
    Paint paint;
    EditText xEditView,yEditView;
    Spinner spinner;
    RadioGroup radioGroup;

     static int x=0;
     static int y =300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        declaration();

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adp.addAll(getResources().getStringArray(R.array.spinner));
        spinner.setAdapter(adp);

        imageView.setImageBitmap(bitmap);
        imageView.setVisibility(imageView.VISIBLE);

        paint.setColor(getResources().getColor(android.R.color.holo_purple));
        paint.setStrokeWidth(15);

        y = findViewById(R.id.relativeLayout).getHeight() + 10;

        colorSelection();
        keyListeners();
        spinnerEvent();
    }

    public void declaration(){
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        imageView = findViewById(R.id.reusableImage);
        paint = new Paint();

        xEditView = findViewById(R.id.xEditView);
        xEditView.setText(String.valueOf(0));
        xEditView.setFocusable(false);

        yEditView = findViewById(R.id.yEditText);
        yEditView.setText(String.valueOf(0));
        yEditView.setFocusable(false);

        spinner = findViewById(R.id.LTSpinner);

        radioGroup = findViewById(R.id.ColorRadioGrp);
    }

    public void drawLine(Canvas canvas){
        //canvas.drawLine(startX,startY,endX,endY,paint);
        canvas.drawPoint(x,y,paint);
    }

    public void keyListeners(){
        findViewById(R.id.Clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        findViewById(R.id.up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y = y-5;

                drawLine(canvas);
                yEditView.setText(String.valueOf(y));
            }
        });
        findViewById(R.id.down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y = y +5;
                drawLine(canvas);
                yEditView.setText(String.valueOf(y));
            }
        });
        findViewById(R.id.right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = x+5;
                drawLine(canvas);
                xEditView.setText(String.valueOf(x));
            }
        });
        findViewById(R.id.left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = x-5;
                drawLine(canvas);
                xEditView.setText(String.valueOf(x));
            }
        });
    }

    public void colorSelection(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (((RadioButton) findViewById(checkedId)).getText().toString()){
                    case "Red":
                        paint.setColor(getResources().getColor(R.color.Red));
                        break;
                    case "Green":
                        paint.setColor(getResources().getColor(R.color.Green));
                        break;
                    case "Blue":
                        paint.setColor(getResources().getColor(R.color.Blue));
                        break;
                    default:
                        Toast.makeText(DrawingActivity.this, "Please select one of the Color", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void spinnerEvent(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paint.setStrokeWidth(Integer.parseInt(parent.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
