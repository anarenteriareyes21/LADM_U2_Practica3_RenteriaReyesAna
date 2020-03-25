package mx.edu.ittepic.ladm_u2_practica3_renteriareyes_hilosysemaforos

import android.graphics.Color
import kotlinx.android.synthetic.main.activity_main.*

class JugadorTres (p:MainActivity) : Thread(){
    var puntero = p
    var iniciado = false
    var pausa = true

    override fun run() {
        super.run()
        iniciado = true
        while(iniciado){
            sleep(2000)
            if(!pausa){
                puntero.runOnUiThread {
                    puntero.txtViewTurnoTres.setText("TIRANDO...")
                    puntero.txtViewTurnoTres.setTextColor(Color.rgb(23,131,204))
                    puntero.txtViewTurnoDos.setTextColor(Color.DKGRAY)
                    puntero.txtViewTurnoUno.setText("ESPERANDO...")
                    puntero.txtViewTurnoDos.setText("ESPERANDO...")
                    puntero.txtViewTurnoCuatro.setText("ESPERANDO...")
                    puntero.imgPlayerDos.setImageResource(R.drawable.jdos)
                    puntero.imgPlayerTres.setImageResource(R.drawable.jtrescolor)
                    puntero.lanzarDados()
                    puntero.textPuntosTres.setText((puntero.textPuntosTres.text.toString().toInt() + puntero.sumaPuntos).toString())
                    puntero.setTitle("Turno: Jugador 3")
                    sleep(1000)
                    puntero.playerTres!!.pausar()

                    puntero.iniciarCuartoJugador()

                }
            }
        }

    }

    fun estaIniciado(): Boolean {
        return iniciado == true
    }

    fun pausar() {
        pausa = true
    }

    fun despausar() {
        pausa = false
    }

    fun detener() {
        iniciado = false
    }


}//class