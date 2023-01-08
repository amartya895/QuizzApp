package com.example.quizzapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*


class QuestionActivity : AppCompatActivity() {
    private var name:String ?=null
    private var score:Int = 0
    private var questionList:ArrayList<QuestionData>?=null
    private var currentPosition:Int = 1
    private var selectedOption:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)


        name = intent.getStringExtra(setData.name)

       questionList = setData.getQuestion()
        setQuestion()

        option_1.setOnClickListener{
            selectedOptionStyle(option_1,1)
        }
         option_2.setOnClickListener{
            selectedOptionStyle(option_2,2)
        }
         option_3.setOnClickListener{
            selectedOptionStyle(option_3,3)
        }
         option_4.setOnClickListener{
            selectedOptionStyle(option_4,4)
        }
        btn_submit.setOnClickListener {
            if(selectedOption != 0)
            {
                var que = questionList!![currentPosition-1]
                if(selectedOption != que.correct_ans)
                {
                    setColor(selectedOption,R.drawable.wrong_question_option)
                }
                else
                {
                    score++
                }
                setColor(que.correct_ans,R.drawable.correct_question_option)

                if(currentPosition == questionList!!.size)
                {
                    btn_submit.text = "Finish"
                }
                else
                {
                    btn_submit.text = "Next"
                }
            }
            else
            {
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }
                    else->
                    {
                        var intent = Intent(this,Result::class.java)
                        intent.putExtra(setData.name,name)
                        intent.putExtra(setData.score,score.toString())
                        intent.putExtra("Total Size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }


            }
            selectedOption = 0
        }


    }

    private fun setColor(opt:Int,color:Int) {

        when(opt)
        {
            1->{
                option_1.background = ContextCompat.getDrawable(this,color)
            }
            2->{
                option_2.background = ContextCompat.getDrawable(this,color)
            }
            3->{
                option_3.background = ContextCompat.getDrawable(this,color)
            }
            4->{
                option_4.background = ContextCompat.getDrawable(this,color)
            }
        }

    }

    private fun setQuestion() {
        setOptionStyle()
       val question = questionList!![currentPosition-1]
         progress_bar.progress = currentPosition
         progress_bar.max = questionList!!.size
        progress_bar_text.text =  "${currentPosition}/ ${questionList!!.size}"
        question_text.text = question.question
        option_1.text = question.option_one
        option_2.text = question.option_two
        option_3.text = question.option_three
        option_4.text = question.option_four

    }

    private  fun setOptionStyle()
    {
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,option_1)
        optionList.add(1,option_2)
        optionList.add(2,option_3)
        optionList.add(3,option_4)

        for(op in optionList)
        {
            op.setTextColor(Color.parseColor("#504646"))
            op.background = ContextCompat.getDrawable(this,R.drawable.questionoption)
            op.typeface = Typeface.DEFAULT
        }
    }

    private fun selectedOptionStyle(view:TextView,opt:Int){

        setOptionStyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}