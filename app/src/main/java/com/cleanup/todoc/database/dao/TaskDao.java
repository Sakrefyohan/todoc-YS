package com.cleanup.todoc.database.dao;

import android.content.ClipData;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cleanup.todoc.model.Task;

import java.util.List;

public interface TaskDao {

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getTask();

    @Insert
    long insertTask(Task pTask);

    @Update
    int updateItem(Task pTask);

    @Delete
    int deleteItem(Task pTask);
}
