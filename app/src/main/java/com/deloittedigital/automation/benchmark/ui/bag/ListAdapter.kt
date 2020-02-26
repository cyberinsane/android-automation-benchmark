package com.deloittedigital.automation.benchmark.ui.bag

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.deloittedigital.automation.benchmark.R
import com.deloittedigital.automation.benchmark.ui.AddCardActivity
import com.deloittedigital.automation.benchmark.ui.bag.ListAdapter.WalletType.ACTION_CARD
import com.deloittedigital.automation.benchmark.ui.bag.ListAdapter.WalletType.CREDIT_CARD
import kotlinx.android.synthetic.main.item_action_card.view.*
import kotlinx.android.synthetic.main.item_list_view.view.*

class ListAdapter constructor(private val context: Context, private var cards: List<String>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            ACTION_CARD -> {
                return ActionCardViewHolder(
                    LayoutInflater.from(context).inflate(
                        R.layout.item_action_card,
                        parent,
                        false
                    )
                )
            }
            CREDIT_CARD -> {
                return CreditCardViewHolder(
                    LayoutInflater.from(context).inflate(
                        R.layout.item_list_view,
                        parent,
                        false
                    )
                )
            }
            else -> {
                throw IllegalArgumentException("Invalid view type")
            }
        }
    }

    override fun getItemCount(): Int {
        cards?.size?.let {
            return it + 1
        }
        return 1
    }

    override fun getItemViewType(position: Int): Int {
        cards?.size?.let {
            if (position < it) {
                return CREDIT_CARD
            }
        }
        return ACTION_CARD
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CreditCardViewHolder) {
            val content: List<String>? = cards?.get(position)?.split(",")
            content?.let {
                holder.cardNumber.text = content[0]
                holder.expiryDate.text = content[1]
                holder.walletName.text = content[2]
                holder.zip.text = content[3]

                holder.itemView.setOnClickListener {
                    Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                }

            }
        } else if (holder is ActionCardViewHolder) {
            if (cards?.size == 2) {
                holder.checkoutActionCard.text = context.getString(R.string.max_credit_cards)
            } else {
                holder.checkoutActionCard.text = context.getString(R.string.add_credit_cards)
                holder.checkoutActionCard.setOnClickListener {
                    context.startActivity(Intent(context, AddCardActivity::class.java))
                }
            }
        }
    }

    class CreditCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardNumber: TextView = itemView.walletCardNumber
        var walletName: TextView = itemView.walletName
        var zip: TextView = itemView.walletCardZip
        var expiryDate: TextView = itemView.walletExpBalance
    }

    class ActionCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var checkoutActionCard: TextView = itemView.checkout_action_credit_card
    }

    object WalletType {
        const val CREDIT_CARD = 1
        const val ACTION_CARD = 2
    }
}