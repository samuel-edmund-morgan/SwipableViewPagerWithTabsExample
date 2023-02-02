package com.example.swipableviewpagerwithtabsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.swipableviewpagerwithtabsexample.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private  val activityMainBinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)


        val images = listOf(
            R.drawable.first_image,
            R.drawable.second_image,
            R.drawable.third_image
        )

        activityMainBinding.MyPager.adapter = PagerAdapter(images)

        TabLayoutMediator(activityMainBinding.tlTabs, activityMainBinding.MyPager){ tab, position ->
            tab.text = "Tab ${position+1}"
        }.attach()


        //If you need some actions when you select tab, you can do this:
        activityMainBinding.tlTabs.addOnTabSelectedListener(object :OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Selected ${tab?.text}",Toast.LENGTH_LONG).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Unselected ${tab?.text}",Toast.LENGTH_LONG).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Reselected ${tab?.text}",Toast.LENGTH_LONG).show()
            }
        })


    }
}