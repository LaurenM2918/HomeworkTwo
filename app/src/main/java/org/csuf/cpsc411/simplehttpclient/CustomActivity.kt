package org.csuf.cpsc411.simplehttpclient
//Lauren Martinez
//AssignmentTwo
//Implemented on Top of the Code from 10-29
//Person = Claim
//Person Service = ClaimService
//Due 11/26/2020

import android.app.Person
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.loopj.android.http.AsyncHttpClient

class CustomActivity : AppCompatActivity() {

    lateinit var cList :MutableList<Person>
    lateinit var cService: PersonService


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val fldRowGenerator = ObjDetailScreenGenerator(this)
        val colView = fldRowGenerator.generate()
        setContentView(colView)


        val cView: EditText = findViewById(R.id.claim_title)
        val dView: EditText = findViewById(R.id.claim_date)
        val addButtonView : Button = findViewById(R.id.add_btn)

        addButtonView.setOnClickListener{
            var pClaim = Person(cView.text.toString(),dView.text.toString())
            cService.addClaim(pClaim)
            cView.text.clear()
            dView.text.clear()
        }

        cService = PersonService(this)
        cService.getAll()

    }
}