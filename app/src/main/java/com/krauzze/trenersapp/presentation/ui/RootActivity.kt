package com.krauzze.trenersapp.presentation.ui

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.krauzze.trenersapp.R
import com.krauzze.trenersapp.presentation.base.DiMoxyActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider
import io.reactivex.plugins.RxJavaPlugins
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_load.*


class RootActivity : DiMoxyActivity(), RootView {

    @InjectPresenter
    lateinit var presenter: RootPresenter

    @ProvidePresenter
    fun providePresenter(): RootPresenter = presenterProvider.get()

    @Inject
    lateinit var presenterProvider: Provider<RootPresenter>

    @field:RootQualifier
    @field:Inject
    lateinit var navigatorHolder: NavigatorHolder

    @field:RootQualifier
    @field:Inject
    lateinit var navigator: Navigator

    @field:RootQualifier("cover")
    @field:Inject
    lateinit var coverNavigatorHolder: NavigatorHolder

    @field:RootQualifier("cover")
    @field:Inject
    lateinit var coverNavigator: Navigator

    val ANIM_SPEED = 400L
    private var fullScreenFlag = false

    override val layout = R.layout.activity_main

    override val containerId: Int = R.id.main_content

    val coverContainerId: Int = R.id.cover_content

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        RxJavaPlugins.setErrorHandler {
            hideRootLoad()
            it.printStackTrace()
        }
        presenter.onCreate(savedInstanceState != null)
    }

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
    }

    override fun showRootLoad() {
        layout_load.visibility = View.VISIBLE
    }

    override fun hideRootLoad() {
        layout_load.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
        coverNavigatorHolder.setNavigator(coverNavigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
        coverNavigatorHolder.removeNavigator()
    }


    fun hideContent() {
        val hideAnimator = ValueAnimator.ofFloat(1f, 0f)
        hideAnimator.addUpdateListener { animation ->
            val alpha = animation?.animatedValue as Float
            main_content.alpha = alpha
            if (alpha < 0.1) {
                if (!fullScreenFlag) {
                    fullScreenFlag = true
                    main_content.visibility = View.GONE
                }
            }
        }
        hideAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
        hideAnimator.duration = ANIM_SPEED
        hideAnimator.start()


    }

    fun showContent() {
        main_content.alpha = 0f
        main_content.visibility = View.VISIBLE
        val showAnimator = ValueAnimator.ofFloat(0f, 1f)
        showAnimator.addUpdateListener { animation ->
            val alpha = animation?.animatedValue as Float
            main_content.alpha = alpha
        }
        showAnimator.duration = ANIM_SPEED
        showAnimator.start()
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        fullScreenFlag = false


    }


    fun hideBackground() {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    fun showBackground() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        fullScreenFlag = false
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
