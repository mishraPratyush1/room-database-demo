package com.example.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.roomdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var viewBinding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)

        val employeeDao = (applicationContext as EmployeeApp).db.EmployeeDao()
        viewBinding?.btnAdd?.setOnClickListener {
            //TODO call add record with employeedao
            addRecord(employeeDao)

        }
    }
    fun addRecord(EmployeeDao : EmployeeDao){
        val name = viewBinding?.etName?.text.toString()
        val email = viewBinding?.etEmail?.text.toString()

        if(name.isNotEmpty() && email.isNotEmpty()){
            lifecycleScope.launch {
                EmployeeDao.insert(EmployeeEntity(name=name, email=email))

                Toast.makeText(applicationContext,"Record Saved",Toast.LENGTH_SHORT).show()

                viewBinding?.etName?.text?.clear()
                viewBinding?.etEmail?.text?.clear()
             }
        }else{
            Toast.makeText(applicationContext,"Name or email cannot be empty",Toast.LENGTH_SHORT).show()

        }
    }
}