package com.thechance.caffeine.ui.screen.type

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thechance.caffeine.R
import com.thechance.caffeine.model.CoffeeType
import com.thechance.caffeine.ui.components.AppButton
import com.thechance.caffeine.ui.components.CoffeeTypeCard
import com.thechance.caffeine.ui.components.TopBar
import com.thechance.caffeine.ui.design_system.text_style.Urbanist
import com.thechance.caffeine.ui.design_system.theme.CaffeineTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CoffeeTypeRoot(
    navigateToCoffeeSize: (CoffeeType) -> Unit,
    viewModel: CoffeeTypeViewModel = koinViewModel(),
) {
    val uiState = viewModel.state.collectAsStateWithLifecycle().value

    CoffeeTypeScreen(
        navigateToCoffeeSize = navigateToCoffeeSize,
        uiState = uiState
    )
}

@Composable
fun CoffeeTypeScreen(
    navigateToCoffeeSize: (CoffeeType) -> Unit,
    uiState: CoffeeTypeState,
) {
    val pagerState = rememberPagerState { uiState.coffeeTypes.size }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(
                vertical = 24.dp
            )
    ) {
        TopBar(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )

        Text(
            text = stringResource(R.string.good_morning),
            color = Color(0xFFB3B3B3),
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                lineHeight = 36.sp,
                letterSpacing = 0.25.sp
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = stringResource(R.string.zyad),
            color = Color(0xFF3B3B3B),
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                lineHeight = 36.sp,
                letterSpacing = 0.25.sp
            ),
            modifier = Modifier
                .padding(bottom = 4.dp)
                .padding(horizontal = 16.dp)
        )

        Text(
            text = stringResource(R.string.what_would_you_like_to_drink_today),
            color = Color(0xFF1F1F1F).copy(alpha = 0.8f),
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.25.sp
            ),
            modifier = Modifier
                .padding(bottom = 56.dp)
                .padding(horizontal = 16.dp)
        )

        HorizontalPager(
            state = pagerState,
            reverseLayout = true,
            modifier = Modifier
                .padding(bottom = 111.dp),
            pageSpacing = 0.dp,
            contentPadding = PaddingValues(horizontal = 80.dp)
        ) { index ->
            CoffeeTypeCard(
                image = uiState.coffeeTypes[index].getImageResource(),
                title = stringResource(uiState.coffeeTypes[index].getTitleResource()),
                index = index,
                currentSelectedIndex = pagerState.currentPage,
                currentPageOffset = pagerState.currentPageOffsetFraction
            )
        }

        AppButton(
            text = stringResource(R.string.contin),
            icon = R.drawable.ic_vector_right,
            onClick = { navigateToCoffeeSize(uiState.coffeeTypes[pagerState.currentPage]) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
private fun PreviewCoffeeTypeScreen() {
    CaffeineTheme {
        CoffeeTypeScreen(
            navigateToCoffeeSize = {},
            uiState = CoffeeTypeState()
        )
    }
}