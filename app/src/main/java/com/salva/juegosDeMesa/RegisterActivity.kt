package com.salva.juegosDeMesa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.salva.juegosDeMesa.model.DataHolder
import com.salva.juegosDeMesa.model.Usuario
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    var TAG = "MiApp"
 lateinit var email1 : String
    lateinit var pass1: String
    private lateinit var auth: FirebaseAuth
    val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        Picasso.get().load(DataHolder.icono).into(icono)
        Picasso.get().load(DataHolder.fondo).into(fondo)
        register2.setOnClickListener() {
           // if (pass.text.toString() == pass2.text.toString() && email != null) {
                email1 = email.text.toString()
                pass1 = pass.text.toString()
                signup()
           // }

        }
    }
        fun signup () {
            if (pass.text.toString() == pass2.text.toString() && pass.text.toString().length >= 6) {
                auth = FirebaseAuth.getInstance()
                auth.createUserWithEmailAndPassword(email1, pass1)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val usuario = Usuario()
                            usuario.pass = pass1

                            usuario.email = email1
                            usuario.name = name.text.toString()
                            usuario.id = auth.currentUser?.uid
                            db.collection("users").add(usuario)
                                .addOnSuccessListener { documentReference ->

                                    startActivity(Intent(this, HomeActivity::class.java))
                                    finish()
                                }.addOnFailureListener { e ->
                                Log.w(TAG, "Error", e)
                            }
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success")
                            val user = auth.currentUser

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()

                        }

                    }
            }else{
                errortxt.text = "usuario inválido"
            }

        }

    }

