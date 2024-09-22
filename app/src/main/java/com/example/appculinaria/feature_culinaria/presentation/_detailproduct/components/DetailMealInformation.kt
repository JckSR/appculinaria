package com.example.appculinaria.feature_culinaria.presentation._detailproduct.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appculinaria.feature_culinaria.domain.model.MealDetail

@Composable
fun DetailMealInformation(
    meal:MealDetail,
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier.fillMaxWidth().padding(24.dp), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text=meal.name, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 40.sp)
        Spacer(modifier=Modifier.height(16.dp))
        Row (verticalAlignment = Alignment.CenterVertically){
            DetailDescriptor(
                text = meal.linkPage.toString(),
                backgroundColor = Color.LightGray
            )
            Spacer(modifier = Modifier.width(8.dp))

            Box (modifier = Modifier.fillMaxWidth().border(0.4.dp,Color.White,
                RoundedCornerShape(12.dp)
            ).padding(vertical = 16.dp), contentAlignment = Alignment.Center){
                Text(
                    text = "Watch",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp, // Use sp for font size

                )

            }
            Spacer(modifier=Modifier.height(32.dp))
            Column (horizontalAlignment = Alignment.Start){

                Text(
                    text = "see you",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp, // Use sp for font size
                )
                Text(
                    text = meal.description,
                    color = Color.White
                )

            }
        }
    }
}