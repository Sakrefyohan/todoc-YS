package ys.cleanupys.todocys.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import ys.cleanupys.todocys.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getTasks();

    @Insert
    long insertTask(Task pTask);

    @Update
    int updateTask(Task pTask);

    @Delete
    int deleteTask(Task pTask);
}
