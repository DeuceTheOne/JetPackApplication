package com.example.jetpackapplication

import android.os.Bundle
import android.widget.Spinner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackapplication.model.MainViewModel
import com.example.jetpackapplication.ui.theme.JetPackApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val objeto_view_model : MainViewModel by viewModels()
        setContent {
            generarvistas(objeto_view_Model = MainViewModel())
        }
    }
}

@Composable
fun generarvistas(objeto_view_Model: MainViewModel)
{
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp, 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center)
        {
            Text(text = "Cotizador de autos", fontSize = 15.sp)
        }
        Spacer(modifier = Modifier.padding(5.dp))
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
         //Agregar Nombre

            Text(text = "Nombre ")

            nombre(objeto_view_Model)
        }
        
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween)
        {
         Spinner1(objeto_view_Model)
        }

        Spacer(modifier = Modifier.padding(5.dp))

        Row(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            Spinner2(objeto_view_Model)
        }

        Spacer(modifier = Modifier.padding(5.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween)
        {

            Spinner3(objeto_view_Model)
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Divider()

        mostrar_datos(objeto_view_Model)

        Divider()

        Spacer(modifier = Modifier.padding(15.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {

            cotizar(objeto_view_Model)
            //Spacer(modifier = Modifier.padding(80.dp))
            reset(objeto_view_Model)

        }
    }
}


@Composable
fun nombre(objeto_view_Model: MainViewModel)
{

    var nombre = remember { mutableStateOf("") }
    Row (

        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,

    )
    {
        TextField(
            value = nombre.value,
            onValueChange =
            {
                nombre.value = it
            },

            Modifier.width(170.dp),
            keyboardOptions = KeyboardOptions(KeyboardCapitalization.None, true, KeyboardType.Text),
        )

        Button(onClick = { objeto_view_Model.definirnombre(nombre.value.toString())
        },


        )
        {
            Text(text = "Agregar")
        }
    }
}

@Composable
fun Spinner1(objeto_view_Model: MainViewModel)
{
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) 
    {
        Text(text = "Marca", fontSize = 15.sp)
        generarSpinner1(objeto_view_Model)
    }
}

@Composable
fun generarSpinner1(objeto_view_Model: MainViewModel)
{
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Honda Accord   \$678,026.22 \" , \"Vw Touareg   \$879,266.16\" , \"BMW X5   \$1,025,366.87\", \"Mazda CX7   988,641.02")

    Box{
       Button(onClick = { expanded = !expanded },
           colors = ButtonDefaults.buttonColors(Color.Transparent)
       )
       {
           Text("Modelos")
           Spacer(modifier = Modifier.padding(3.dp))
           Icon(
               imageVector = Icons.Filled.ArrowDropDown,
               contentDescription = null,
           )

       }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    //action for click
                    expanded = false
                    objeto_view_Model.selectmarca(suggestions.indexOf(label))

                })
                {
                    Text(text = label)
                }
            }

        }
    }
}

@Composable
fun Spinner2(objeto_view_Model: MainViewModel)
{
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) 
    {
        Text(text = "Enganche", fontSize = 15.sp)
        generarSpinner2(objeto_view_Model)
    }
}

@Composable
fun generarSpinner2(objeto_view_Model: MainViewModel)
{
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("20%", "40%", "60%")

    Box {
        Button(onClick = { expanded = !expanded },
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        )
        {
            Text("Seleccione %")
            Spacer(modifier = Modifier.padding(3.dp))
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null,
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = true },
        )
        {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    //action for click
                    expanded = false
                    objeto_view_Model.selectporcentaje(suggestions.indexOf(label))
                })
                {
                    Text(text = label)
                }
            }

        }
    }
}

@Composable
fun Spinner3(objeto_view_Model: MainViewModel)
{
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Text(text = "Financiamiento Anual", fontSize = 15.sp)
        generarSpinner3(objeto_view_Model)
    }
}

@Composable
fun generarSpinner3(objeto_view_Model: MainViewModel)
{
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("1 año 7.5%", "2 años 9.5%", "3 años 10.3%", "4 años 12.6%", "5 años 13.5%")

    Box {
        Button(onClick = { expanded = !expanded },
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) 
        {
            Text("Seleccione Plazo",)
            Spacer(modifier = Modifier.padding(3.dp))
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null,
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = true },
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    //action for click
                    expanded = false
                    objeto_view_Model.selectinanciamiento(suggestions.indexOf(label))
                }) {
                    Text(text = label)
                }
            }

        }
    }
}

@Composable
fun cotizar(objeto_view_Model: MainViewModel)
{
    Button(onClick = {

    },
        colors = ButtonDefaults.buttonColors(Color.Gray)
    )
    {
        Text(text = "Cotizar", color = Color.White)
    }
}

@Composable
fun mostrar_datos(objeto_view_Model: MainViewModel)
{
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp),
        horizontalAlignment = Alignment.Start
    )
    {

        Text(text = "Cliente :  " + objeto_view_Model.nombre.value.toString())
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Modelo de Auto : " + objeto_view_Model.modelocarro.value.toString())
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Enganche de  :  % " + objeto_view_Model.descuento.value.toString() + "  de  " + objeto_view_Model.enganche.value.toString())
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Monto a financiar :  $ " + objeto_view_Model.financiamiento.value.toString())
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Financiamiento a  : $ " + objeto_view_Model.plazo.value.toString())
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Monto de interes por  $ " + objeto_view_Model.anual.value.toString() + "  años ")
        Text(text = "$ " + objeto_view_Model.interes.value.toString())
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Monto a finanziar + interes = ")
        Text(text =" $ ${ objeto_view_Model.financiamiento.value }  +  $ ${objeto_view_Model.interes.value.toString()}  =  $ ${objeto_view_Model.total.value.toString()} ")
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Pagos mensuales por =  $  " + objeto_view_Model.pagomensual.value.toString())
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Costo TOTAL  =  ")
        Text(text = "$${objeto_view_Model.enganche.value.toString()} + $${objeto_view_Model.total.value.toString()} = $${objeto_view_Model.enganche.value + objeto_view_Model.total.value}")
        

    }
}

@Composable
fun reset(objeto_view_Model: MainViewModel)
{
    Button(onClick = { objeto_view_Model.reset() },
    )
    {
        Text(text = "Reiniciar", color = Color.White)
    }
}







