package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdatabase.Room.MyDatabase;
import com.example.roomdatabase.Room.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText firstName, lastName, deptName, etUpdateName, etUpdateId;
    Button insertData, btnRead, btnUpdate, btnDelete;
    TextView tvDisp, lastNameDisp, deptDisp, idDisp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.etName);
        lastName = (EditText) findViewById(R.id.etLastName);
        deptName = (EditText) findViewById(R.id.etDept);
        etUpdateName = (EditText) findViewById(R.id.updateName);
        etUpdateId = (EditText) findViewById(R.id.updateId);
        insertData = (Button) findViewById(R.id.btnInsert);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        tvDisp = (TextView) findViewById(R.id.tvDisplay);
        lastNameDisp = (TextView) findViewById(R.id.tvLastNameDisp);

        MyDatabase myDatabase = Room.databaseBuilder(MainActivity.this, MyDatabase.class, "StudentDB")
                .allowMainThreadQueries().build();

        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Student student = new Student(firstName.getText().toString(), lastName.getText().toString(), deptName.getText().toString());
                    myDatabase.dao().insertDB(student);
                    Toast.makeText(MainActivity.this, "Insertion Success", Toast.LENGTH_SHORT).show();
                }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> studentArrayList = myDatabase.dao().readData();
                for (int i = 0; i < studentArrayList.size(); i++){
                    Student student = studentArrayList.get(i);
                    tvDisp.setText(student.getStudName());
                    lastNameDisp.setText(student.getStudLastName());
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String upName = etUpdateName.getText().toString();
                String upId = etUpdateId.getText().toString();
                if (upName.isEmpty() || upId.isEmpty()){
                    Toast.makeText(MainActivity.this, "Values Empty!", Toast.LENGTH_SHORT).show();
                } else {
                    myDatabase.dao().updateDB(upName, Integer.parseInt(upId));
                    Toast.makeText(MainActivity.this, "Update Success", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deleteId = etUpdateId.getText().toString();
                if (deleteId.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Values Empty!", Toast.LENGTH_SHORT).show();
                } else {
                    myDatabase.dao().deleteDB(Integer.parseInt(deleteId));
                    Toast.makeText(MainActivity.this, "Deletion Success", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}