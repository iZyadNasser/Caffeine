package com.thechance.caffeine.ui.screen.size

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thechance.caffeine.R
import com.thechance.caffeine.model.CoffeeSize
import com.thechance.caffeine.model.CoffeeType
import com.thechance.caffeine.ui.components.AppButton
import com.thechance.caffeine.ui.components.dropShadow
import com.thechance.caffeine.ui.design_system.text_style.Urbanist
import com.thechance.caffeine.ui.design_system.theme.CaffeineTheme
import com.thechance.caffeine.ui.design_system.theme.Theme
import com.thechance.caffeine.ui.navigation.CoffeeSizeRoute
import com.thechance.caffeine.ui.screen.type.getTitleResource
import org.koin.androidx.compose.koinViewModel

@Composable
fun CoffeeSizeRoot(
    viewModel: CoffeeSizeViewModel = koinViewModel(),
    args: CoffeeSizeRoute,
    navigateToAlmostDoneScreen: () -> Unit,
    goBack: () -> Unit
) {
    val uiState = viewModel.state.collectAsStateWithLifecycle().value

    CoffeeSizeScreen(
        uiState = uiState,
        coffeeType = args.coffeeType,
        navigateToAlmostDoneScreen = navigateToAlmostDoneScreen,
        interactionHandler = viewModel,
        goBack = goBack
    )
}

@Composable
fun CoffeeSizeScreen(
    uiState: CoffeeSizeState,
    coffeeType: CoffeeType,
    navigateToAlmostDoneScreen: () -> Unit,
    interactionHandler: CoffeeSizeInteractionHandler,
    goBack: () -> Unit
) {
    val coffeeSizeScale by animateFloatAsState(
        targetValue = when (uiState.selectedCoffeeSize) {
            CoffeeSize.SMALL -> 0.9f
            CoffeeSize.MEDIUM -> 1f
            CoffeeSize.LARGE -> 1.1f
        },
        animationSpec = tween(500)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(
                vertical = 24.dp,
                horizontal = 16.dp
            )
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 65.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .clip(CircleShape)
                    .size(48.dp)
                    .background(Theme.color.white)
                    .clickable { goBack() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_vector_left),
                    contentDescription = null,
                    tint = Color(0xFF1F1F1F).copy(alpha = 0.87f),
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = stringResource(coffeeType.getTitleResource()),
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.25.sp
                ),
                color = Color(0xFF1F1F1F).copy(alpha = 0.87f),
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 47.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = uiState.selectedCoffeeSize.getML(),
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    lineHeight = 14.sp,
                    letterSpacing = 0.25.sp
                ),
                color = Color.Black.copy(0.6f),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 16.dp)
            )

            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(244.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                Image(
                    painter = painterResource(R.drawable.im_cup_empty),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            scaleX = coffeeSizeScale
                            scaleY = coffeeSizeScale
                        }
                )

                Image(
                    painter = painterResource(R.drawable.im_brand_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(66.dp)
                        .offset(y = 88.dp)
                        .graphicsLayer {
                            scaleX = coffeeSizeScale
                            scaleY = coffeeSizeScale
                        }
                )
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 92.dp)
                .clip(CircleShape)
                .background(Color(0xFFF5F5F5))
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            uiState.coffeeSizes.forEach { coffeeSize ->
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                        .clickable {
                            interactionHandler.onCoffeeSizeClick(coffeeSize)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    this@Row.AnimatedVisibility(
                        visible = uiState.selectedCoffeeSize == coffeeSize,
                        enter = fadeIn(
                            animationSpec = tween(500)
                        ),
                        exit = fadeOut(
                            animationSpec = tween(500)
                        )
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(40.dp)
                                .dropShadow(
                                    color = Color(0xFFB94B23).copy(alpha = 0.5f),
                                    offsetX = 0.dp,
                                    offsetY = 6.dp,
                                    blur = 16.dp,
                                    spread = 0.dp,
                                    shape = CircleShape
                                )
                                .background(Theme.color.brown)
                        )
                    }

                    Text(
                        text = coffeeSize.getLetter(),
                        style = TextStyle(
                            fontFamily = Urbanist,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            letterSpacing = 0.25.sp,
                            textAlign = TextAlign.Center
                        ),
                        color = if (coffeeSize == uiState.selectedCoffeeSize) {
                            Color.White.copy(alpha = 0.87f)
                        } else {
                            Color(0xFF1F1F1F).copy(alpha = 0.6f)
                        }
                    )
                }
            }
        }

        AppButton(
            text = stringResource(R.string.contin),
            icon = R.drawable.ic_vector_right,
            onClick = navigateToAlmostDoneScreen,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
private fun PreviewCoffeeSizeScreen() {
    CaffeineTheme {
        CoffeeSizeScreen(
            uiState = CoffeeSizeState(),
            coffeeType = CoffeeType.MACCHIATO,
            navigateToAlmostDoneScreen = {},
            interactionHandler = object : CoffeeSizeInteractionHandler {
                override fun onCoffeeSizeClick(coffeeSize: CoffeeSize) {
                    TODO()
                }

            },
            goBack = {}
        )
    }
}