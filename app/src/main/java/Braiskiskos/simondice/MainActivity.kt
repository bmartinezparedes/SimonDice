package Braiskiskos.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomappbar.BottomAppBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var contadorRondas:Int=0
        var secuencia= arrayOf(2)//esto no esta bien
        val empezarPartida: Button = findViewById(R.id.bJugar)
        empezarPartida.setOnClickListener {
            //Aqui iria lo que ejecutaria darle empezar a partida
            Log.i("Estado","Boton Jugar pulsado")
            var contador=1
            mostrarRoonda(contador)
            ejecutarSecuencia()
        }


    }

    private fun mostrarRoonda(contador:Int){
        Log.i("Estado","Mostrar Numero de Rondas")
        val t:TextView=findViewById(R.id.numeroRonda)
        t.setText("Ronda: "+contador.toString())

    }
    private fun ejecutarSecuencia(){
        Log.i("Estado","Se ejecuta el juego")
    }
    private fun mensajeUsuario(){
        Log.i("Estado","Mensaje por toast al usuario")
    }
    private fun comprobarSecuencia(){
        Log.i("Estado","Comprobar que la secuencia del jugador coincide")
    }
}