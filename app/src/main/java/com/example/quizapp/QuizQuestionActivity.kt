package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionList:ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int = 0
    private var mCorrectAnswers:Int = 0
    private var mUserName:String? = null
    private var isOptionSelected:Boolean = false
    lateinit var question:Question

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        tv_opt1.setOnClickListener(this)
        tv_opt2.setOnClickListener(this)
        tv_opt3.setOnClickListener(this)
        tv_opt4.setOnClickListener(this)

        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){

        val num = (0..9).shuffled()

        for(i in num) {
             question = mQuestionList!![i]
        }

            //val question = mQuestionList!![mCurrentPosition -1]

        defaultOptionView()

        if(mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "FINISH"
        } else{
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_opt1.text = question.optionOne
        tv_opt2.text = question.optionTwo
        tv_opt3.text = question.optionThree
        tv_opt4.text = question.optionFour
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_opt1)
        options.add(1, tv_opt2)
        options.add(2, tv_opt3)
        options.add(3, tv_opt4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
            R.drawable.default_option_border_bg)
        }

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tv_opt1 -> {
                selectedOptionView(tv_opt1, 1)
            }
            R.id.tv_opt2 -> {
                selectedOptionView(tv_opt2, 2)
            }
            R.id.tv_opt3 -> {
                selectedOptionView(tv_opt3, 3)
            }
            R.id.tv_opt4 -> {
                selectedOptionView(tv_opt4, 4)
            }
            R.id.btn_submit ->{
                if (mSelectedOptionPosition ==0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                            isOptionSelected =false
                        }else ->{
                            Toast.makeText(this, "You have successfully completed the Quiz", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                        startActivity(intent)
                        finish()
                    }
                    }
                }else {
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border)
                    isOptionSelected = true

                    if(mCurrentPosition==mQuestionList!!.size) {
                        btn_submit.text = "FINISH"
                    }else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView:Int){
        when(answer){
            1 -> {
                tv_opt1.background =ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tv_opt2.background =ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tv_opt3.background =ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tv_opt4.background =ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        if(!isOptionSelected) {
            defaultOptionView()
            mSelectedOptionPosition = selectedOptionNum

            tv.setTextColor(Color.parseColor("#363A43"))
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this,
                R.drawable.selected_option_border)
        }
    }
}