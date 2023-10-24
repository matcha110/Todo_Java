package com.todoapp.viewmodel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;

import com.todoapp.AppComponent;
import com.todoapp.db.TaskDAO;
import com.todoapp.db.TaskEntity;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

/**
 * タスクのデータをデータレイヤーから取得して保持する。
 * UIに対して公開する。
 */
public class TaskViewModel extends AndroidViewModel {
    public TaskDAO mTaskDAO;
    private List<TaskEntity> mTasks;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        mTaskDAO = ((AppComponent)application).getDatabase().taskDAO();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Flowable<List<String>> getTaskTextList() {
        return mTaskDAO.getAll()
                .map(tasks -> {
                    mTasks = tasks;
                    return tasks.stream()
                            .map(task -> task.getText())
                            .collect(Collectors.toList());
                });
    }

    /**
     *
     * @param text タスクのテキスト
     * @return
     */
    public Completable insertTask(String text) {
        TaskEntity task = new TaskEntity();
        task.setText(text);
        return mTaskDAO.insert(task);
    }

    /**
     *
     * @param position 削除したいタスクのリスト内のインデックス
     * @return
     */
    public Completable deleteTask(int position) {
        return mTaskDAO.delete(mTasks.get(position));
    }
}
