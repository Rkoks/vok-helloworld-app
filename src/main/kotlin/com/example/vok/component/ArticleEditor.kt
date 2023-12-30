package com.example.vok.component

import com.example.vok.repo.Article
import com.example.vok.view.ArticleView
import com.example.vok.view.ArticlesView
import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.component.HasComponents

class ArticleEditor : KComposite() {
    private val binder = beanValidationBinder<Article>()
    var article: Article? = null
        set(value) {
            field = value
            if (value != null) {
                binder.readBean(value)
            }
        }

    private val root = ui {
        verticalLayout {
            isMargin = false

            textField("Title") {
                bind(binder).bind(Article::title)
            }
            textField("Text") {
                bind(binder).bind(Article::text)
            }

            button("Save Article") {
                onLeftClick { event ->
                    val article = article!!
                    if (binder.validate().isOk && binder.writeBeanIfValid(article)) {
                        article.save()
                        ArticleView.navigateToView(article.id!!)
                    }
                }
            }

            routerLink(null, "Back", ArticlesView::class)
        }
    }
}

fun HasComponents.articleEditor(block: ArticleEditor.() -> Unit = {}) =
    init(ArticleEditor(), block)