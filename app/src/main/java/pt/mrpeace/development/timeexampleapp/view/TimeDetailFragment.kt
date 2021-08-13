package pt.mrpeace.development.timeexampleapp.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_time_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pt.mrpeace.development.timeexampleapp.R
import pt.mrpeace.development.timeexampleapp.viewmodel.TimeDetailViewModel

class TimeDetailFragment : Fragment() {
    private val timeDetailViewModel: TimeDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        timeDetailViewModel.timeText.observe(viewLifecycleOwner, Observer {
            timeTextChanged(it ?: "")
        })

        setClickListener()
        timeDetailViewModel.getTime()

    }

    private fun setClickListener() {
        about_button.setOnClickListener {
            findNavController().navigate(R.id.action_timeDetailFragment_to_infoFragment)
        }

        edit_button.setOnClickListener {
            findNavController().navigate(R.id.action_timeDetailFragment_to_timePickerFragment)
        }
    }

    private fun timeTextChanged(it: String) {
        time_text.text = it
    }
}