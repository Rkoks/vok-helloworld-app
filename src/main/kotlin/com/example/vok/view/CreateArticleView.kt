package com.example.vok.view

import com.example.vok.component.ArticleEditor
import com.example.vok.component.articleEditor
import com.example.vok.repo.Article
import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.router.Route

@Route("create-article", layout = MainLayout::class)
class CreateArticleView : KComposite() {
    private lateinit var editor: ArticleEditor

    private val root = ui {
        verticalLayout {
            h1("New Article")

            editor = articleEditor {
                article = Article()
            }
        }
    }
}