package com.example.roomdatabase.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;

@Entity(tableName = "student_details")
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String studName;
    private String studLastName;
    private String studDept;

    public Student(String studName, String studLastName, String studDept) {
        this.studName = studName;
        this.studLastName = studLastName;
        this.studDept = studDept;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudLastName() {
        return studLastName;
    }

    public void setStudLastName(String studLastName) {
        this.studLastName = studLastName;
    }

    public String getStudDept() {
        return studDept;
    }

    public void setStudDept(String studDept) {
        this.studDept = studDept;
    }
}
