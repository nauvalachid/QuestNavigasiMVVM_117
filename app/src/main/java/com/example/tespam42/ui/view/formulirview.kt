package com.example.tespam42.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun FormulirView(modifier: Modifier = Modifier, listJK : List<String>,
                 onSubmitClickened: (MutableList<String>) -> Unit) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    val listData : MutableList<String> = mutableListOf(nama,gender,email,alamat,notelepon)

    Column(
        modifier.fillMaxSize().padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = {
                Text(text = "nama")
            },
            placeholder = {
                Text(text = "isi nama anda")
            },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            listJK.forEach { selectedGender ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == selectedGender, onClick = {
                            gender = selectedGender
                        })
                    Text(text = selectedGender)
                    Spacer(modifier = Modifier.padding(10.dp))
                }
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(text = "email")
            },
            placeholder = {
                Text(text = "isi email anda")
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = {
                Text(text = "alamat")
            },
            placeholder = {
                Text(text = "isi alamat anda")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(
            value = notelepon,
            onValueChange = { notelepon = it },
            label = {
                Text(text = "notelepon")
            },
            placeholder = {
                Text(text = "isi notelepon anda")
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        Spacer(modifier = Modifier.padding(8.dp))
    }