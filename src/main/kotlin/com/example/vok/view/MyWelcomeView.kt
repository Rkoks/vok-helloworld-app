package com.example.vok.view

import com.github.mvysny.karibudsl.v10.KComposite
import com.github.mvysny.karibudsl.v10.h1
import com.github.mvysny.karibudsl.v10.routerLink
import com.github.mvysny.karibudsl.v10.verticalLayout
import com.vaadin.flow.router.Route

@Route("", layout = MainLayout::class)
class MyWelcomeView : KComposite() {
    private val root = ui {
        verticalLayout {
            h1("Hello, Vaadin-on-Kotlin!")
            routerLink(text = "My Blog", viewType = ArticlesView::class)
        }
    }
}