package com.example.roomdatabase.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DAO {

    @Insert
    public void insertDB(Student student);

    @Query("select * from student_details")
    List<Student> readData();

    @Query("update student_details set studName = :stuName where id = :studID")
    void updateDB(String stuName, int studID);

    @Query("delete from student_details where id = :studID")
    void deleteDB(int studID);
}
