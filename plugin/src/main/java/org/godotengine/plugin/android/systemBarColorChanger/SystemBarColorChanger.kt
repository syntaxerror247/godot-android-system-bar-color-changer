package org.godotengine.plugin.android.systemBarColorChanger

import android.content.res.Configuration
import android.graphics.Color
import androidx.core.view.WindowInsetsControllerCompat
import org.godotengine.godot.Godot
import org.godotengine.godot.plugin.GodotPlugin
import org.godotengine.godot.plugin.UsedByGodot

class SystemBarColorChanger(godot: Godot): GodotPlugin(godot) {

    override fun getPluginName() = BuildConfig.GODOT_PLUGIN_NAME

    @UsedByGodot
    fun setNavBarColor(color: String) {
        runOnUiThread {
            activity?.window?.navigationBarColor = Color.parseColor(color)
        }
    }

    @UsedByGodot
    fun setStatusBarColor(color: String, lightStatusBar: Boolean) {
        runOnUiThread {
            activity?.window?.statusBarColor = Color.parseColor(color)
            val currentTheme = activity!!.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            when (currentTheme) {
                Configuration.UI_MODE_NIGHT_NO -> {
                    val window = activity!!.window
                    val wic = WindowInsetsControllerCompat(window, window.decorView)
                    wic.isAppearanceLightStatusBars = lightStatusBar
                }
            }
        }
    }
}