package pt.mrpeace.development.timeexampleapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_time_picker.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pt.mrpeace.development.timeexampleapp.R
import pt.mrpeace.development.timeexampleapp.viewmodel.TimeDetailViewModel
import pt.mrpeace.development.timeexampleapp.viewmodel.TimePickerViewModel


class TimePickerFragment : Fragment() {
    private val timePickerViewModel: TimePickerViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_picker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        time_picker.setIs24HourView(true)

        timePickerViewModel.timeText.observe(viewLifecycleOwner, Observer {
            last_stored_time.text = "New Time: $it"
        })

        time_picker.setOnTimeChangedListener { _, hour, minute ->
            last_stored_time.text = ""
            timePickerViewModel.setTime("$hour:$minute")
        }
    }


}