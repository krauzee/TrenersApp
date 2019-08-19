package com.krauzze.trenersapp.presentation.ui.main

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.krauzze.trenersapp.R
import com.krauzze.trenersapp.presentation.base.DiMoxyFragment
import com.krauzze.trenersapp.presentation.base.MoxyFragment
import kotlinx.android.synthetic.main.fragment_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import javax.inject.Provider

class MainFragment : DiMoxyFragment(), MainView {

    companion object {
        fun getInstance() = MainFragment()
    }

    @Inject
    lateinit var presenterProvider: Provider<MainPresenter>

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter = presenterProvider.get()

    @field:MainQualifier
    @field:Inject
    lateinit var navigator: Navigator

    @field:MainQualifier
    @field:Inject
    lateinit var navigatorHolder: NavigatorHolder

    @field:MainQualifier
    @field:Inject
    lateinit var router: Router

    @field:MainQualifier("cover")
    @field:Inject
    lateinit var coverNavigator: Navigator

    @field:MainQualifier("cover")
    @field:Inject
    lateinit var coverNavigatorHolder: NavigatorHolder

    @field:MainQualifier("cover")
    @field:Inject
    lateinit var coverRouter: Router

    val container = R.id.main_container

    val coverContainerWithMenu = R.id.cover_container_with_menu

    override val layout = R.layout.fragment_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate(savedInstanceState != null)
    }

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        main_view_pager.adapter = MainPagerAdapter(childFragmentManager)
        main_view_pager.offscreenPageLimit = 1
        main_view_pager.setOnTouchListener { _, _ -> true }
        bottom_navigation.setOnNavigationItemSelectedListener {
            val coverFragment = childFragmentManager.findFragmentById(coverContainerWithMenu)
            coverFragment?.let {
                coverRouter.backTo(null)
            }
            val current = bottom_navigation.selectedItemId
            if (current != it.itemId)
                when (it.itemId) {
                    R.id.action_home -> main_view_pager.currentItem = 0
                    R.id.action_find -> main_view_pager.currentItem = 1
                    R.id.action_notif -> main_view_pager.currentItem = 2
                    R.id.action_profile -> main_view_pager.currentItem = 3
                }
            true
        }
    }

    override fun selectCardItem() {
        //bottom_navigation.selectedItemId = R.id.action_card
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
        coverNavigatorHolder.setNavigator(coverNavigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        coverNavigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed(): Boolean {
        val topFragment = childFragmentManager.findFragmentById(coverContainerWithMenu)
        if (topFragment is MoxyFragment) {
            return topFragment.onBackPressed()
        }
        return super.onBackPressed()
    }
}

