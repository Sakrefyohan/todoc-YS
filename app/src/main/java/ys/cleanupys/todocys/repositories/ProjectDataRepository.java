package ys.cleanupys.todocys.repositories;

import androidx.lifecycle.LiveData;

import ys.cleanupys.todocys.database.dao.ProjectDao;
import ys.cleanupys.todocys.model.Project;

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
