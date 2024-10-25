package com.example.shared_preferences;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    Button btn_search;
    TextView msv;
    CheckBox checkBox;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_search = findViewById(R.id.btn_search);
        msv= findViewById(R.id.msv);
        checkBox = findViewById(R.id.checkBox);
        sharedPreferences = getSharedPreferences("dataSearch",MODE_PRIVATE);
        msv.setText(sharedPreferences.getString("msv",""));
        checkBox.setChecked(sharedPreferences.getBoolean("checked",false));
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (msv.getText().toString().trim().equals("22115053122107"))
                {
                    Toast.makeText(MainActivity.this,"Tìm thấy sinh viên",Toast.LENGTH_SHORT).show();
                    if(checkBox.isChecked())
                    {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("msv",msv.getText().toString());
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }
                    else
                    {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("msv");
                        editor.remove("checked");
                        editor.commit();
                    }
                    startActivity(new Intent(MainActivity.this, Thongtinsinhvien.class));
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Không tìm thấy sinh viên",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}