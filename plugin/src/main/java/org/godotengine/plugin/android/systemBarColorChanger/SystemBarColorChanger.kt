package org.godotengine.plugin.android.systemBarColorChanger

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.view.WindowManager.LayoutParams
import androidx.core.view.WindowInsetsControllerCompat
import org.godotengine.godot.Godot
import org.godotengine.godot.plugin.GodotPlugin
import org.godotengine.godot.plugin.UsedByGodot

class SystemBarColorChanger(godot: Godot): GodotPlugin(godot) {

    override fun getPluginName() = BuildConfig.GODOT_PLUGIN_NAME

    override fun onMainCreate(activity: Activity?): View? {
        activity?.window?.setSoftInputMode(LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
        activity?.window?.addFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        return super.onMainCreate(activity)
    }

    @UsedByGodot
    fun setNavBarColor(color: String, lightNavBar: Boolean) {
        runOnUiThread {
            activity?.window?.navigationBarColor = Color.parseColor(color)
            val window = activity!!.window
            val wic = WindowInsetsControllerCompat(window, window.decorView)
            wic.isAppearanceLightNavigationBars = lightNavBar
        }
    }

    @UsedByGodot
    fun setStatusBarColor(color: String, lightStatusBar: Boolean) {
        runOnUiThread {
            activity?.window?.statusBarColor = Color.parseColor(color)
            val window = activity!!.window
            val wic = WindowInsetsControllerCompat(window, window.decorView)
            wic.isAppearanceLightStatusBars = lightStatusBar
        }
    }

    @UsedByGodot
    fun setTranslucentSystemBars(translucent: Boolean) {
        runOnUiThread {
            if (translucent) {
                activity?.window?.addFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS)
                activity?.window?.addFlags(LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            } else {
                activity?.window?.clearFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS)
                activity?.window?.clearFlags(LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            }
        }
    }
}
