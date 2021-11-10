package com.example.salarycalculator

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.salarycalculator.employee.SalariedEmployee
import kotlinx.coroutines.NonCancellable.cancel
import android.widget.RadioGroup
import androidx.fragment.app.FragmentActivity


class DialogFragmentX : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_x, container, false)
    }

    companion object {
        //        const val TAG = "xDialogFragment"
        const val TAG = "SimpleDialog"


    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val array = arrayOf<CharSequence>("Hourly", "Salaried")
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            builder.setView(inflater.inflate(R.layout.fragment_dialog_x, null))
                // Add action buttons
                .setTitle("Add employee form")
                .setSingleChoiceItems(array, -1
                ) { dialog, which ->
                    Log.d("IDID", which.toString())
                    if (which == 0){
                        val hourlyET = it.findViewById<EditText>(R.id.hourlyWageET)
            val salariedET = it.findViewById<EditText>(R.id.weeklySalaryET)

                        hourlyET.isEnabled = true
                        salariedET.isEnabled = false
                    } else {
                        val hourlyET = it.findViewById<EditText>(R.id.hourlyWageET)
                        val salariedET = it.findViewById<EditText>(R.id.weeklySalaryET)

                        hourlyET.isEnabled = false
                        salariedET.isEnabled = true
                    }

                }
                .setPositiveButton("Sign in",
                    DialogInterface.OnClickListener { dialog, id ->
                        // sign in the user ...
                        val mainActivity:MainActivity = activity as MainActivity
                        val list = mainActivity.employeeList
                        list.add(SalariedEmployee(3,"aa","bb",300.0))
                        mainActivity.employeeAdapter.notifyDataSetChanged()
                        dialog.dismiss()
                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    })

            builder.create()


        } ?: throw IllegalStateException("Activity cannot be null")


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val hourlyRadioBtn = view.findViewById<RadioButton>(R.id.hourlyRadioBtn)
//        val salariedRadioBtn = view.findViewById<RadioButton>(R.id.salariedRadioBtn)
//
//
//        hourlyRadioBtn.text = "hjjhjhjh"
//
//        hourlyRadioBtn!!.setOnClickListener {
//            val hourlyET = view.findViewById<EditText>(R.id.hourlyWageET)
//            val salariedET = view.findViewById<EditText>(R.id.weeklySalaryET)
//            val tv = view.findViewById<TextView>(R.id.textView)
//
//            tv.text = "id.toString()"
//            hourlyET.isEnabled = true
//            salariedET.isEnabled = false
//        }
//
//        salariedRadioBtn!!.setOnClickListener {
//            val hourlyET = view.findViewById<EditText>(R.id.hourlyWageET)
//            val salariedET = view.findViewById<EditText>(R.id.weeklySalaryET)
//            val tv = view.findViewById<TextView>(R.id.textView)
//
//            tv.text = "id.toString()"
//            hourlyET.isEnabled = false
//            salariedET.isEnabled = true
//
//        }

//
//        val tv = view.findViewById<TextView>(R.id.textView)
//
//        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
//        radioGroup.setOnCheckedChangeListener {radioGroup, id -> tv.text = id.toString()}

//        radioGroup.check(R.id.salariedRadioBtn)
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//            override  onCheckedChanged(RadioGroup radioGroup, int i) {
//                int clickedPos= (int) radioGroup.getTag();
//                messageArrayList.get(clickedPos).setSelectedRadioButtonId(radioButtonID);
//            }
//        })

//        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
//            val clickedPos = radioGroup.tag as Int
////            Toast.makeText(context,clickedPos.toString(),Toast.LENGTH_SHORT).show()
////            messageArrayList.get(clickedPos).setSelectedRadioButtonId(radioButtonID)
//        })

//        hourlyRadioBtn.setOnClickListener {
//            val hourlyET = view.findViewById<EditText>(R.id.hourlyWageET)
//            val salariedET = view.findViewById<EditText>(R.id.weeklySalaryET)
//            if (hourlyRadioBtn.isChecked){
//                hourlyET.isEnabled = true
//                salariedET.isEnabled = false
//            }
//        }
//
//        salariedRadioBtn.setOnClickListener{
//            val hourlyET = view.findViewById<EditText>(R.id.hourlyWageET)
//            val salariedET = view.findViewById<EditText>(R.id.weeklySalaryET)
//            if (salariedRadioBtn.isChecked){
//                hourlyET.isEnabled = false
//                salariedET.isEnabled = true
//            }
//        }
    }

}