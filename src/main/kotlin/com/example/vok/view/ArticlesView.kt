package com.example.vok.view

import com.example.vok.confirmDialog
import com.example.vok.repo.Article
import com.github.mvysny.karibudsl.v10.*
import com.github.mvysny.kaributools.refresh
import com.github.vokorm.dataloader.dataLoader
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.data.renderer.NativeButtonRenderer
import com.vaadin.flow.router.AfterNavigationEvent
import com.vaadin.flow.router.AfterNavigationObserver
import com.vaadin.flow.router.Route
import eu.vaadinonkotlin.vaadin.vokdb.setDataLoader

@Route("articles", layout = MainLayout::class)
class ArticlesView : KComposite(), AfterNavigationObserver {
    private lateinit var grid: Grid<Article>

    private val root = ui {
        verticalLayout {
            setSizeFull()
            h1("Listing Articles")
            routerLink(null, "New Article", CreateArticleView::class)
            grid = grid {
                isExpand = true; setSizeFull()
                setDataLoader(Article.dataLoader)

                columnFor(Article::id)
                columnFor(Article::title)
                columnFor(Article::text)
                addColumn(NativeButtonRenderer("Show") { ArticleView.navigateToView(it.id!!) })
                addColumn(NativeButtonRenderer("Edit") { EditArticleView.navigateToView(it.id!!) })
                addColumn(NativeButtonRenderer("Destroy") { article ->
                    confirmDialog {
                        article.delete()
                        this@grid.refresh()
                    } })
            }
        }
    }

    override fun afterNavigation(event: AfterNavigationEvent) {
        grid.refresh()
    }
}