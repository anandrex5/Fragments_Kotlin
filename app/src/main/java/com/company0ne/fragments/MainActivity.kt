package com.company0ne.fragments


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var replace: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replace = findViewById(R.id.buttonReplace)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = FirstFragment()
        fragmentTransaction.add(R.id.frame, firstFragment)
        fragmentTransaction.commit()

        replace.setOnClickListener {
            //Add Second Fragment
            val secondFragmentManager: FragmentManager = supportFragmentManager
            val secondFragmentTransaction: FragmentTransaction =
                secondFragmentManager.beginTransaction()
            //replace() for replacing firstFragment
            val secondFragment = SecondFragment()
            secondFragmentTransaction.replace(R.id.frame, secondFragment)
            //add BackStack
            secondFragmentTransaction.addToBackStack(null)
            secondFragmentTransaction.commit()
        }
    }
}