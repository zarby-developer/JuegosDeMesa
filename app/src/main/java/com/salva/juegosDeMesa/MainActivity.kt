package com.salva.juegosDeMesa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.salva.juegosDeMesa.model.DataHolder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   // ...
// Initialize Firebase Auth
    var TAG = "MiApp"
     var auth: FirebaseAuth = FirebaseAuth.getInstance()
    var email: String = ""
    var passw: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Picasso.get().load(DataHolder.fondo).into(fondo)
        Picasso.get().load(DataHolder.icono).into(icono)
        register.setOnClickListener(){
            startActivity(Intent(this , RegisterActivity::class.java))
            finish()
        }
      enter.setOnClickListener(){
           email = name.text.toString()
           passw = pass.text.toString()
          login(email , passw)
      }
        // ...
    }  fun login(mail : String , pass: String) {
        auth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(this) { task ->
            if (task.isSuccessful){
                val user = auth.currentUser
                Log.d(TAG , "sucess")
                startActivity(Intent(this , HomeActivity::class.java))
                finish()
            }else{
                Log.w(TAG , "mal", task.exception)
                Toast.makeText(
                    baseContext, "fallo", Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}
