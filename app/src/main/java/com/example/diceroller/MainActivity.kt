package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
var i1=1
var i2=0

class dice(var sides:Int)
{
    val ln=4
    fun roll():Int{
        return (1..sides).random()
    }
}
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val rolldice:Button=findViewById(R.id.button)
        val p1=findViewById<TextView>(R.id.p1)

        p1.text="Player 1 chance"
        rolldice.setOnClickListener{
            roll()
            Toast.makeText(this,"Dice Rolled!",Toast.LENGTH_SHORT).show()
        }


    }
  var i=0

    private fun roll() {
        i1+=1
        i2+=1
        val d1=dice(6)
        val p1=findViewById<TextView>(R.id.p1)
        val p2=findViewById<TextView>(R.id.p2)
        if(i2%2==1) {
            p2.text = "Player 2 chance"
            p1.text=""

        }

       else if(i1%2==1)
        {
            p1.text="Player 1 chance"
            p2.text=""
            }
        val r=d1.roll()
        val image:ImageView=findViewById(R.id.imageView)
        val drawableResource = when(r)
        {
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else-> R.drawable.dice_6
        }
           image.setImageResource(drawableResource)

        val result:TextView= findViewById(R.id.textView)
        result.text= r.toString()
        val res=findViewById<TextView>(R.id.result)
        if(r==d1.ln) {
            if (i1%2==0)
                i=1
            else
                i=2
            res.text = "Player $i won !"
            p1.text=""
            p2.text=""
            return
        }
        else
            res.text=""

    }
}