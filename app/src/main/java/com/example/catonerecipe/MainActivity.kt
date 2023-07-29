package com.example.catonerecipe
// Adrian Kiprono cat1 MOBILE APPLICATION DEVELOPMENT EC 2023 (FOOD-RECIPE)on GITHUB

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.catonerecipe.ui.theme.CATonerecipeTheme
import androidx.compose.foundation.layout.Column
import com.example.catonerecipe.ui.theme.CATonerecipeTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            CATonerecipeTheme {
                RecyclerView()

            }
        }
    }
}


@Composable
fun ListItem(name : String){

    val expanded = remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded.value) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()) {
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "FOOD")
                    Text(text = name, style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight =FontWeight.ExtraBold
                    ))

                }
                OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                    Text(if (expanded.value) "Show less" else "Show more")

                }

            }
            if (expanded.value){
                Card(
                    modifier = Modifier.padding(
                        bottom = extraPadding.coerceAtLeast(0.dp)
                    )) {
                    Column() {
                        Text(text = "TITlE:PIZZA",
                            color = Color.Black,fontSize = 20.sp,
                            modifier = Modifier.padding())
                        Text(text = "Recipe:flour,cheese,tomato,capsicum,meat,cooking oil",
                            color = Color.Black,fontStyle = FontStyle.Italic,
                            modifier = Modifier.padding())
                        Text(text = "Recipe:tomatoes, onions,baking flour, mushroom",
                            color = Color.Black,fontStyle = FontStyle.Italic,
                            modifier = Modifier.padding())
                        Text(text = "Meal Type: Dinner or Lunch",
                            color = Color.Black,fontStyle = FontStyle.Italic,
                            modifier = Modifier.padding())
                        Text(text = "Preparation: Intermediate",
                            color = Color.Black,fontStyle = FontStyle.Italic,
                            modifier = Modifier.padding())
                        Text(text = "Preparation: time your time ",
                            color = Color.Black,
                            modifier = Modifier.padding())
                        Text(text = "alternative: buy",
                            color = Color.Black,
                            modifier = Modifier.padding())
                    }
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

}
@Composable
fun RecyclerView(names: List<String> = List(1000){"$it"}){
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
        items(items = names){name->
            ListItem(name = name)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CATonerecipeTheme {
        RecyclerView()
    }
}
