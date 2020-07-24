package com.example.alpaki.presentation.util.customs

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import com.example.alpaki.R
import com.example.alpaki.presentation.util.use
import kotlinx.android.synthetic.main.title_bar.view.*

class TitleBarView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.style.TitleBar
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var onBackClicked: (() -> Unit)? = null

    init {
        inflate(context, R.layout.title_bar, this)
        applyAttributes(attrs, defStyleAttr)
    }

    @SuppressLint("Recycle")
    private fun applyAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        context.obtainStyledAttributes(attrs, R.styleable.TitleBarView, defStyleAttr, 0).use {
            textTitle.text = getString(R.styleable.TitleBarView_android_text)
            getDrawable(R.styleable.TitleBarView_leftDrawable)?.let {
                imageLeftIcon.setImageDrawable(it)
            }
            getDrawable(R.styleable.TitleBarView_rightDrawable)?.let {
                imageRightIcon.setImageDrawable(it)
            }
        }

        imageLeftIcon.setOnClickListener {
            onBackClicked?.invoke()
            findNavController().navigateUp()
        }
    }

    fun setLeftIconClickListener(action: () -> Unit) {
        imageLeftIcon.setOnClickListener { action() }
    }

    fun setRightIconClickListener(action: () -> Unit) {
        imageRightIcon.setOnClickListener { action() }
    }

    fun setOnBackClicked(block: () -> Unit) {
        onBackClicked = block
    }

    fun setText(text: String) {
        textTitle.text = text
    }

    fun setText(@StringRes stringId: Int) {
        textTitle.text = context.getString(stringId)
    }
}
