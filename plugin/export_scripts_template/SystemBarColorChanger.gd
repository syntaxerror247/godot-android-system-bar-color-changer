#
# © 2024-present https://github.com/syntaxerror247
#

@tool
class_name SystemBarColorChanger extends Node

const _plugin_name: String = "SystemBarColorChanger"
var lightStatusBar: bool = false
var lightNavigationBar: bool = false

var _plugin_singleton: Object

func _ready() -> void:
	if Engine.has_singleton(_plugin_name):
		_plugin_singleton = Engine.get_singleton(_plugin_name)
	else:
		printerr("%s singleton not found!" % _plugin_name)

func set_status_bar_color(color: Color):
	if _plugin_singleton:
		_plugin_singleton.setStatusBarColor(change_color_format(color),lightStatusBar)
	else:
		printerr("%s plugin not initialized!" % _plugin_name)

func set_navigation_bar_color(color: Color):
	if _plugin_singleton:
		_plugin_singleton.setNavBarColor(change_color_format(color),lightNavigationBar)
	else:
		printerr("%s plugin not initialized!" % _plugin_name)

func set_translucent_system_bars(translucent = true):
	if _plugin_singleton:
		_plugin_singleton.setTranslucentSystemBars(translucent)
	else:
		printerr("%s plugin not initialized!" % _plugin_name)

func change_color_format(color: Color):
	# It changes color format to ARGB string
	var new_format: String
	if color.a < 1:
		new_format = "#"+color.to_html().right(2) + color.to_html(false)
	else:
		new_format = "#"+color.to_html(false)
	return new_format
	
