package com.example.jetpackapplication.model

import android.widget.Switch
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _text= mutableStateOf("")
    val text: State<String> =_text

    private val _texto= mutableStateOf("")
    val texto: State<String> =_texto

    private val _nombre = mutableStateOf("")
    val nombre : State<String> = _nombre

    val _modelocarro = mutableStateOf("")
    val modelocarro : State<String> = _modelocarro

    private val _val = mutableStateOf(0.0)
    val valor:State<Double> = _val

    private val _descuento = mutableStateOf(0)
    val descuento : State<Int> = _descuento

    private val _enganche = mutableStateOf(0.0)
    val enganche:State<Double> = _enganche

    private val _precio1 = mutableStateOf(758956.33)
    val precio1 : State<Double> = _precio1

    private val _precio2 = mutableStateOf(429368.92)
    val precio2 : State<Double> = _precio2

    private val _precio3 = mutableStateOf(964283.48)
    val precio3 : State<Double> = _precio3

    private val _precio4 = mutableStateOf(642937.30)
    val precio4 : State<Double> = _precio4


    private val _descuentoengan20 = mutableStateOf(20)
    val descuentoen20 : State<Int> = _descuentoengan20

    private val _descuentoengan40 = mutableStateOf(40)
    val descuentoen40 : State<Int> = _descuentoengan40

    private val _descuentoengan60 = mutableStateOf(60)
    val descuentoen60 : State<Int> = _descuentoengan60

    private val _financiamiento = mutableStateOf(0.0)
    val financiamiento:State<Double> = _financiamiento

    private val _anual = mutableStateOf(0)
    val anual:State<Int> = _anual

    private val _plazo = mutableStateOf("")
    val plazo:State<String> = _plazo

    private val _interes = mutableStateOf(0.0)
    val interes:State<Double> = _interes

    private val _tasa = mutableStateOf(0.0)
    val tasa :State<Double> = _tasa

    private val _total = mutableStateOf(0.0)
    val total:State<Double> = _total

    private val _meses = mutableStateOf(0)
    val meses : State<Int> = _meses

    private val _pagodemes = mutableStateOf(0.0)
    val pagodemes : State<Double> = _pagodemes

    val pagomensual:State<Double> = _pagodemes

    private val _preciototal = mutableStateOf(0.0)
    val preciototal : State<Double> = _preciototal


    fun definirnombre(nombre : String)
    {
        _nombre.value = nombre
    }

    fun definirModelo(modelo: String)
    {
        _modelocarro.value = modelo
    }

    fun carro1()
    {
        _modelocarro.value = "Honda Civic = $ ${_precio1.value.toString()}"
        _val.value = _precio1.value
    }

    fun carro2()
    {
        _modelocarro.value = "Volkswagen Golf = $ ${_precio2.value.toString()}"
        _val.value = _precio2.value
    }

    fun carro3()
    {
        _modelocarro.value = "BMW X5 =   $ ${_precio3.value.toString()}"
        _val.value = _precio3.value

    }

    fun carro4()
    {
        _modelocarro.value = "Mazda CX7 =   $ ${_precio4.value.toString()}"
        _val.value = _precio4.value

    }

    fun descuento20()
    {
        _descuento.value = _descuentoengan20.value
        calEnganche(_descuento.value,_val.value)
    }

    fun descuento40()
    {
        _descuento.value = _descuentoengan40.value
        calEnganche(_descuento.value,_val.value)
    }

    fun descuento60()
    {
        _descuento.value = _descuentoengan60.value
        calEnganche(_descuento.value,_val.value)
    }

    fun calEnganche(porce:Int,valor:Double)
    {
        _enganche.value = porce * valor / 100
        Financiamiento(_val.value,_enganche.value)
    }

    fun Financiamiento(valor: Double, enganche:Double)
    {
        _financiamiento.value = valor - enganche
    }

    fun calInteres(tasa:Double, financiamiento:Double, anios:Int)
    {
        _interes.value = tasa * financiamiento / 100 * anios
        caltotal()
    }

    fun plan1anual()
    {
        _plazo.value = "1 año, tasa 7.5%"
        _anual.value = 1
        _tasa.value = 7.5
        _meses.value = 12
        calInteres(_tasa.value,_financiamiento.value,_anual.value)
    }

    fun plan2anual()
    {
        _plazo.value = "2 años, tasa 9.5%"
        _anual.value = 2
        _tasa.value = 9.5
        _meses.value = 24
        calInteres(_tasa.value,_financiamiento.value,_anual.value)

    }


    fun plan3anual()
    {
        _plazo.value = "3 años, tasa 10.3%"
        _anual.value = 3
        _tasa.value = 10.3
        _meses.value = 36
        calInteres(_tasa.value,_financiamiento.value,_anual.value)

    }


    fun plan4anual()
    {
        _plazo.value = "4 años, tasa 12.6%"
        _anual.value = 4
        _tasa.value = 12.6
        _meses.value = 48
        calInteres(_tasa.value,_financiamiento.value,_anual.value)

    }


    fun plan5anual(){
        _plazo.value = "5 años, tasa 13.5%"
        _anual.value = 5
        _tasa.value = 13.5
        _meses.value = 60
        calInteres(_tasa.value,_financiamiento.value,_anual.value)

    }

    fun caltotal()
    {
        _total.value = _financiamiento.value + _interes.value
        _pagodemes.value = _total.value / _meses.value
    }

    fun selectmarca(index:Int){
        when (index) {
            0 -> carro1()
            1 -> carro2()
            2 -> carro3()
            3 -> carro4()
            else -> {
                null
            }
        }
    }

    fun selectporcentaje(index: Int){
        when (index) {
            0 -> descuento20()
            1 -> descuento40()
            2 -> descuento60()
            else -> {
                print("")
            }
        }
    }

    fun selectinanciamiento(index: Int){
        when (index) {
            0 -> plan1anual()
            1 -> plan2anual()
            2 -> plan3anual()
            3 -> plan4anual()
            4 -> plan5anual()

            else -> {
                null
            }
        }
    }

    fun reset()
    {
        _nombre.value = ""
        _modelocarro.value = ""
        _descuento.value = 0
        _enganche.value = 0.0
        _financiamiento.value = 0.0
        _plazo.value = ""
        _anual.value = 0
        _interes.value = 0.0
        _total.value = 0.0
        _pagodemes.value = 0.0
        fun definirnombre() = ""
    }

}