package com.thechance.caffeine.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.caffeine.ui.design_system.text_style.Urbanist

@Composable
fun AppButton(
    text: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .dropShadow(
                offsetX = 0.dp,
                offsetY = 3.dp,
                blur = 12.dp,
                shape = CircleShape,
                color = Color.Black.copy(0.24f)
            )
            .clip(CircleShape)
            .background(Color(0xFF1F1F1F))
            .clickable { onClick() }
            .padding(
                horizontal = 32.dp,
                vertical = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            color = Color.White.copy(0.87f),
            style = TextStyle(
                fontFamily = Urbanist,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp
            ),
            modifier = Modifier.padding(end = 8.dp)
        )

        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp)
        )
    }
}