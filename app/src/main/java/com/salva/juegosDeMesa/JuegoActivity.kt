package com.salva.juegosDeMesa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.salva.juegosDeMesa.model.DataHolder
import com.salva.juegosDeMesa.model.JuegosDeMesa
import com.salva.juegosDeMesa.model.Usuario
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_juego.*
import kotlinx.android.synthetic.main.activity_juego.fondo1



class JuegoActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()
    var auth = FirebaseAuth.getInstance()
    val TAG = "MiApp"
    var myUser: Usuario = Usuario()
    var newGame = JuegosDeMesa()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
 title = DataHolder.currentGames.title


        Picasso.get().load(DataHolder.fondo).into(fondo1)
        Picasso.get().load(DataHolder.currentGames.boardGameImage).into(juego)
        titulo.text = DataHolder.currentGames.title
       lifecycle.addObserver(youtube_player_view)

        descripcion.text = DataHolder.currentGames.description
        favs.setOnClickListener() {
            Log.d(TAG , auth.currentUser?.uid.toString())
            if (DataHolder.currentGames.isfavourite == false) {

                newTask(auth.currentUser?.uid.toString())
               DataHolder.currentGames.isfavourite = true

              DataHolder.favoritos.add(DataHolder.currentGames)

            }
             else {
                DataHolder.currentGames.isfavourite = false

                DataHolder.favoritos.remove( DataHolder.currentGames)
            }
            Toast.makeText(
                baseContext, "Añadido con éxito", Toast.LENGTH_SHORT
            ).show()

        }
        wishes.setOnClickListener() {
            if ( DataHolder.currentGames.isWish == false) {
                newWish(auth.currentUser?.uid.toString())
                DataHolder.currentGames.isWish = true

                DataHolder.listaDeDeseos.add( DataHolder.currentGames)
            } else {
                DataHolder.currentGames.isWish = false

                DataHolder.listaDeDeseos.remove( DataHolder.currentGames)
            }
            Toast.makeText(
                baseContext, "Añadido con éxito", Toast.LENGTH_SHORT
            ).show()

        }
        myjuego.setOnClickListener() {
            if ( DataHolder.currentGames.isMyBoardGame == false) {
                newMyGame(auth.currentUser?.uid.toString())
                DataHolder.currentGames.isMyBoardGame = true

                DataHolder.misJuegosDeMesa.add( DataHolder.currentGames)
            } else {
                DataHolder.currentGames.isMyBoardGame = false

                DataHolder.misJuegosDeMesa.remove( DataHolder.currentGames)

            }
            Toast.makeText(
                baseContext, "Añadido con éxito", Toast.LENGTH_SHORT
            ).show()

        }
        youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = DataHolder.currentGames.idYT
                youTubePlayer.cueVideo(videoId ,0f)
            }

            override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {
                super.onCurrentSecond(youTubePlayer, second)
                val second : Float = second
            }


        })
    }

    fun newTask(id: String) {
        newGame.title = DataHolder.currentGames.title
        newGame.description = DataHolder.currentGames.description
        newGame.numMaxPlayer =  DataHolder.currentGames.numMaxPlayer
        newGame.numMinPlayers  =  DataHolder.currentGames.numMinPlayers
        newGame.duration  =  DataHolder.currentGames.duration
        newGame.boardGameImage = DataHolder.currentGames.boardGameImage
        Log.d(TAG , "se añadio creo el juego para el fb")
        db.collection("users").document(id).collection("favoritos").add(newGame)
            .addOnSuccessListener {
                Log.d(TAG , "se añadio el juego")

            }
            .addOnFailureListener { e ->
                Log.d(TAG , "pero que ha pachao?")
                Log.w(TAG, "Error writing document", e)
            }
    }
    fun newWish(id: String) {
        newGame.title = DataHolder.currentGames.title
        newGame.description = DataHolder.currentGames.description
        newGame.numMaxPlayer =  DataHolder.currentGames.numMaxPlayer
        newGame.numMinPlayers  =  DataHolder.currentGames.numMinPlayers
        newGame.duration  =  DataHolder.currentGames.duration
        newGame.boardGameImage = DataHolder.currentGames.boardGameImage
        Log.d(TAG , "se añadio creo el juego para el fb")
        db.collection("users").document(id).collection("lista de deseos").add(newGame)
            .addOnSuccessListener {
                Log.d(TAG , "se añadio el juego")

            }
            .addOnFailureListener { e ->
                Log.d(TAG , "pero que ha pachao?")
                Log.w(TAG, "Error writing document", e)
            }
    }
    fun newMyGame(id: String) {
        newGame.title = DataHolder.currentGames.title
        newGame.description = DataHolder.currentGames.description
        newGame.numMaxPlayer =  DataHolder.currentGames.numMaxPlayer
        newGame.numMinPlayers  =  DataHolder.currentGames.numMinPlayers
        newGame.duration  =  DataHolder.currentGames.duration
        newGame.boardGameImage = DataHolder.currentGames.boardGameImage
        Log.d(TAG , "se añadio creo el juego para el fb")
        db.collection("users").document(id).collection("mis juegos").add(newGame)
            .addOnSuccessListener {
                Log.d(TAG , "se añadio el juego")

            }
            .addOnFailureListener { e ->
                Log.d(TAG , "pero que ha pachao?")
                Log.w(TAG, "Error writing document", e)
            }
    }
}




