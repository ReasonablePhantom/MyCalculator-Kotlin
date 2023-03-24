package com.example.mycalculator_kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator.*

class MainActivity : AppCompatActivity() {

    //延迟初始化
    private  val tvresult: TextView by lazy {
        findViewById<TextView>(R.id.tv_result)
    }

    private var operator = "" // 操作符
    private var firstNum = "" // 前一个操作数
    private var nextNum = "" // 后一个操作数


    //-------------------------自定义方法  Start-----------------------
    /*
        设置firstNum、nextNum、operator的值，并设置显示
     */
    private fun setMyValue( myvalue:String){
        when (operator){
            "√" -> {
                firstNum = ""
                nextNum = myvalue
            }
            else ->{
                if(firstNum.trim() ==""){
                    firstNum +=  myvalue
                }
                else{
                    if(operator.trim() == ""){
                        firstNum +=  myvalue
                    }
                    else{

                        nextNum +=  myvalue

                    }
                }
            }
        }

        showdisplaybar()
    }

    /*
        在计数器的显示栏显示
     */
    private fun showdisplaybar() {
        tvresult.text = String.format(resources.getString(R.string.display_Bar), firstNum, operator, nextNum)
    }

    //-------------------------自定义方法  END-----------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)



        /*
           加号
       */
        btn_plus.setOnClickListener{

            operator = "+"
            showdisplaybar()

        }

        /*
            减号
        */
        btn_minus.setOnClickListener{
            /*
                注意一下：
                当operator 没有值的时候，点击减号，operator里面设置成减号
                当operator 存在值的时候（比如加号、减号、乘号等），点击减号，把nextNum变成负数（前提nextNum没有值的情况下）
             */
            if(nextNum=="")
            {
                if(operator=="")
                {
                    operator = "-"
                }
                else
                {
                    nextNum = "-"
                }
            }

            showdisplaybar()
        }

        /*
            除法
        */
        btn_divide.setOnClickListener{
            operator = "÷"
            showdisplaybar()
        }

        /*
            乘法
        */
        btn_multiply.setOnClickListener{
            operator = "×"
            showdisplaybar()
        }

        /*
           平方
       */
        ib_sqrt.setOnClickListener{
            /*
                规则：
                必须先点击平方根符号，再点击数字，才能进行平方根的运算
             */
            if(firstNum==""){
                operator = "√"
            }
            showdisplaybar()
        }

        /*
           点号
       */
        btn_dot.setOnClickListener{
            if(operator=="" ){
                if(firstNum!="") {
                    firstNum +=  "."
                }
                else{
                    firstNum = "0."
                }
            }
            else{
                if(nextNum!="") {
                    nextNum +=  "."
                }
                else{
                    nextNum = "0."
                }
            }
            showdisplaybar()
        }

        /*
            等号
        */
        btn_equal.setOnClickListener{
            var result:Double = 0.00
            when(operator){
                "+" -> result = firstNum.toDouble() + nextNum.toDouble()
                "-" -> result = firstNum.toDouble() - nextNum.toDouble()
                "×" -> result = firstNum.toDouble() * nextNum.toDouble()
                "÷" -> result = firstNum.toDouble() / nextNum.toDouble()
                "√" -> result = java.lang.Math.sqrt(nextNum.toDouble())
            }

            tvresult.setText(result.toString())
            firstNum = ""
            nextNum =""
            operator = ""
            result = 0.00
        }

        /*
            取消
         */
        btn_cancel.setOnClickListener{
            if(nextNum!=""){
                nextNum = ""
            }
            else{
                if(operator!="")
                {
                    operator = ""
                }
                else{
                    firstNum = ""
                }
            }
            showdisplaybar()
        }

        /*
            清除
        */
        btn_clear.setOnClickListener{

            firstNum = ""
            nextNum =""
            operator = ""
            showdisplaybar()
        }

        /*
            7
        */
        btn_seven.setOnClickListener{
            setMyValue("7")

        }

        /*
            8
        */
        btn_eight.setOnClickListener{
            setMyValue("8")
        }

        /*
            9
        */
        btn_nine.setOnClickListener{
            setMyValue("9")
        }

        /*
            4
        */
        btn_four.setOnClickListener{
            setMyValue("4")
        }

        /*
            5
        */
        btn_five.setOnClickListener{
            setMyValue("5")
        }

        /*
            6
        */
        btn_six.setOnClickListener{
            setMyValue("6")
        }

        /*
            1
        */
        btn_one.setOnClickListener{
            setMyValue("1")
        }

        /*
            2
        */
        btn_two.setOnClickListener{
            setMyValue("2")
        }

        /*
            3
        */
        btn_three.setOnClickListener{
            setMyValue("3")
        }

        /*
            0
        */
        btn_zero.setOnClickListener{
            setMyValue("0")
        }



    }
}