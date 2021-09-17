package com.farnadsoft.dadjoke
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//    class JokeRecyclerAdapter(private val list: ArrayList<JokeData>) : RecyclerView.Adapter<JokeRecyclerAdapter.ViewHolder>() {
//
//        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//            // Create a new view, which defines the UI of the list item
//             val view = LayoutInflater.from(viewGroup.context)
//             .inflate(R.layout.joke_item, viewGroup, false)
//            return ViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//            val item=list[position]
//            //holder.txt_id.text=item.id //uncomment if you need to show it in recycler view
//            holder.txt_joke.text=item.joke
//            //holder.txt_status.text=item.status.toString() //uncomment if you need to show it in recycler view
//
//        }
//
//        override fun getItemCount(): Int {
//            return list.size
//        }
//
//        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//
//            var root:ViewGroup
//
//            var txt_joke: TextView
//            // var txt_id: TextView //uncomment if you need to show it in recycler view
//            // var txt_status: TextView //uncomment if you need to show it in recycler view
//
//            init {
//                // Define click listener for the ViewHolder's View.
//                root=view as ViewGroup
//                txt_joke = view.findViewById(R.id.txt_joke)
//                // txt_id = view.findViewById(R.id.txt_id) //uncomment if you need to show it in recycler view
//                // txt_status = view.findViewById(R.id.txt_status) //uncomment if you need to show it in recycler view
//            }
//        }
//
//
//    }