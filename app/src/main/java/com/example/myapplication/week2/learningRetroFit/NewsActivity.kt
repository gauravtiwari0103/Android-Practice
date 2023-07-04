package com.example.myapplication.week2.learningRetroFit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.week2.learingviewpager.ViewPager2Adapter
import com.example.myapplication.week2.learningRetroFit.adapter.NewsViewPagerAdapter
import com.example.myapplication.week2.learningRetroFit.data.Article
import com.example.myapplication.week2.learningRetroFit.data.News
import com.example.myapplication.week2.learningRetroFit.interfaces.NewsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var listOfNews:ArrayList<Article>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        viewPager = findViewById(R.id.retro_viewPager)
        var dataset = ArrayList<Article>()
        listOfNews = ArrayList()
        getNews()
    }

    fun getNews(){
        val news: Call<News> = NewsService.newsInstance.getNews("in")
        news.enqueue(object : Callback<News>{
            override fun onFailure(call: Call<News>, t: Throwable) {
                Toast.makeText(this@NewsActivity, "Failed to fetch news", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    for(article in news.articles) listOfNews.add(article)
                }
                viewPager.adapter = NewsViewPagerAdapter(this@NewsActivity, listOfNews)
                viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
            }

        })
    }
}