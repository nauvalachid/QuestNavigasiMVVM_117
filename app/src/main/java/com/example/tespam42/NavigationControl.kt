package com.example.tespam42

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tespam42.model.jeniskelamin.JenisK
import com.example.tespam42.ui.view.FormulirView
import com.example.tespam42.ui.view.TampilDataView
import com.example.tespam42.viewmodel.siswaviewmodel

enum class Halaman {
    Formulir, TampilData
}

@Composable
fun NavigationControl(
    modifier: Modifier = Modifier,
    viewModel: siswaviewmodel = viewModel(),
    navHost: NavHostController = rememberNavController()
) {
    val uiState by viewModel.statusUI.collectAsState()
    NavHost(
        modifier = Modifier,
        navController = navHost,
        startDestination = Halaman.Formulir.name

    ) {
        composable(
            route = Halaman.Formulir.name
        ) {
            val konteks = LocalContext.current
            FormulirView(
                listJK = JenisK.map { id ->
                    konteks.getString(id)
                },
                onSubmitClickened = {
                    viewModel.savedatasiswa(it)
                    navHost.navigate(Halaman.TampilData.name)
                }
            )
        }
        composable(route = Halaman.TampilData.name) {
            TampilDataView(
                uiState = uiState,
                onBackButton = { navHost.popBackStack() })
        }
    }
}

