package com.ricardorsdev.hearthstonesearch.presentation.card_detail.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun rememberWaterDrop(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "water_drop",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Red),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(20f, 36.542f)
                quadToRelative(-5.25f, 0f, -9.229f, -3.667f)
                quadTo(6.792f, 29.208f, 6.792f, 23f)
                quadToRelative(0f, -3.917f, 3.041f, -8.604f)
                quadTo(12.875f, 9.708f, 19f, 4.333f)
                quadToRelative(0.208f, -0.166f, 0.458f, -0.27f)
                quadToRelative(0.25f, -0.105f, 0.542f, -0.105f)
                quadToRelative(0.292f, 0f, 0.542f, 0.105f)
                quadToRelative(0.25f, 0.104f, 0.458f, 0.27f)
                quadToRelative(6.125f, 5.375f, 9.167f, 10.063f)
                quadToRelative(3.041f, 4.687f, 3.041f, 8.604f)
                quadToRelative(0f, 6.208f, -3.979f, 9.875f)
                reflectiveQuadTo(20f, 36.542f)
                close()
                moveToRelative(0f, -2.667f)
                quadToRelative(4.458f, 0f, 7.5f, -3.063f)
                quadTo(30.542f, 27.75f, 30.542f, 23f)
                quadToRelative(0f, -3.167f, -2.667f, -7.229f)
                quadTo(25.208f, 11.708f, 20f, 7.042f)
                quadToRelative(-5.208f, 4.666f, -7.875f, 8.729f)
                quadTo(9.458f, 19.833f, 9.458f, 23f)
                quadToRelative(0f, 4.75f, 3.042f, 7.812f)
                quadToRelative(3.042f, 3.063f, 7.5f, 3.063f)
                close()
                moveToRelative(0f, -9.917f)
                close()
                moveToRelative(0.125f, 7.5f)
                quadToRelative(0.625f, -0.041f, 0.979f, -0.312f)
                reflectiveQuadToRelative(0.354f, -0.729f)
                quadToRelative(0f, -0.5f, -0.375f, -0.792f)
                quadToRelative(-0.375f, -0.292f, -1.041f, -0.25f)
                quadToRelative(-1.709f, 0.042f, -3.563f, -1.063f)
                quadToRelative(-1.854f, -1.104f, -2.354f, -3.895f)
                quadToRelative(-0.083f, -0.375f, -0.396f, -0.625f)
                quadToRelative(-0.312f, -0.25f, -0.687f, -0.25f)
                quadToRelative(-0.5f, 0f, -0.771f, 0.375f)
                reflectiveQuadToRelative(-0.229f, 0.833f)
                quadToRelative(0.666f, 3.583f, 3.104f, 5.167f)
                quadToRelative(2.437f, 1.583f, 4.979f, 1.541f)
                close()
            }
        }.build()
    }
}