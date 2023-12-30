package com.example.vok.view

import com.example.vok.component.ArticleEditor
import com.example.vok.component.articleEditor
import com.example.vok.repo.Article
import com.github.mvysny.karibudsl.v10.*
import com.github.mvysny.kaributools.navigateTo
import com.vaadin.flow.router.BeforeEvent
import com.vaadin.flow.router.HasUrlParameter
import com.vaadin.flow.router.Route

@Route("edit-article", layout = MainLayout::class)
class EditArticleView :KComposite(), HasUrlParameter<Long> {
    private lateinit var editor: ArticleEditor

    private val root = ui {
        verticalLayout {
            h1("Edit Article")

            editor = articleEditor()
        }
    }

    override fun setParameter(event: BeforeEvent, articleId: Long?) {
        editor.article = Article.getById(articleId!!)
    }

    companion object {
        fun navigateToView(articleId: Long) = navigateTo(EditArticleView::class, articleId)
    }
}