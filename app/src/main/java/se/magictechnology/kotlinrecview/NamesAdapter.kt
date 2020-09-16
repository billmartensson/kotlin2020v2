package se.magictechnology.kotlinrecview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.name_item.view.*

class NamesAdapter() : RecyclerView.Adapter<NameViewHolder>() {

    var people = mutableListOf<String>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        Log.i("BILLDEBUG", "ADAPTER ATTACHED")

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        Log.i("BILLDEBUG", "CREATE VIEWHOLDER")

        val vh = NameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.name_item, parent, false))
        return vh
    }

    override fun getItemCount(): Int {
        return people.size
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        Log.i("BILLDEBUG", "BIND VIEWHOLDER " + position.toString())

        holder.nametext.text = people[position]

        holder.itemView.setOnClickListener {
            people.removeAt(position)
            this.notifyDataSetChanged()
        }
    }

    fun addNewName(newname : String)
    {
        if(newname == "")
        {
            Log.i("BILLDEBUG", "NAME EMPTY")
            return
        }

        if(people.contains(newname))
        {
            Log.i("BILLDEBUG", "NAME EXISTS")
            return
        }

        people.add(newname)
        notifyDataSetChanged()
    }

}

class NameViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    var nametext = view.nameTV

}