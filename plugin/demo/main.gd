extends Control

@onready var background_color = $ColorRect.color

func _on_button_pressed() -> void:
	$SystemBarColorChanger.set_status_bar_color(background_color)

func _on_button_2_pressed() -> void:
	$SystemBarColorChanger.set_navigation_bar_color(background_color)


func _on_color_picker_button_color_changed(color: Color) -> void:
	$ColorRect.color = color
	$SystemBarColorChanger.set_status_bar_color(color)
	$SystemBarColorChanger.set_navigation_bar_color(color)

func _on_light_status_bar_toggled(toggled_on: bool) -> void:
	$SystemBarColorChanger.lightStatusBar = toggled_on


func _on_light_navigation_bar_toggled(toggled_on: bool) -> void:
	$SystemBarColorChanger.lightNavigationBar = toggled_on
