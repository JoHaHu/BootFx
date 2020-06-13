package com.johupe.bootfx.dsl

import javafx.event.EventTarget
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox


inline fun <reified T : Node> T.attachTo(target: EventTarget,
                                         crossinline after: T.() -> Unit = {},
                                         crossinline before: (T) -> Unit = {}): T {
    before(this)
    when (target) {
        is MenuItem -> target.graphic = this
        is BorderPane -> {
        }
        is Pane -> target.children.add(this)
        is Button -> target.graphic = this
        else -> {
        }
    }
    this.after()
    return this
}

inline fun EventTarget.pane(crossinline op: Pane.() -> Unit = {}) = Pane().attachTo(this, op)


inline fun EventTarget.vbox(crossinline op: VBox.() -> Unit = {}) = VBox().attachTo(this, op)
inline fun EventTarget.vbox(spacing: Double, crossinline op: VBox.() -> Unit = {}) = VBox(spacing).attachTo(this, op)

inline fun EventTarget.hbox(crossinline op: HBox.() -> Unit = {}) = HBox().attachTo(this, op)
inline fun EventTarget.hbox(spacing: Double, crossinline op: HBox.() -> Unit = {}) = HBox(spacing).attachTo(this, op)

inline fun EventTarget.borderpane(crossinline op: BorderPane.() -> Unit = {}) = BorderPane().attachTo(this, op)

inline fun EventTarget.menubar(crossinline op: MenuBar.() -> Unit = {}) = MenuBar().attachTo(this, op)

inline fun MenuBar.menu(title: String = "", crossinline op: Menu.() -> Unit = {}): Menu {
    val menu = Menu(title)
    menu.op()
    this.menus.add(menu)
    return menu
}

inline fun Menu.menuitem(title: String = "", crossinline op: MenuItem.() -> Unit = {}): MenuItem {
    val menuItem = MenuItem(title)
    menuItem.op()
    this.items.add(menuItem)
    return menuItem
}

inline fun Menu.menu(title: String = "", crossinline op: Menu.() -> Unit = {}): Menu {
    val menu = Menu(title)
    menu.op()
    this.items.add(menu)
    return menu
}


inline fun EventTarget.button(crossinline op: Button.() -> Unit = {}) = Button().attachTo(this, op)
inline fun EventTarget.button(title: String, crossinline op: Button.() -> Unit = {}) = Button(title).attachTo(this, op)

