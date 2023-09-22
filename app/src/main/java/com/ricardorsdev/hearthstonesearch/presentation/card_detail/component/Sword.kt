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
fun rememberSwords(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "swords",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Yellow),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(31.958f, 36.125f)
                lineTo(26.833f, 31f)
                lineToRelative(-3.666f, 3.667f)
                lineToRelative(-1.625f, -1.584f)
                quadToRelative(-0.75f, -0.75f, -0.75f, -1.833f)
                reflectiveQuadToRelative(0.75f, -1.875f)
                lineToRelative(8f, -8f)
                quadToRelative(0.791f, -0.75f, 1.875f, -0.75f)
                quadToRelative(1.083f, 0f, 1.833f, 0.75f)
                lineTo(34.875f, 23f)
                lineToRelative(-3.667f, 3.667f)
                lineToRelative(5.084f, 5.083f)
                quadToRelative(0.375f, 0.417f, 0.375f, 0.938f)
                quadToRelative(0f, 0.52f, -0.375f, 0.937f)
                lineToRelative(-2.5f, 2.5f)
                quadToRelative(-0.417f, 0.417f, -0.938f, 0.417f)
                quadToRelative(-0.521f, 0f, -0.896f, -0.417f)
                close()
                moveToRelative(4.667f, -26.333f)
                lineTo(17.75f, 28.667f)
                lineToRelative(0.667f, 0.708f)
                quadToRelative(0.791f, 0.75f, 0.791f, 1.854f)
                reflectiveQuadToRelative(-0.791f, 1.854f)
                lineToRelative(-1.584f, 1.584f)
                lineTo(13.167f, 31f)
                lineToRelative(-5.125f, 5.125f)
                quadToRelative(-0.375f, 0.417f, -0.917f, 0.417f)
                reflectiveQuadToRelative(-0.917f, -0.417f)
                lineToRelative(-2.5f, -2.5f)
                quadToRelative(-0.416f, -0.417f, -0.416f, -0.937f)
                quadToRelative(0f, -0.521f, 0.416f, -0.938f)
                lineToRelative(5.084f, -5.083f)
                lineTo(5.125f, 23f)
                lineToRelative(1.625f, -1.625f)
                quadToRelative(0.75f, -0.75f, 1.833f, -0.75f)
                quadToRelative(1.084f, 0f, 1.875f, 0.75f)
                lineToRelative(0.709f, 0.708f)
                lineTo(30.042f, 3.208f)
                horizontalLineToRelative(6.583f)
                close()
                moveToRelative(-23.208f, 6.333f)
                lineToRelative(1.458f, -1.417f)
                lineToRelative(1.458f, -1.458f)
                lineToRelative(-1.458f, 1.458f)
                close()
                moveTo(11.583f, 18f)
                lineTo(3.417f, 9.792f)
                verticalLineTo(3.208f)
                horizontalLineToRelative(6.541f)
                lineToRelative(8.209f, 8.209f)
                lineToRelative(-1.834f, 1.833f)
                lineToRelative(-7.458f, -7.375f)
                horizontalLineTo(6.042f)
                verticalLineToRelative(2.833f)
                lineToRelative(7.375f, 7.417f)
                close()
                moveToRelative(4.209f, 8.833f)
                lineTo(33.958f, 8.708f)
                verticalLineTo(5.875f)
                horizontalLineToRelative(-2.833f)
                lineTo(12.958f, 24f)
                close()
                moveToRelative(0f, 0f)
                lineToRelative(-1.417f, -1.458f)
                lineTo(12.958f, 24f)
                lineToRelative(1.417f, 1.375f)
                lineToRelative(1.417f, 1.458f)
                close()
            }
        }.build()
    }
}