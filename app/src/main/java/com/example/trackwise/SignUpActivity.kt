package com.example.trackwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        val signupbutton = findViewById<Button>(R.id.signupbtn)
        val name = findViewById<EditText>(R.id.name)
        val email=findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)




        signupbutton.setOnClickListener {
            val etname = name.text.toString()
            val etemail = email.text.toString()
            val pass = password.text.toString()

            val user = User(etname, etemail,pass)
            database = FirebaseDatabase.getInstance().getReference("users")

            database.child(etname).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"user Registered", Toast.LENGTH_LONG).show()


            }.addOnSuccessListener {
                Toast.makeText(this,"Failed", Toast.LENGTH_LONG).show()
            }

        }
        val  signIntext = findViewById<TextView>(R.id.signin)
        signIntext.setOnClickListener {
            val opensigninactivity = Intent(this,SignInActivity::class.java)
            startActivity(opensigninactivity)
        }

        val checkBoxButton = findViewById<CheckBox>(R.id.checkBox)
        checkBoxButton.setOnClickListener {
            if (checkBoxButton.isChecked){

            }else{
               // checkBoxButton.buttonTintList = getColorStateList(R.color.blue)
                Toast.makeText(this,"please accept the T&C", Toast.LENGTH_LONG).show()
            }
        }

    }
}