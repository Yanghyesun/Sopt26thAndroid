package com.hyesun.sopt26thandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    lateinit var instaAdapter: InstaRecyclerAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val instaData = listOf(
            InstaData(
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/prince-louis-birthday-photo-1587591347.jpg?crop=1xw:1xh;center,top&resize=480:*",
                "양혜선",
                "https://images.unsplash.com/photo-1531804055935-76f44d7c3621?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80"
            ),
            InstaData(
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/prince-louis-birthday-photo-1587591347.jpg?crop=1xw:1xh;center,top&resize=480:*",
                "양혜선",
                "https://images.unsplash.com/photo-1531804055935-76f44d7c3621?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80"
            ),
            InstaData(
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/prince-louis-birthday-photo-1587591347.jpg?crop=1xw:1xh;center,top&resize=480:*",
                "양혜선",
                "https://images.unsplash.com/photo-1531804055935-76f44d7c3621?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80"
            )
        )

        instaAdapter = InstaRecyclerAdapter(context!!)
        home_recycler.adapter = instaAdapter
        home_recycler.addItemDecoration(VerticalItemDecoration(24))
        instaAdapter.data = instaData
        instaAdapter.notifyDataSetChanged()
    }
}
