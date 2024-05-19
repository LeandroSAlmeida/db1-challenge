package com.challenge.db1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.challenge.db1.R
import com.challenge.db1.ui.theme.ColorThird

@Composable
fun CardComponent(){
    Surface(Modifier.padding(8.dp),shape = RoundedCornerShape(15.dp), shadowElevation = 4.dp) {

        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
                .background(Color.White)
                .background(Color.White)

        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                ColorThird,
                                Color.White
                            )
                        )
                    )
                    .fillMaxWidth()

            ){
                Image(
                    painter = painterResource(id = R.drawable._4b6993eb_adf0_4bf8_bf62_c5139a360e0c),
                    contentDescription = "Image",
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize/2)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .align(Alignment.BottomCenter)

                )
            }
            Spacer(modifier = Modifier.height(imageSize/2))

            Column(modifier = Modifier
                .padding(16.dp)) {
                Text(
                    text = "Nome",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Habilidades",
                    Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
}






@Preview
@Composable
fun CardComponentPreview(){
    CardComponent()
}
