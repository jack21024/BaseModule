package com.jack.baselibrary.utils

import android.content.res.Resources
import android.util.DisplayMetrics

object DisplayUtils {

    val screenWidth by lazy { displayMetrics.widthPixels }
    val screenHeight by lazy { displayMetrics.heightPixels }
    val displayMetrics
        get() = Resources.getSystem().displayMetrics

    fun px2dp(px: Int): Float {
        return px.toFloat() / (displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun dp2px(dp: Int): Float {
        return dp.toFloat() * (displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

}