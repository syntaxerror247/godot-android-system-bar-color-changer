extends Control


func _on_color_picker_button_color_changed(color: Color) -> void:
	$ColorRect.color = color
	$SystemBarColorChanger.set_status_bar_color(color)
	$SystemBarColorChanger.set_navigation_bar_color(color)

func _on_translucent_system_bars_toggled(toggled_on: bool) -> void:
	$SystemBarColorChanger.set_translucent_system_bars(toggled_on)

func _on_set_status_color_pressed() -> void:
	$SystemBarColorChanger.set_status_bar_color("004748")


func _on_set_nav_color_pressed() -> void:
	$SystemBarColorChanger.set_navigation_bar_color("004748")


func _on_light_status_bar_toggled(toggled_on: bool) -> void:
	$SystemBarColorChanger.lightStatusBar = toggled_on


func _on_light_nav_bar_toggled(toggled_on: bool) -> void:
	$SystemBarColorChanger.lightNavigationBar = toggled_on
