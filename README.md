<p align="center">
   <img width="200" src="plugin/demo/icon.png?raw=true" alt="plugin icon">
</p>

# Android System Bar Color Changer

This Plugin enables to dynamically change the system bar colors (status bar and navigation bar) of your godot android app.

## Installation
Steps:
- download latest release from Github [releases](https://github.com/syntaxerror247/godot-android-system-bar-color-changer/releases)
- unzip the release archive
- copy addon to your Godot project's root directory
- enable the plugin via the `Plugins` tab of `Project->Project Settings...` menu, in the Godot Editor

## How to use
1. Turn on gradle build in your project
   - Follow instructions on the following page to create an Android gradle build
[Create Android gradle build](https://docs.godotengine.org/en/stable/tutorials/export/android_gradle_build.html)

2. Turn off immersive_mode in Android exprot present (to make system bar visible)

3. Add `SystemBarColorChanger` node to your scene
   - To change status bar color
   ```
     $SystemBarColorChanger.set_status_bar_color(color)
   ```
   - To change navigation bar color
   ```
     $SystemBarColorChanger.set_navigation_bar_color(color)
   ```
   - If you want to have light status bar eg. WHITE (Note: You will have to call set_status_bar_color() to update changes)
   ```
     $SystemBarColorChanger.lightStatusBar = true
   ```
   - If you want to have light navigation bar eg. WHITE (Note: You will have to call set_navigation_bar_color() to update changes)
   ```
     $SystemBarColorChanger.lightNavigationBar = true
   ```
4. Translucent System Bars
   - To enable translucent system bars
   ```
      $SystemBarColorChanger.set_translucent_system_bars(true)
   ```
   - To disable translucent system bars
   ```
      $SystemBarColorChanger.set_translucent_system_bars(false)
   ```

---
## Demo Project
***You can try this plugin using demo project: [Demo Project](plugin/demo)***

https://github.com/user-attachments/assets/7e87834b-de21-4dec-9b8a-60a2d0b95beb

## Credits
**Developed By: Anish [syntaxerror247](https://github.com/syntaxerror247)**
