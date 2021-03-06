package com.pakt_games.layoutandfragmentexample

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pakt_games.layoutandfragmentexample.utilities.replaceFragmentSafely
import kotlinx.android.synthetic.main.fragment_question_answer.*


class QuestionAnswer : Fragment() {


    var getIngWord:String?=""
    var getTrWordArray:Array<String>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_answer, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getIngWord=arguments?.getString("ingWord")
        getTrWordArray=arguments?.getStringArray("trWordArray")
        main_word.setText(getIngWord)
        btnA.setText(getTrWordArray?.get(0))
        btnB.setText(getTrWordArray?.get(1))
        btnC.setText(getTrWordArray?.get(2))
        btnD.setText(getTrWordArray?.get(3))
        startTimer()
    }

     fun startTimer()
    {
        val timer = object: CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer_object.text=(millisUntilFinished/1000).toString()
                progress_circular_object.progress-=5;
            }

            override fun onFinish() {
               timer_object.text="0";
            }
        }
        timer.start()
    }


}