package ys.cleanupys.todocys.repositories;

import androidx.lifecycle.LiveData;


import ys.cleanupys.todocys.database.dao.TaskDao;
import ys.cleanupys.todocys.model.Task;

import java.util.List;

public class TaskDataRepository {

    private TaskDao  mTaskDao;

    public TaskDataRepository(TaskDao mTaskDao) { this.mTaskDao = mTaskDao; }

    public LiveData<List<Task>> getTasks() { return mTaskDao.getTasks(); }

    public void createTask(Task mTask) { mTaskDao.insertTask(mTask); }

    public void deleteTask(Task mTask) { mTaskDao.deleteTask(mTask); }
}
