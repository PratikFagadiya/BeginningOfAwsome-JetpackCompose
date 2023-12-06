package com.patrikcodes.beginningofawsome.ui.presentation.switch

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.patrikcodes.beginningofawsome.R
import com.patrikcodes.beginningofawsome.ui.theme.Blue
import com.patrikcodes.beginningofawsome.ui.theme.DayYellow
import com.patrikcodes.beginningofawsome.ui.theme.NavyBlue
import com.patrikcodes.beginningofawsome.ui.theme.NightGray

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SwitchScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Normal Switch With Icon Change")
        SwitchComponent()
        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "Custom Switch With Animation")

        CustomSwitchComponent()

    }

}


@Preview(showBackground = true)
@Composable
fun SwitchComponent() {

    var isChecked by remember { mutableStateOf(false) }

    Switch(checked = isChecked, onCheckedChange = { isChecked = it }, thumbContent = {

        if (isChecked) {
            Icon(
                painter = painterResource(id = R.drawable.wb_sunny),
                contentDescription = "Day Mode",
                modifier = Modifier.padding(5.dp),
                tint = Color.White
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.dark_mode),
                contentDescription = "Night Mode",
                modifier = Modifier.padding(5.dp),
                tint = Color.White
            )
        }

    }, colors = SwitchDefaults.colors(
        checkedTrackColor = Blue,
        uncheckedTrackColor = NavyBlue,
        uncheckedBorderColor = NavyBlue,
        checkedThumbColor = DayYellow,
        uncheckedThumbColor = NightGray
    ), modifier = Modifier
        .scale(2f)
        .padding(30.dp)
    )

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CustomSwitchComponent() {

    var isSwitchOn by remember { mutableStateOf(false) }

    val bgColor: Color by animateColorAsState(
        if (isSwitchOn) Blue else NavyBlue,
        animationSpec = tween(300, easing = LinearEasing),
        label = "Animated Switch Color"
    )

    val thumbColor: Color by animateColorAsState(
        if (isSwitchOn) DayYellow else NightGray,
        animationSpec = tween(300, easing = LinearEasing),
        label = "Animated Switch Color"
    )

    val offset by animateDpAsState(
        targetValue = if (isSwitchOn) {
            45.dp
        } else {
            8.dp
        }, label = "offset", animationSpec = tween(
            300, easing = LinearEasing
        )
    )

    val rotation by animateFloatAsState(
        targetValue = if (isSwitchOn) 180f else 0f,
        animationSpec = tween(300, easing = LinearEasing),
        label = ""
    )

    Box(
        modifier = Modifier
            .padding(20.dp)
            .width(104.dp)
            .height(64.dp)
            .clip(shape = CircleShape)
            .background(bgColor)
            .clickable {
                isSwitchOn = !isSwitchOn
            },
        contentAlignment = Alignment.CenterStart,
    ) {

        Box(
            modifier = Modifier
                .height(50.dp)
                .offset(x = offset)
                .clip(shape = CircleShape)
                .background(thumbColor),
        ) {

            Crossfade(
                isSwitchOn, animationSpec = tween(300), label = ""
            ) { targetState ->

                Icon(
                    painter = painterResource(if (targetState) R.drawable.wb_sunny else R.drawable.dark_mode),
                    contentDescription = "Day Mode",
                    modifier = Modifier
                        .padding(10.dp)
                        .rotate(rotation),
                    tint = Color.White
                )
            }
        }


    }

}
