package com.example.tespam42.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tespam42.model.datasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class siswaviewmodel : ViewModel() {
    //Request
    private val _statusUI = MutableStateFlow(datasiswa())
    val statusUI: StateFlow<datasiswa> = _statusUI.asStateFlow()

    //Response
    fun savedatasiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0],
                gender = ls[1],
                email = ls[2],
                alamat = ls[3],
                notelepon = ls[4]
            )
        }
    }
}