package com.example.vok.view

import com.example.vok.repo.Article
import com.github.mvysny.karibudsl.v10.*
import com.github.mvysny.kaributools.navigateTo
import com.vaadin.flow.component.*
import com.vaadin.flow.router.*

@Route("article", layout = MainLayout::class)
class ArticleView: KComposite(), HasUrlParameter<Long> {
    private lateinit var title: Text
    private lateinit var text: Text

    private lateinit var editLink: RouterLink

    private val root = ui {
        verticalLayout {
            div {
                strong("Title: ")
                this@ArticleView.title = text("")
            }
            div {
                strong("Text: ")
                this@ArticleView.text = text("")
            }

            editLink = routerLink(null, "Edit")
            routerLink(null, "Back", ArticlesView::class)
        }
    }

    override fun setParameter(event: BeforeEvent, articleId: Long?) {
        val article = Article.getById(articleId!!)
        title.text = article.title
        text.text = article.text
        editLink.setRoute(EditArticleView::class.java, articleId)
    }

    companion object {
        fun navigateToView(articleId: Long) = navigateTo(ArticleView::class, articleId)
    }
}