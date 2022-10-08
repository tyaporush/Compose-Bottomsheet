package com.porush.composebottomsheet.ui.theme.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Porush Tyagi
 * @since 08,October,2022
 */

/**
 * Applies a border on top with corners clipped
 * @param cornerRadius  The radius of top corners to be clipped
 * @param strokeColor  The color of the border that applies on top
 * */
fun Modifier.clipTopCorners(cornerRadius: Dp, strokeColor: Color): Modifier {
    return drawBehind {
        drawPath(
            path = Path().apply {
                arcTo(
                    Rect(
                        offset = Offset(x = 0f, y = 0f),
                        size = Size(width = cornerRadius.toPx(), height = cornerRadius.toPx())
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
                lineTo(x = size.width - cornerRadius.toPx(), y = 0f)
                arcTo(
                    rect = Rect(
                        offset = Offset(x = size.width - cornerRadius.toPx(), y = 0f),
                        size = Size(cornerRadius.toPx(), cornerRadius.toPx())
                    ),
                    startAngleDegrees = 270F,
                    sweepAngleDegrees = 90.0F,
                    forceMoveTo = false
                )
            },
            color = strokeColor,
            style = Stroke(2.dp.toPx())
        )
    }
}