package ys.cleanupys.todocys.injection;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ys.cleanupys.todocys.repositories.ProjectDataRepository;
import ys.cleanupys.todocys.repositories.TaskDataRepository;
import ys.cleanupys.todocys.viewmodel.TaskViewModel;

import java.util.concurrent.Executor;

public class ViewModelFactory implements ViewModelProvider.Factory{

    private final ProjectDataRepository mProjectDataSource;
    private final TaskDataRepository mTaskDataSource;
    private final Executor mExecutor;

    public  ViewModelFactory(ProjectDataRepository mProjectDataSource, TaskDataRepository mTaskDataSource, Executor mExecutor){

        this.mProjectDataSource = mProjectDataSource;
        this.mTaskDataSource = mTaskDataSource;
        this.mExecutor = mExecutor;

    }


    @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            if (modelClass.isAssignableFrom(TaskViewModel.class)) {
                return (T) new TaskViewModel(mProjectDataSource, mTaskDataSource, mExecutor);
            }
            throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
