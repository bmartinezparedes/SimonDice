package Braiskiskos.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var contadorRondas:Int=0
    var secuencia= arrayOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val empezarPartida: Button = findViewById(R.id.bJugar)
        empezarPartida.setOnClickListener {
            //Aqui iria lo que ejecutaria darle empezar a partida
            Log.i("Estado","Boton Jugar pulsado")
            mostrarRonda()
            //creo la variable job para despues poder pausar la corrutina o pararla
            val job= GlobalScope.launch(Dispatchers.Main){
                //llamo al metodo ejecutar Secuencia para que me ejecute el juego
                ejecutarSecuencia()
            }
        }
    }

    private fun mostrarRonda(){
        contadorRondas++ //suma uno al contador
        Log.i("Estado","Mostrar Numero de Rondas")
        val t:TextView=findViewById(R.id.numeroRonda)
        t.setText("Ronda: "+contadorRondas.toString())
        t.visibility=TextView.VISIBLE
        //añadimos un valor al array
        secuencia+=Random.nextInt(1, 4)
        Log.i("Estado","Aumento Array")
        Log.i("Estado","Fin metodo mostrar ronda")
    }
    suspend fun ejecutarSecuencia(){
        /*con lo del log voy comprobando */
        Log.i("Estado","Se ejecuta el juego")
        delay(3000L)
        Log.i("Estado","Despues de delay")
        //hace secuencia
        Toast.makeText(applicationContext, "Ronda en marcha", Toast.LENGTH_SHORT).show()
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