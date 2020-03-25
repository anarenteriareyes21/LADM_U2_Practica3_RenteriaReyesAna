package mx.edu.ittepic.ladm_u2_practica3_renteriareyes_hilosysemaforos

import android.app.AlertDialog
import android.graphics.Color
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class JugadorDos(p:MainActivity) : Thread() {
    private var puntero = p
    private var iniciado = false
    private var pausa = true

    override fun run() {
        super.run()
        iniciado = true
        while(iniciado){
            sleep(2000)
            if(!pausa){
                puntero.runOnUiThread {
                    puntero.txtViewTurnoDos.setText("TIRANDO...")
                    puntero.txtViewTurnoDos.setTextColor(Color.rgb(23,131,204))
                    puntero.txtViewTurnoUno.setTextColor(Color.DKGRAY)
                    puntero.txtViewTurnoUno.setText("ESPERANDO...")
                    puntero.txtViewTurnoTres.setText("ESPERANDO...")
                    puntero.txtViewTurnoCuatro.setText("ESPERANDO...")
                    puntero.imgPlayerUno.setImageResource(R.drawable.juno)
                    puntero.imgPlayerDos.setImageResource(R.drawable.jdoscolor)
                    puntero.lanzarDados()
                    puntero.textPuntosDos.setText((puntero.textPuntosDos.text.toString().toInt() + puntero.sumaPuntos).toString())
                    puntero.setTitle(" Turno: Jugador 2")
                    sleep(1000)
                    puntero.playerDos!!.pausar()

                    puntero.iniciarTercerJugador()
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




}