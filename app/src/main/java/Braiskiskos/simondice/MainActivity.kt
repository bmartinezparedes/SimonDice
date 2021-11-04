package Braiskiskos.simondice

import android.graphics.Color
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
            GlobalScope.launch(Dispatchers.Main) {
                //llamo al metodo ejecutar Secuencia para que me ejecute el juego
                ejecutarSecuencia()
                mensajeUsuario(2)
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
        mensajeUsuario(1)
        /*con lo del log voy comprobando */
        Log.i("Estado","Se ejecuta el juego")
        delay(3000L)
        Log.i("Estado","Despues de delay")
        //hace secuencia
        for (b in secuencia){
            when{
                b==1->{val bVerde: Button = findViewById(R.id.bVerde)
                    bVerde.setBackgroundColor(Color.parseColor("#0E5005"))
                }
                b==2->{val bRojo: Button = findViewById(R.id.bRojo)
                    bRojo.setBackgroundColor(Color.parseColor("#FF0400"))
                }
                b==3->{val bAmarillo: Button = findViewById(R.id.bAmarillo)
                    bAmarillo.setBackgroundColor(Color.parseColor("#F4FF00"))
                }
                b==4->{val bAzul: Button = findViewById(R.id.bAzul)
                    bAzul.setBackgroundColor(Color.parseColor("#0016FF"))
                }
            }

        }

        //secuencia usuario
    }
    private fun mensajeUsuario(key:Int){
        Log.i("Estado","Mensaje por toast al usuario")
        val mensaje =when{
            key==1->"Ronda en marcha"
            key==2->"Tu turno"
            else ->""
        }
        Toast.makeText(this.applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }
    private fun comprobarSecuencia():Boolean{
        Log.i("Estado","Comprobar que la secuencia del jugador coincide")
        if(contadorRondas!=10){
          return true
        }else{
            //fin del juego
            contadorRondas=0
            return false
        }
    }
}