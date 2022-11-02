package com.gicproject.salamkioskapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gicproject.salamkioskapp.R
import com.gicproject.salamkioskapp.Screen
import com.gicproject.salamkioskapp.common.Constants

@Composable
fun SelectOptionScreen(
    navController: NavController,
    viewModel: MyViewModel,
) {

    val listState = rememberLazyListState()


    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    MaterialTheme.colors.surface,
                )
        ) {
            Modifier.padding(innerPadding)
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = Constants.BACKGROUND_IMAGE),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "bg",
                    modifier = Modifier.fillMaxSize()
                )
            }
            HeaderDesign("Select Option")
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CustomButtonLarge(onClick = {
                    navController.navigate(Screen.SelectDepartmentScreen.route)
                }, text = "Consultation Visit")
                Spacer(modifier = Modifier.height(40.dp))
                CustomButtonLarge(onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        Constants.STATE_EXTRA, true
                    )
                    navController.navigate(Screen.InsertCivilIdScreen.route)
                }, text = "Services")
            }
            /* if (state.error.isNotBlank()) {

             }
             if (state.isLoading) {
                 CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
             }
             if (state.success.isNotBlank()) {
                 LaunchedEffect(key1 = true) {

                 }
             }*/
        }
    }
}

@Composable
fun CustomButtonLarge(onClick: () -> Unit, text: String) {
    Button(onClick = onClick,
        modifier = Modifier
            .width(500.dp)
            .height(180.dp)
            .shadow(50.dp, shape = RoundedCornerShape(5.dp)), shape = RoundedCornerShape(30.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text,
                fontSize = 60.sp,
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
fun CustomButton(onClick: () -> Unit, text: String) {
    Button(onClick = onClick,
            modifier = Modifier
                .width(300.dp)
                .height(130.dp)
                .shadow(30.dp, shape = RoundedCornerShape(5.dp)), shape = RoundedCornerShape(15.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text,
                fontSize = 40.sp,
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
fun HeaderDesign(title: String) {
    Box(modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(10.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = Constants.LOGO),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "bg",
                    modifier = Modifier
                        .width(180.dp)
                        .height(55.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(title, fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                }
            }


        }
    }

}
