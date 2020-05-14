package com.cleanup.todocYSOCR.repositories;

import androidx.lifecycle.LiveData;

import com.cleanup.todocYSOCR.database.dao.ProjectDao;
import com.cleanup.todocYSOCR.model.Project;

import java.util.List;

public class ProjectDataRepository {

    private ProjectDao mProjectDao;

    public ProjectDataRepository(ProjectDao mProjectDao) {
        this.mProjectDao = mProjectDao;
    }

    public LiveData<List<Project>> getProjects() {
        return mProjectDao.getProjects();
    }
}
