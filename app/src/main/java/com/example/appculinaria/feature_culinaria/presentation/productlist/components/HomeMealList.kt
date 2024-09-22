package com.example.appculinaria.feature_culinaria.presentation.productlist.components

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.TableInfo
import com.example.appculinaria.feature_culinaria.domain.model.Meal
import com.example.appculinaria.feature_culinaria.presentation.productlist.OnEventMovieList
import com.example.appculinaria.feature_culinaria.presentation.util.PosterSize
import org.w3c.dom.Text

@Composable
fun HomeMealList(
    title: String,
    poster:List<Meal>,
    modifier: Modifier = Modifier,
    onMealClick: (Meal)->Unit
){
    Column (modifier=modifier){
        Text(text=title, fontWeight = FontWeight.SemiBold, fontSize = 20.sp, color = Color.White)
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow (modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)){
            items(poster){
                MealPosterFilter(
                    it.poster,
                    PosterSize.SMALL
                ) {
                    onMealClick(it)
                }

            }
        }
    }

}