package com.example.shivrana.shivrana_comp304_assingment03;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayAdapter<String> adp;
    Intent intent,intent2,intent3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.selectionList);
        adp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.list));
        list.setAdapter(adp);

        intent = new Intent(this,DrawingActivity.class);
        intent2 = new Intent(this,FrameAnimation.class);
        intent3 = new Intent(this,TweenActivity.class);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               switch (parent.getItemAtPosition(position).toString()){
                   case "Drawing":
                       startActivity(intent);
                       break;
                   case "Framed Animation":
                       startActivity(intent2);
                       break;
                    case "Tweened Animation":
                        startActivity(intent3);
                        break;
               }
            }
        });

    }
}
