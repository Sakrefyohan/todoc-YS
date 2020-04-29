package com.cleanup.todoc.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import com.cleanup.todoc.model.Project;

import java.util.List;

public interface ProjectDao {
    @Query("SELECT * FROM Project")
    LiveData<List<Project>> getProjects();

    @Insert
    void insertProject(Project... pProjects);
}