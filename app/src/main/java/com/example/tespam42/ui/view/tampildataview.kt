package com.example.tespam42.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tespam42.model.datasiswa

@Composable
fun TampilDataView(
    uiState: datasiswa,
    onBackButton: () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){ TampilData(parameterName = "Nama", argu = uiState.nama)
        TampilData(parameterName = "Jenis Kelamin", argu = uiState.gender)
        TampilData(parameterName = "Email", argu = uiState.email)
        TampilData(parameterName = "Alamat", argu = uiState.alamat)
        TampilData(parameterName = "No Telepon", argu = uiState.notelepon)

        Button(onClick = onBackButton){
            Text(text="Kembali")
        }
    }
}
@Composable
fun TampilData(
    parameterName: String, argu : String
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = parameterName,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = ":",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = argu,
                modifier = Modifier.weight(2f)
            )
        }
    }
}