package com.faskn.core.base

import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.doOnPreDraw
import androidx.databinding.BindingAdapter
import com.faskn.core.utils.extensions.hide
import com.faskn.core.utils.extensions.show
import com.squareup.picasso.Picasso

/**
 * Created by Furkan on 15.07.2020
 */

@BindingAdapter("visibility")
fun setVisibility(view: View, isVisible: Boolean) {
    if (isVisible) {
        view.show()
    } else {
        view.hide()
    }
}

@BindingAdapter("drawableLink")
fun drawableLink(view: ImageView, photoreference: String?) {
    if (photoreference.isNullOrEmpty())
        return
    view.doOnPreDraw {
        val maxWidth = view.measuredWidth
        val maxHeight = view.measuredHeight
        val fullImageUrl =
            Constants.NetworkService.BASE_IMAGE_URL + "maxwidth=$maxWidth&photoreference=$photoreference&key=${Constants.NetworkService.API_KEY}"
        Picasso.get().cancelRequest(view)
        Picasso.get().load(fullImageUrl).resize(maxWidth, maxHeight).centerCrop(Gravity.CENTER)
            .into(view)
    }
}

@BindingAdapter("staticDrawableLink")
fun staticDrawableLink(view: ImageView, imageURL: String?) {
    if (imageURL.isNullOrEmpty())
        return
    Picasso.get().cancelRequest(view)
    Picasso.get().load(imageURL).into(view)
}

@BindingAdapter("setErrorView")
fun setErrorView(view: View, show: Boolean) {
    if (show)
        view.show()
    else
        view.hide()

    view.setOnClickListener { view.hide() }
}

@BindingAdapter("setErrorText")
fun setErrorText(view: TextView, errorText: Int) {
    if (errorText == 0)
        return
    view.text = view.context.getString(errorText)
}
