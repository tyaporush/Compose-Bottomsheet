package com.porush.composebottomsheet.ui.theme.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.porush.composebottomsheet.ui.theme.utils.clipTopCorners

/**
 * @author Porush Tyagi
 * @since 08,October,2022
 */

@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,
    expanded: Boolean,
) {
    val expandedState = remember { MutableTransitionState(false) }
    expandedState.targetState = expanded
    if (expandedState.currentState || expandedState.targetState || !expandedState.isIdle) {
        AnimatedVisibility(
            visibleState = expandedState,
            enter = slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(durationMillis = 500)
            ), exit = slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(durationMillis = 500)
            )
        ) {
            // to have smoother animation
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp), contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    modifier = modifier
                        .animateContentSize()
                        .background(Color.White)
                        .clipTopCorners(20.dp, Color.LightGray)
                        .fillMaxWidth()
                        .height(250.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Hello, From Bottom Sheet",
                        modifier = Modifier.padding(vertical = 100.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF, heightDp = 500)
@Composable
fun Preview_BottomSheet() {
    BottomSheet(expanded = true, modifier = Modifier)
}