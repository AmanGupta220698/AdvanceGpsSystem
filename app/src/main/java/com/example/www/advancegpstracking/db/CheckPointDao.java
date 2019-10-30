package com.example.www.advancegpstracking.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CheckPointDao {
  @Query("Select * from checkpoints") List<CheckPoint> getAllCheckPoints();

  @Query("Select count(*) from checkpoints") int getCount();

  @Insert
  long insertNewCheckPoint(CheckPoint checkPoint);

  @Update
  int updateCheckPoint(CheckPoint checkPoint);

  @Delete
  void deleteCheckPoint(CheckPoint checkPoint);
}
