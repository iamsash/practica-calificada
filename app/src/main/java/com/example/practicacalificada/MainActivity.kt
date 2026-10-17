package com.example.practicacalificada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ControlDeAforoScreen()
                }
            }
        }
    }
}

@Composable
fun ControlDeAforoScreen() {
    var personasAdentro by remember { mutableStateOf(0) }
    var ultimoRegistrado by remember { mutableStateOf("Ninguno") }
    var nombreInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 32.dp)
    ) {
        Text(
            text = "Control de Aforo",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Personas adentro: $personasAdentro",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Último registrado: $ultimoRegistrado",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            value = nombreInput,
            onValueChange = { nombreInput = it },
            label = { Text("Nombre del invitado") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                if (nombreInput.isNotBlank()) {
                    personasAdentro += 1
                    ultimoRegistrado = nombreInput
                    nombreInput = ""
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Registrar e Ingresar")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (personasAdentro > 0) {
                        personasAdentro -= 1
                    }
                }
            ) {
                Text("Salida (-1)")
            }

            Button(
                onClick = {
                    personasAdentro = 0
                    ultimoRegistrado = "Ninguno"
                }
            ) {
                Text("Reiniciar")
            }
        }
    }
}
