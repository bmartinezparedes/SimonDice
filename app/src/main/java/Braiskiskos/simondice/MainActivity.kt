package Braiskiskos.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
            mostrarRoonda()
            ejecutarSecuencia()
        }


    }
    private fun mostrarRoonda(){
        Log.i("Estado","Mostrar Numero de Rondas")
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