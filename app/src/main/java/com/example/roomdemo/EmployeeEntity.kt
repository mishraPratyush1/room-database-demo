package com.example.roomdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee-table")
data class EmployeeEntity(

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val name : String = "",
    //name of the column if you want to specify(optional)
    @ColumnInfo(name = "email-id")
    val email : String = ""
)
