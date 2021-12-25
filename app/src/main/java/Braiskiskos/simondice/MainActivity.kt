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
    var secuenciaComprobar=arrayOf<Int>()
    private var contadorSecuencia:Int=0
    var compo=true
    var jugador=false
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
                empezarPartida.visibility=Button.INVISIBLE
                ejecutarSecuencia()
                mensajeUsuario(2)
                jugador=true
            }
        }
        val bVerde:Button=findViewById(R.id.bVerde)
        bVerde.setOnClickListener{
            if(jugador) {
                secuenciaComprobar += 1

                Log.i("Estado", "PULSADO verde")
                if (secuencia.size == secuenciaComprobar.size) {
                    comprobarSecuencia()
                } else {
                    finalizarPartida()
                }
            }
        }
        val bRojo:Button=findViewById(R.id.bRojo)
        bRojo.setOnClickListener{
            if(jugador) {
                secuenciaComprobar += 2

                Log.i("Estado", "PULSADO rojo")
                if (secuencia.size == secuenciaComprobar.size) {
                    comprobarSecuencia()
                } else {
                    finalizarPartida()
                }
            }
        }
        val bAmarillo:Button=findViewById(R.id.bAmarillo)
        bAmarillo.setOnClickListener{
            if(jugador) {
                secuenciaComprobar += 3

                Log.i("Estado", "PULSADO amarillo")
                if (secuencia.size == secuenciaComprobar.size) {
                    comprobarSecuencia()
                } else {
                    finalizarPartida()
                }
            }
        }
        val bAzul:Button=findViewById(R.id.bAzul)
        bAzul.setOnClickListener{
            if(jugador) {
                secuenciaComprobar += 4

                Log.i("Estado", "PULSADO azul")
                if (secuencia.size == secuenciaComprobar.size) {
                    comprobarSecuencia()
                } else {
                    finalizarPartida()
                }
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
        //hace secuencia
        for (b in secuencia){
            when{
                b==1->{val bVerde: Button = findViewById(R.id.bVerde)
                    bVerde.setBackgroundColor(Color.parseColor("#0E5005"))
                    delay(1000L)
                    bVerde.setBackgroundColor(Color.parseColor("#179205"))
                    delay(1000L)
                    Log.i("Estado","Verde")
                }
                b==2->{val bRojo: Button = findViewById(R.id.bRojo)
                    bRojo.setBackgroundColor(Color.parseColor("#FF0400"))
                    delay(1000L)
                    bRojo.setBackgroundColor(Color.parseColor("#C50505"))
                    delay(1000L)
                    Log.i("Estado","ROjo")
                }
                b==3->{val bAmarillo: Button = findViewById(R.id.bAmarillo)
                    bAmarillo.setBackgroundColor(Color.parseColor("#747408"))
                    delay(1000L)
                    bAmarillo.setBackgroundColor(Color.parseColor("#FFFE00"))
                    delay(1000L)
                    Log.i("Estado","Amarillo")
                }
                b==4->{val bAzul: Button = findViewById(R.id.bAzul)
                    bAzul.setBackgroundColor(Color.parseColor("#032BFE"))
                    delay(1000L)
                    bAzul.setBackgroundColor(Color.parseColor("#03FEED"))
                    delay(1000L)
                    Log.i("Estado","Azul")
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
            key==3->"Bien"
            else ->"mal"
        }
        Toast.makeText(this.applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }
    private fun comprobarSecuencia() {
        Log.i("Estado","Comprobar la secuencia del jugador")
        for(s in secuencia){
            if(s==secuenciaComprobar.get(contadorSecuencia)){
                Log.i("Estado",s.toString()+" "+secuenciaComprobar.get(contadorSecuencia))
                contadorSecuencia++

            }else{
                Log.i("Estado","No coincide")
                mensajeUsuario(4)
                compo=false
            }
        }

        if(compo){
            Log.i("Estado","siguiente ronda")
            jugador=false
            mostrarRonda()
            mensajeUsuario(3)
            contadorSecuencia=0
            secuenciaComprobar=arrayOf()
            corrutina()
        }else{
            jugador=false
            finalizarPartida()
        }
    }

    private fun finalizarPartida(){
        Log.i("Estado","Fin Partida")
        secuencia= arrayOf()
        secuenciaComprobar=arrayOf()
        contadorRondas=0
        compo=true
        val t:TextView=findViewById(R.id.numeroRonda)
        t.visibility=TextView.INVISIBLE
        val empezarPartida: Button = findViewById(R.id.bJugar)
        empezarPartida.visibility=Button.VISIBLE
    }
    fun corrutina(){
        GlobalScope.launch(Dispatchers.Main) {
            //llamo al metodo ejecutar Secuencia para que me ejecute el juego
            ejecutarSecuencia()
            mensajeUsuario(2)
            jugador=true
        }
    }
}