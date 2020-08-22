package ru.skillbranch.skillarticles.data.repositories

import androidx.lifecycle.LiveData
import ru.skillbranch.skillarticles.data.*

object ArticleRepository {
    private val local = LocalDataHolder
    private val network = NetworkDataHolder

    fun loadArticleContent(articleId: String) : LiveData<List<Any>?>{
        return network.loadArticleContent(articleId)
    }

    fun getArticle(articleId: String) : LiveData<ArticleData?>{
        return local.findArticle(articleId)
    }

    fun loadArticlePersonInfo(articleId: String) : LiveData<ArticlePersonalInfo?>{
        return local.findArticlePersonalInfo(articleId)
    }

    fun getAppSettings() : LiveData<AppSettings> = local.getAppSettings()

    fun updateSetting(appSettings: AppSettings){
        local.updateAppSettings(appSettings)
    }

    fun updateArticlePersonInfo(info: ArticlePersonalInfo){
        local.updateArticlePersonalInfo(info)
    }
 }