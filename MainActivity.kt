package com.example.kotlindersleri

import android.nfc.Tag
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import kotlin.random.Random
private const val TAG ="MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var ethesaptutarı:EditText
    private lateinit var seekBaryüzde:SeekBar
    private lateinit var tvtiptutarı:TextView
    private lateinit var tipyüzdesi:TextView
    private lateinit var tvtotalhesap:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ethesaptutarı=findViewById(R.id.ethesaptutarı)
        seekBaryüzde=findViewById(R.id.seekBaryüzde)
        tvtiptutarı=findViewById(R.id.tvtiptutarı)
        tipyüzdesi=findViewById(R.id.tipyüzdesi)
        tvtotalhesap=findViewById(R.id.tvtotalhesap)

        ethesaptutarı.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG,"afterTextChanged $s")
                bahşişvetoplamıhesapla()

            }

        })

        seekBaryüzde.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.i(TAG,"onProgressChanged $progress")
                tipyüzdesi.text="$progress%"
                bahşişvetoplamıhesapla()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

    }

    private fun bahşişvetoplamıhesapla() {
        val hesaptutarı=ethesaptutarı.text.toString().toDouble()
        val tippercent=seekBaryüzde.progress
        val tiptutarı=hesaptutarı*tippercent/100
        val hepsi=tiptutarı+hesaptutarı
        tvtiptutarı.text=String.format("%.2f", tiptutarı)
        tvtotalhesap.text=String.format("%.2f", hepsi)

    }
}