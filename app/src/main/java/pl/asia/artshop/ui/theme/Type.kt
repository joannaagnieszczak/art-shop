package pl.asia.artshop.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import pl.asia.artshop.R


private val fontFamilyPlayfair = FontFamily(
    listOf(
        Font(
            resId = R.font.adamina
        )
    )
)

private val fontFamilyRoboto = FontFamily(
    listOf(
        Font(
            resId = R.font.catamaran_light
        )
    )
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fontFamilyPlayfair,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
        lineHeight = 34.sp,
        letterSpacing = 1.5.sp),
    titleLarge = TextStyle(
        fontFamily = fontFamilyRoboto,
        fontWeight = FontWeight.Medium,
       )
    )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
