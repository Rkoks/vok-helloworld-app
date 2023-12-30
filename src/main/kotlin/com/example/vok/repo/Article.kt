package com.example.vok.repo

import com.github.vokorm.KEntity
import com.gitlab.mvysny.jdbiorm.Dao
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class Article(
    override var id: Long? = null,

    @field:NotNull
    @field:Size(min = 5)
    var title: String? = null,

    @field:NotNull
    @field:Size(min=2)
    var text: String? = null
) : KEntity<Long> {
    companion object : Dao<Article, Long>(Article::class.java)
}