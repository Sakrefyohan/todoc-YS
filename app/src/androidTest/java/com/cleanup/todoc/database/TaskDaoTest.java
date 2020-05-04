package com.cleanup.todoc.database;


import android.view.contentcapture.DataRemovalRequest;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class TaskDaoTest {

    // FOR DATA
    private TodocDatabase mDatabase;

    private Project[] mListProjects = Project.getAllProjects();
    private List<Task> mTasks;
    private List<Project> mProjects;

    private Task mTaskTest1 = new Task(mListProjects[0].getId(),"Test 1",new Date().getTime());
    private Task mTaskTest2 = new Task(mListProjects[1].getId(),"Test 2",new Date().getTime());



    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void initDb() throws Exception {
        //todo: check deprecated params
        this.mDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
               TodocDatabase.class)
                .allowMainThreadQueries()
                .build();
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }

    @Test
    public void insertTask() throws InterruptedException{
        mDatabase.TaskDao().insertTask(mTaskTest1);

        mTasks = LiveDataTestUtil.getValue(mDatabase.TaskDao().getTasks());
        assertEquals(1, mTasks.size());

        assertEquals(mTaskTest1.getName(),mTasks.get(0).getName());
        assertEquals(mProjects.get(0).getName(),mTaskTest1.getProject().getName());
    }

    @Test
    public void deleteTasks() throws InterruptedException {
        mDatabase.TaskDao().insertTask(mTaskTest1);
        mDatabase.TaskDao().insertTask(mTaskTest2);

        mTasks = LiveDataTestUtil.getValue(mDatabase.TaskDao().getTasks());

        assertEquals(2,mTasks.size());

        assertEquals(mTaskTest1.getName(),mTasks.get(0).getName());
        assertEquals(mTaskTest2.getName(),mTasks.get(1).getName());
        assertEquals(mProjects.get(0).getName(), mTaskTest1.getProject().getName());
        assertEquals(mProjects.get(1).getName(), mTaskTest2.getProject().getName());

        mDatabase.TaskDao().deleteTask(mTasks.get(0));
        mTasks = LiveDataTestUtil.getValue(mDatabase.TaskDao().getTasks());
        assertEquals(1,mTasks.size());

        assertEquals(mTaskTest2.getName(),mTasks.get(0).getName());
        assertEquals(mProjects.get(1).getName(), mTaskTest2.getProject().getName());
    }

    //todo: finish checkProject Test
    @Test
    public void checkProject(){}
}
