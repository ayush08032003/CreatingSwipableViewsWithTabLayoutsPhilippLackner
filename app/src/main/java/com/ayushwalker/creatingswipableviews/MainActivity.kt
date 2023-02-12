package com.ayushwalker.creatingswipableviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf(
            R.drawable.jokerquote1,
            R.drawable.justbreathe,
            R.drawable.lifemoto,
            R.drawable.lordshiva,
            R.drawable.lordshiva2,
            R.drawable.wallpaper1,
        )

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter

        // This will connect out tabLayout with our ViewPager 2
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout,viewPager){tab, position ->
            tab.text =  "Tab ${position + 1}"
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Selected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "UnSelected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "ReSelected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

/*
NOTES/ STEPS :-
1. Add ( implementation 'com.google.android.material:material:1.9.0-alpha01' ) in the build (:app) gradle file
2. Add viewPager2 in activity_main.xml file and add constraints to it
3. Since it works on RecyclerView Adapter, we need to create a RecyclerViewAdapter Class (we named it as  ViewPagerAdapter )
4. Now add images Id as the list.
5. Now you are good to go..

Now If you want to add Tabs for images in the Swipable Menu, we need to do additonal process..
1. Add TabLayout in the activity_main.xml, also, change the ConstraintLayout into LinearLayout, as it is difficult to adjust the TabLayout in ConstraintLayout
2. Now Add TabLayoutMediator which will provide the way to merge imageview and tabs.
3. Also, addOnTabSelectedListener , this function acts as click listeners for the tabs.. !!
 */