package com.example.appculinaria.feature_culinaria.presentation._detailproduct.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailDescriptor(
    text:String,
    image:ImageVector?=null,
    backgroundColor:Color,
    modifier: Modifier = Modifier
){
    val textSize = if(image != null) 14.sp else 12.sp
    val textWeight = if(image != null) FontWeight.SemiBold else FontWeight.Normal
    val padding = if (image != null) PaddingValues(end = 3.5.dp) else PaddingValues(horizontal = 8.dp, vertical = 5.dp)

    Box (modifier = modifier.background(backgroundColor, RoundedCornerShape(4.dp)).padding(padding), contentAlignment = Alignment.Center){
        Row (verticalAlignment = Alignment.CenterVertically){
            if (image != null){
                Icon(imageVector = image, contentDescription = "Icon", tint = Color.Black)
            }
            Text(text=text, fontSize = textSize, fontWeight = textWeight)
        }
    }
}