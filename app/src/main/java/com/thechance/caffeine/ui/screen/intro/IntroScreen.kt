package com.thechance.caffeine.ui.screen.intro

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.caffeine.R
import com.thechance.caffeine.ui.components.AppButton
import com.thechance.caffeine.ui.components.TopBar
import com.thechance.caffeine.ui.design_system.text_style.Sniglet
import com.thechance.caffeine.ui.design_system.theme.CaffeineTheme

@Composable
fun IntroScreen(
    navigateToCoffeeType: () -> Unit,
) {
    val infiniteTransition = rememberInfiniteTransition()

    val starColor by infiniteTransition.animateColor(
        initialValue = Color(0xFF1F1F1F).copy(0.87f),
        targetValue = Color(0xFF1F1F1F).copy(0.12f),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 450,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val ghostShadowOpacity by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val ghostShadowOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val ghostOffset by infiniteTransition.animateFloat(
        initialValue = 10f,
        targetValue = -24f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(
                horizontal = 16.dp,
                vertical = 24.dp
            )
    ) {
        TopBar(
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Box(
            modifier = Modifier
                .padding(bottom = 32.dp)
                .align(Alignment.CenterHorizontally)
                .width(188.dp),
        ) {
            Text(
                text = stringResource(R.string.intro_text),
                style = TextStyle(
                    fontFamily = Sniglet,
                    fontWeight = FontWeight.Normal,
                    fontSize = 32.sp,
                    lineHeight = 50.sp,
                    textAlign = TextAlign.Center,
                ),
                color = Color(0xFF1F1F1F).copy(0.87f),
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_star),
                contentDescription = null,
                tint = starColor,
                modifier = Modifier
                    .size(16.dp)
                    .offset(
                        x = 10.dp,
                        y = 65.dp
                    )
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_star),
                contentDescription = null,
                tint = starColor,
                modifier = Modifier
                    .size(16.dp)
                    .offset(
                        x = 176.dp,
                        y = 6.dp
                    )
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_star),
                contentDescription = null,
                tint = starColor,
                modifier = Modifier
                    .size(16.dp)
                    .offset(
                        x = 186.dp,
                        y = 186.dp
                    )
            )
        }

        Image(
            painter = painterResource(R.drawable.im_ghost),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(244.dp)
                .align(Alignment.CenterHorizontally)
                .offset(y = ghostOffset.dp)
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.im_ghost_shadow),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .offset(y = ghostShadowOffset.dp)
                .width(176.dp)
                .align(Alignment.CenterHorizontally)
                .alpha(ghostShadowOpacity)
                .blur(12.dp)
        )

        AppButton(
            text = stringResource(R.string.bring_my_coffee),
            icon = R.drawable.ic_coffee,
            onClick = navigateToCoffeeType,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 48.dp)
        )

    }
}

@Preview
@Composable
private fun PreviewIntroScreen() {
    CaffeineTheme {
        IntroScreen(
            navigateToCoffeeType = {}
        )
    }
}