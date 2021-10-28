package Braiskiskos.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    private var contadorRondas:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var secuencia= arrayOf(2)//esto no esta bien
        val empezarPartida: Button = findViewById(R.id.bJugar)
        empezarPartida.setOnClickListener {
            //Aqui iria lo que ejecutaria darle empezar a partida
            Log.i("Estado","Boton Jugar pulsado")
            mostrarRoonda()
            //creo la variable job para despues poder pausar la corrutina o pararla
            val job= GlobalScope.launch(Dispatchers.Main){
                //llamo al metodo ejecutar Secuencia para que me ejecute el juego
                ejecutarSecuencia()

            }
        }


    }

    private fun mostrarRoonda(){
        contadorRondas+1
        Log.i("Estado","Mostrar Numero de Rondas")
        val t:TextView=findViewById(R.id.numeroRonda)
        t.setText("Ronda: "+contadorRondas.toString())
        t.visibility=TextView.VISIBLE

    }
    suspend fun ejecutarSecuencia(){
        /*con lo del log voy comprobando */
        Log.i("Estado","Se ejecuta el juego")
        delay(3000L)
        Log.i("Estado","Despues de delay")
        //hace secuencia
        //secuencia usuario
        comprobarSecuencia()
    }
    private fun mensajeUsuario(key:Int){
        Log.i("Estado","Mensaje por toast al usuario")


    }
    private fun comprobarSecuencia(){
        Log.i("Estado","Comprobar que la secuencia del jugador coincide")
        if(0==0){
          contadorRondas+1
        }else{
            //fin del juego
            contadorRondas=0
        }
    }
}