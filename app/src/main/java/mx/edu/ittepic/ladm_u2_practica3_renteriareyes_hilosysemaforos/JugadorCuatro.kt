package mx.edu.ittepic.ladm_u2_practica3_renteriareyes_hilosysemaforos

import android.graphics.Color
import kotlinx.android.synthetic.main.activity_main.*

class JugadorCuatro (p:MainActivity) : Thread(){
    var puntero = p
    var iniciado = false
    var pausa = true

    override fun run() {
        super.run()
        iniciado = true
        while(iniciado){
            sleep(3000)
            if(!pausa){
                puntero.runOnUiThread {
                    puntero.txtViewTurnoCuatro.setText("TIRANDO...")
                    puntero.txtViewTurnoCuatro.setTextColor(Color.rgb(23,131,204))
                    puntero.txtViewTurnoTres.setTextColor(Color.DKGRAY)
                    puntero.txtViewTurnoUno.setText("ESPERANDO...")
                    puntero.txtViewTurnoDos.setText("ESPERANDO...")
                    puntero.txtViewTurnoTres.setText("ESPERANDO...")
                    puntero.imgPlayerTres.setImageResource(R.drawable.jtres)
                    puntero.imgPlayerCuatro.setImageResource(R.drawable.jcuatrocolor)
                    puntero.lanzarDados()
                    puntero.textPuntosCuatro.setText((puntero.textPuntosCuatro.text.toString().toInt() + puntero.sumaPuntos).toString())
                    puntero.setTitle("Turno: Jugador 4")
                    sleep(1000)
                    puntero.playerCuatro!!.pausar()

                    puntero.playerUno!!.despausar()
                    if(puntero.turno>4){
                        puntero.txtViewTurnoCuatro.setText("ESPERANDO...")
                        puntero.txtViewTurnoCuatro.setTextColor(Color.DKGRAY)
                        puntero.imgPlayerCuatro.setImageResource(R.drawable.jcuatro)
                        puntero.final1=puntero.textPuntosUno.text.toString().toInt()
                        puntero.final2=puntero.textPuntosDos.text.toString().toInt()
                        puntero.final3=puntero.textPuntosTres.text.toString().toInt()
                        puntero.final4=puntero.textPuntosCuatro.text.toString().toInt()
                        puntero.puntosFinales.add(puntero.final1)
                        puntero.puntosFinales.add(puntero.final2)
                        puntero.puntosFinales.add(puntero.final3)
                        puntero.puntosFinales.add(puntero.final4)

                        puntero.elegirPuntosFinales()
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