package mx.edu.ittepic.ladm_u2_practica3_renteriareyes_hilosysemaforos

import android.graphics.Color
import kotlinx.android.synthetic.main.activity_main.*

class JugadorUno(p:MainActivity) : Thread(){
    var puntero = p
    var iniciado = false
    var pausa = false

    override fun run() {
        super.run()
        iniciado = true
        while(iniciado){
            while (puntero.turno <=4) {
                sleep(2000)
                if (!pausa) {
                    puntero.runOnUiThread {
                        puntero.txtViewTurnoUno.setText("TIRANDO...")
                        puntero.txtViewTurnoUno.setTextColor(Color.rgb(23,131,204))
                        puntero.txtViewTurnoCuatro.setTextColor(Color.DKGRAY)
                        puntero.txtViewTurnoDos.setText("ESPERANDO...")
                        puntero.txtViewTurnoTres.setText("ESPERANDO...")
                        puntero.txtViewTurnoCuatro.setText("ESPERANDO...")
                        puntero.imgPlayerCuatro.setImageResource(R.drawable.jcuatro)
                        puntero.imgPlayerUno.setImageResource(R.drawable.junocolor)
                        puntero.lanzarDados()
                        puntero.textPuntosUno.setText((puntero.textPuntosUno.text.toString().toInt() + puntero.sumaPuntos).toString())
                        puntero.setTitle("Turno: Jugador 1")
                        sleep(1000)
                        puntero.playerUno!!.pausar()
                        puntero.turno++

                        puntero.iniciarSegundoJugador()

                    }
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