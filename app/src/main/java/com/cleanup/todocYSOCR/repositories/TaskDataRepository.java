package com.cleanup.todocYSOCR.repositories;

import androidx.lifecycle.LiveData;


import com.cleanup.todocYSOCR.database.dao.TaskDao;
import com.cleanup.todocYSOCR.model.Task;

import java.util.List;

public class TaskDataRepository {

    private TaskDao  mTaskDao;

    public TaskDataRepository(TaskDao mTaskDao) { this.mTaskDao = mTaskDao; }

    public LiveData<List<Task>> getTasks() { return mTaskDao.getTasks(); }

    public void createTask(Task mTask) { mTaskDao.insertTask(mTask); }

    public void deleteTask(Task mTask) { mTaskDao.deleteTask(mTask); }
}
