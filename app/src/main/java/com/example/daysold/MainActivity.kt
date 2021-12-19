package com.example.daysold

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn1 = findViewById<Button>(R.id.buttondate)
        btn1.setOnClickListener { view ->
            click(view)
        }
    }
    fun click(view: View){
        var dates=findViewById<TextView>(R.id.dates)
        var age=findViewById<TextView>(R.id.age)
        val myCalandar = Calendar.getInstance()
        val year=myCalandar.get(Calendar.YEAR)
        val month=myCalandar.get(Calendar.MONTH)
        val day = myCalandar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
            view, Syear, Smonth, Sdayofmonth ->
            val selected="$Sdayofmonth/${Smonth+1}/${Syear}"
            dates.setText(selected)
            val sdf =SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate=sdf.parse(selected)
            val sel = theDate!!.time/87600000//1000*60*60*24
            val current = sdf.parse(sdf.format(System.currentTimeMillis()))
            val curr=current!!.time/87600000//1000*60*60*24
            val diff=curr-sel
            age.setText("You are "+diff.toString()+" days old")

        }
        ,year
        ,month
        ,day).show()
    }
}
