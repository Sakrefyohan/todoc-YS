package com.cleanup.todocYS.viewmodel;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cleanup.todocYS.model.Project;
import com.cleanup.todocYS.model.Task;
import com.cleanup.todocYS.repositories.ProjectDataRepository;
import com.cleanup.todocYS.repositories.TaskDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class TaskViewModel extends ViewModel {

    private final ProjectDataRepository mProjectDataSource;
    private final TaskDataRepository mTaskDataSource;
    private final Executor mExecutor;

    @Nullable
    private LiveData<List<Project>> mProjects;

    public TaskViewModel(ProjectDataRepository mProjectDataSource, TaskDataRepository mTaskDataSource, Executor mExecutor) {

        this.mProjectDataSource = mProjectDataSource;
        this.mTaskDataSource = mTaskDataSource;
        this.mExecutor = mExecutor;
    }

    public void init(){
            if (mProjects == null)
                mProjects = mProjectDataSource.getProjects();

    }

    @Nullable
    public LiveData<List<Project>> getProjects() {
        return mProjects;
    }

    public LiveData<List<Task>> getTasks() { return mTaskDataSource.getTasks(); }

    public void createTask(Task task) {
        mExecutor.execute(() -> mTaskDataSource.createTask(task));
    }

    public void deleteTask(Task task) {
        mExecutor.execute(() -> mTaskDataSource.deleteTask(task));
    }


}

