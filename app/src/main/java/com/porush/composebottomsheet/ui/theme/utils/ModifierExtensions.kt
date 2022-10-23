package com.porush.composebottomsheet.ui.theme.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/**
 * @author Porush Tyagi
 * @since 08,October,2022
 */

/**
 * Applies a border on top with corners clipped
 * @param cornerRadius  The radius of top corners to be clipped
 * */
class TopRoundedCornerShape(
    private val cornerRadius: Float
): Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(Path().apply {
            arcTo(
                Rect(
                    offset = Offset(x = 0f, y = 0f),
                    size = Size(width = cornerRadius, height = cornerRadius)
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            lineTo(x = size.width - cornerRadius, y = 0f)
            arcTo(
                rect = Rect(
                    offset = Offset(x = size.width - cornerRadius, y = 0f),
                    size = Size(cornerRadius, cornerRadius)
                ),
                startAngleDegrees = 270F,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        })
    }

}