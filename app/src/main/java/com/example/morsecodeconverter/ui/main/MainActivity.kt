package com.example.morsecodeconverter.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.morsecodeconverter.R
import com.example.morsecodeconverter.databinding.MainActivityLayoutBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity () {
    private lateinit var mBinding: MainActivityLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = MainActivityLayoutBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initView()
    }

    private fun initView() {
        mBinding.rgConversionType.setOnCheckedChangeListener(onCheckedChangeListener)
    }

    private val onCheckedChangeListener = RadioGroup.OnCheckedChangeListener { _, checkedId ->
        when (checkedId) {
            R.id.rb_alphabet_to_morse -> {
                mBinding.tvTopMenuTitle.text = getString(R.string.morse_to_alphabet)
                mBinding.layoutInputBtn.visibility = View.GONE
                mBinding.edInput.filters = inputFilterAlphabet
            }

            R.id.rb_morse_to_alphabet -> {
                mBinding.tvTopMenuTitle.text = getString(R.string.alphabet_to_morse)
                mBinding.layoutInputBtn.visibility = View.VISIBLE
                mBinding.edInput.filters = inputFilterMorse
            }
        }
    }


    private val inputFilterAlphabet = arrayOf(InputFilter { charSequence, _, _, _, _, _ ->
        val ps = Pattern.compile("^[A-Z\\s0-9^]")
        if (!ps.matcher(charSequence).matches()) {
            ""
        } else {
            charSequence
        }
    })

    private val inputFilterMorse = arrayOf(InputFilter { charSequence, _, _, _, _, _ ->
        val ps = Pattern.compile("^[·–\\s]")
        if (!ps.matcher(charSequence).matches()) {
            ""
        } else {
            charSequence
        }
    })

    private val textWatcherAlphabet = object :TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            TODO("Not yet implemented")
        }

        override fun afterTextChanged(p0: Editable?) {
            TODO("Not yet implemented")
        }

    }

}