package com.challenge.db1.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.challenge.db1.R
import com.challenge.db1.ui.theme.ColorPrimary
import com.challenge.db1.ui.theme.ColorSecundary
import com.challenge.db1.ui.theme.ColorThird

@Composable
fun AnimatedBorderCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(size = 0.dp),
    borderWith: Dp = 4.dp,
    gradient: Brush = Brush.sweepGradient(listOf(ColorSecundary, ColorThird)),
    animationDuration: Int = 10000,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "Animação")
    val degrees by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "Cores Infinitas"
    )
    Surface(
        modifier = modifier,
        shape = shape
    ) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .padding(borderWith)
                .drawWithContent {
                    rotate(degrees = degrees) {
                        drawCircle(
                            brush = gradient,
                            radius = size.width,
                            blendMode = BlendMode.SrcIn
                        )
                    }
                    drawContent()
                },
            color = Color(0xFF020D27),
            shape = shape
        ) {
            content()
        }
    }
}

@Composable
@Preview
private fun AnimatedBorderCardPreview(){
    AnimatedBorderCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(30.dp),
        borderWith = 10.dp,
        gradient = Brush.sweepGradient(
            listOf(
                ColorSecundary,
                ColorPrimary
            )
        ),
        animationDuration = 10000
    ) {
    }

}
