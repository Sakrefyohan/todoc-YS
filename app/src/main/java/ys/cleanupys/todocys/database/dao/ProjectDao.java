package ys.cleanupys.todocys.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import ys.cleanupys.todocys.model.Project;

import java.util.List;

@Dao
public interface ProjectDao {
    @Query("SELECT * FROM Project")
    LiveData<List<Project>> getProjects();

    @Insert
    void insertProject(Project... pProjects);
}
