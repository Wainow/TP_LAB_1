package com.wainow.tp_lab_1.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar
import com.wainow.tp_lab_1.R
import com.wainow.tp_lab_1.ui.base.VMFactory
import com.wainow.tp_lab_1.ui.util.StringToIntMapper

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var resultView: TextView
    private lateinit var numbersView: EditText
    private lateinit var startView: Button
    private lateinit var layout: ConstraintLayout
    private var result = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        initView(view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, VMFactory()).get(MainViewModel::class.java)
        startView.setOnClickListener { setView(true) }
        setView()
    }

    private fun setView(isReset: Boolean = false){
        if(isReset && numbersView.text.isNotEmpty()) {
            var numbers: List<Int>
            try {
                numbers = StringToIntMapper.map(numbersView.text.toString())
                viewModel.setMostFrequent(numbers).toString()
            } catch (e: NumberFormatException){
                Snackbar
                    .make(layout, "ERROR: numbers is incorrect or too big", Snackbar.LENGTH_LONG).show()
                return
            }
        } else if(isReset && numbersView.text.isEmpty()) {
            Snackbar
                .make(layout, "Input is empty", Snackbar.LENGTH_LONG).show()
            return
        } else if(!isReset && viewModel.getMostFrequent().isNullOrEmpty()) {
            resultView.text = "Result will be here"
            return
        }
        resultView.text = viewModel.getMostFrequent().toString()
    }

    private fun initView(v: View){
        with(v){
            resultView = findViewById(R.id.result_tv)
            numbersView = findViewById(R.id.numbers_et)
            startView = findViewById(R.id.start_btn)
            layout = findViewById(R.id.main)
        }
    }

}