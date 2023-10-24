package com.todoapp.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

//タスクのエンティティにアクセスする
//読み取り、追加、削除、（更新）
@Dao
public interface TaskDAO {
    @Query("SELECT * FROM tasks")
    Flowable<List<TaskEntity>> getAll();

    @Insert
    Completable insert(TaskEntity task);

    @Delete
    Completable delete(TaskEntity task);
}