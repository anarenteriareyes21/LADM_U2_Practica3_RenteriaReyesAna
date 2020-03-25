package mx.edu.ittepic.ladm_u2_practica3_renteriareyes_hilosysemaforos

import android.graphics.Bitmap
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
  /*------------------ DECLARACION DE VARIABLES ------------------------*/
        //Referencias:
        var playerUno : JugadorUno?= null
        var playerDos : JugadorDos?= null
        var playerTres : JugadorTres?= null
        var playerCuatro : JugadorCuatro?= null
       //Arreglo de imagenes (caras del dado)
        var imgdados = arrayOf(
            R.drawable.uno,
            R.drawable.dos,
            R.drawable.tres,
            R.drawable.cuatro,
            R.drawable.cinco,
            R.drawable.seis
        )
        //turno
        var turno = 1
        //suma
        var sumaPuntos = 0
        //Puntos finales
        var puntosFinales = ArrayList<Int>()
        var final1 = 0
        var final2 = 0
        var final3 = 0
        var final4 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerUno=JugadorUno(this)
        playerDos= JugadorDos(this)
        playerTres= JugadorTres(this)
        playerCuatro = JugadorCuatro(this)
        btnComenzar.setOnClickListener {
           iniciarJugadores()
        }
    }

    fun iniciarJugadores(){
        playerUno!!.start()
        playerDos!!.start()
        playerTres!!.start()
        playerCuatro!!.start()
    }
    fun lanzarDados(){
        var dado1 = (0..5).random()
        var dado2 = (0..5).random()
        dadoUno.setImageResource(imgdados[dado1])
        dadoDos.setImageResource(imgdados[dado2])
        sumaPuntos = (dado1 + dado2) + 2
    }

    fun mensaje (cad:String){
        AlertDialog.Builder(this).setMessage(cad).show()
    }

    fun iniciarSegundoJugador(){
        playerDos!!.despausar()
    }

    fun iniciarTercerJugador(){
        playerTres!!.despausar()
    }

    fun iniciarCuartoJugador(){
        playerCuatro!!.despausar()
    }

    fun elegirPuntosFinales(){
        if (puntosFinales[0] == puntosFinales.max()) {
            imgPlayerUno.setImageResource(R.drawable.junocolor)
            ganadorUno.visibility = View.VISIBLE
            txtViewPlayerUno.setTextColor(Color.rgb(92,135,72))
            this.setTitle("Ganador: jugador 1")
        }
        if (puntosFinales[1] == puntosFinales.max()) {
            imgPlayerDos.setImageResource(R.drawable.jdoscolor)
            ganadorDos.visibility = View.VISIBLE
            txtViewPlayerDos.setTextColor(Color.rgb(92,135,72))
            this.setTitle("Ganador: jugador 2")
        }
        if (puntosFinales[2] == puntosFinales.max()) {
            imgPlayerTres.setImageResource(R.drawable.jtrescolor)
            ganadorTres.visibility  = View.VISIBLE
            txtViewPlayerTres.setTextColor(Color.rgb(92,135,72))
            this.setTitle("Ganador: jugador 3")
        }
        if (puntosFinales[3] == puntosFinales.max()) {
            imgPlayerCuatro.setImageResource(R.drawable.jcuatrocolor)
            ganadorCuatro.visibility  = View.VISIBLE
            txtViewPlayerCuatro.setTextColor(Color.rgb(92,135,72))
            this.setTitle("Ganador: jugador 4")
        }
    }

}
