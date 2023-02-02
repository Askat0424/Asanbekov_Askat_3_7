package com.example.asanbekov_askat_3_7


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.asanbekov_askat_3_7.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var RickList: ArrayList<User>

    companion object {
        const val KEY_FOR_USER = "USER"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()

        val adapter = RickAdapter(RickList, this::onClick)
        binding.rcViewRick.adapter = adapter

    }

    private fun loadData() {
        RickList = ArrayList()
        RickList.add(User("Rick Sanchez", "Alive", R.drawable.img_3))
        RickList.add(User("Morty Smith", "Alive", R.drawable.img_2))
        RickList.add(User("Albert Einstein", "Alive", R.drawable.img))
        RickList.add(User("Jerry Smith", "Alive", R.drawable.img_1))
        RickList.add(User("Rick Sanchez", "Alive", R.drawable.img_3))
        RickList.add(User("Morty Smith", "Alive", R.drawable.img_2))
        RickList.add(User("Albert Einstein", "Alive", R.drawable.img))
        RickList.add(User("Jerry Smith", "Alive", R.drawable.img_1))
    }

    private fun onClick(position: Int){
        findNavController().navigate(R.id.detailFragment, bundleOf(KEY_FOR_USER to RickList[position]))
    }
}