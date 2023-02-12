package com.ayushwalker.creatingswipableviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

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

        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL // This is when you want to change the swipe orientation, by de default, it is horizontal

        // For making the fake drag animation
        viewPager.beginFakeDrag()
        viewPager.fakeDragBy(-7f)
        viewPager.endFakeDrag()
    }
}

/*
NOTES/ STEPS :-
1. Add ( implementation 'com.google.android.material:material:1.9.0-alpha01' ) in the build (:app) gradle file
2. Add viewPager2 in activity_main.xml file and add constraints to it
3. Since it works on RecyclerView Adapter, we need to create a RecyclerViewAdapter Class (we named it as  ViewPagerAdapter )
4. Now add images Id as the list.
5. Now you are good to go..
 */