package com.example.example_roomdb.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface DataDao : BaseDao<DataEntity> {
    @Query("SELECT * FROM data_table WHERE id = :id")
    fun selectById(id : Long) : Array<DataEntity>

    @Query("SELECT * FROM data_table")
    fun selectAll() : Array<DataEntity>

    @Query("SELECT * FROM data_table WHERE date = :date")
    fun selectByDate(date : String) : DataEntity

    @Query("DELETE FROM data_table WHERE id = :id")
    fun deleteById(id : Long)
}