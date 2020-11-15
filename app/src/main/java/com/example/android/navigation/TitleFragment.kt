package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentTitleBinding.inflate(inflater)

        //tell android that this fragment has a menu
        setHasOptionsMenu(true)
        binding.playButton.setOnClickListener {
            //Navigation can also create onClickListener
            //  Navigation.createNavigateOnClickListener()
            findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
            //add menu

        }
        return binding.root
    }

    //called to inflate the menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    //onOptionsItemSelected called when menu item is selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        //onNavDestinationSelected passing in the MenuItem and NavController
        return NavigationUI.onNavDestinationSelected(item, findNavController())
                || super.onOptionsItemSelected(item)

    }
}