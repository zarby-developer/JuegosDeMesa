package com.salva.juegosDeMesa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.salva.juegosDeMesa.model.DataHolder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*

import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.bgg
import kotlinx.android.synthetic.main.activity_splash.*

class ProfileActivity : AppCompatActivity() {
    val db = FirebaseAuth.getInstance()
    var TAG = "MiApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        Picasso.get().load(DataHolder.icono).into(bgg)
        Picasso.get().load(DataHolder.fondo).into(fondo1)
        close.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            val goToLogin = Intent(this, MainActivity::class.java)
            startActivity(goToLogin)
            finish()

        }
    }
}
