package com.example.example_roomdb.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_table")
data class DataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var title: String,
    var content: String,
    var date: String
)
