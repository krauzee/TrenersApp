package com.krauzze.trenersapp.presentation.ui.main.find

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.krauzze.trenersapp.R
import com.krauzze.trenersapp.domain.entity.TrenerEntity
import com.krauzze.trenersapp.presentation.base.DiMoxyFragment
import com.krauzze.trenersapp.presentation.models.TrenerModel
import kotlinx.android.synthetic.main.fragment_find.*
import javax.inject.Inject
import javax.inject.Provider

class FindFragment: DiMoxyFragment(), FindView {

    companion object {
        fun getInstance() = FindFragment()
    }

    @Inject
    lateinit var presenterProvider: Provider<FindPresenter>

    @InjectPresenter
    lateinit var presenter: FindPresenter

    @ProvidePresenter
    fun providePresenter() = presenterProvider.get()

    @Inject
    lateinit var pagerAdapter: TrenersPagerAdapter

    @Inject
    lateinit var trenersListAdapter: TrenersListAdapter

    override val layout = R.layout.fragment_find

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        pager.adapter = pagerAdapter
        pager.offscreenPageLimit = pagerAdapter.count
        pager.pageMargin = 25
        pager.clipChildren = false

        treners_list.adapter = trenersListAdapter
        treners_list.layoutManager = LinearLayoutManager(context)
    }

    override fun setTreners(treners: List<TrenerModel>) {

    }
}