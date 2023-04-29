package com.example.roomdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee-table")
data class EmployeeEntity(

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var name : String = "",
    //name of the column if you want to specify(optional)
    @ColumnInfo(name = "email-id")
    var email : String = ""
)
