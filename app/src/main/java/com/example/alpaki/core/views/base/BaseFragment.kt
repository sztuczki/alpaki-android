package com.example.alpaki.core.views.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<TViewBinding : ViewDataBinding> : Fragment() {

    private var innerBinding: TViewBinding? = null
    protected val binding: TViewBinding
        get() = innerBinding ?: throw IllegalStateException()

    abstract val layoutId: Int

    protected val baseActivity: BaseActivity<*>
        get() = activity as BaseActivity<*>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        innerBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        innerBinding = null
    }
}