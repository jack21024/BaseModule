package com.jack.baselibrary.utils

import android.content.res.Resources
import android.util.DisplayMetrics

object DisplayUtils {

    val screenWidth by lazy { Resources.getSystem().displayMetrics.widthPixels }
    val screenHeight by lazy { Resources.getSystem().displayMetrics.heightPixels }

    fun px2dp(px: Float): Float {
        return px / (Resources.getSystem().displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun dp2px(dp: Float): Float {
        return dp * (Resources.getSystem().displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

}