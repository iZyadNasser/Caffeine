package com.thechance.caffeine.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.thechance.caffeine.R
import com.thechance.caffeine.ui.design_system.text_style.Urbanist
import com.thechance.caffeine.ui.design_system.theme.CaffeineTheme
import kotlin.math.absoluteValue

@Composable
fun CoffeeTypeCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    title: String,
    index: Int,
    currentSelectedIndex: Int,
    currentPageOffset: Float
) {
    val pageOffset = (currentSelectedIndex - index) + currentPageOffset

    val scaleIn = lerp(
        start = 0.6f,
        stop = 1f,
        fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f)
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .height(244.dp)
                .width(199.dp)
                .graphicsLayer {
                    scaleX = scaleIn
                    scaleY = scaleIn
                },
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(image),
                contentDescription = title
            )
            Image(
                modifier = Modifier
                    .padding(top = 117.dp)
                    .size(66.dp),
                painter = painterResource(R.drawable.im_brand_logo),
                contentDescription = null
            )
        }

        Text(
            text = title,
            color = Color(0xFF1F1F1F),
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                lineHeight = 32.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Preview
@Composable
private fun PreviewCoffeeTypeCard() {
    CaffeineTheme {
        CoffeeTypeCard(
            image = R.drawable.im_coffe_black,
            title = "Black",
            index = 0,
            currentSelectedIndex = 0,
            currentPageOffset = 0f,
        )
    }
}