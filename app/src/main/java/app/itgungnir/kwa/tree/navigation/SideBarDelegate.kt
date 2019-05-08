package app.itgungnir.kwa.tree.navigation

import android.graphics.Color
import android.os.Bundle
import android.view.View
import app.itgungnir.kwa.R
import app.itgungnir.kwa.common.widget.easy_adapter.BaseDelegate
import app.itgungnir.kwa.common.widget.easy_adapter.EasyAdapter
import kotlinx.android.synthetic.main.listitem_side_bar.view.*
import org.jetbrains.anko.backgroundColor

class SideBarDelegate(
    private val tabClickCallback: (Int) -> Unit
) : BaseDelegate<NavigationState.NavTabVO>() {

    override fun layoutId(): Int = R.layout.listitem_side_bar

    override fun onCreateVH(container: View) {
    }

    override fun onBindVH(
        item: NavigationState.NavTabVO,
        holder: EasyAdapter.VH,
        position: Int,
        payloads: MutableList<Bundle>
    ) {

        holder.render(item) {

            this.setOnClickListener {
                tabClickCallback.invoke(position)
            }

            name.apply {
                text = item.name
                backgroundColor = if (payloads.isNullOrEmpty()) {
                    when (item.selected) {
                        true -> Color.WHITE
                        else -> Color.parseColor("#FFF5F5F5")
                    }
                } else {
                    val payload = payloads[0]
                    when (payload["PL_SELECT"]) {
                        true -> Color.WHITE
                        else -> Color.parseColor("#FFF5F5F5")
                    }
                }
            }
        }
    }
}