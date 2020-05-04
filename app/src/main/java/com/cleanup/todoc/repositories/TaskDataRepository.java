package com.cleanup.todoc.repositories;

import androidx.lifecycle.LiveData;


import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskDataRepository {

    private TaskDao  mTaskDao;

    public TaskDataRepository(TaskDao mTaskDao) { this.mTaskDao = mTaskDao; }

    public LiveData<List<Task>> getTasks() { return mTaskDao.getTasks(); }

    public void createTask(Task mTask) { mTaskDao.insertTask(mTask); }

    public void deleteTask(Task mTask) { mTaskDao.deleteTask(mTask); }
}
