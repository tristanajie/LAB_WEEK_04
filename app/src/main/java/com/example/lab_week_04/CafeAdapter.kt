package com.example.lab_week_04

import android.content.Context
import android.provider.Settings.Secure.getString
import android.provider.Settings.System.getString
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)

class CafeAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val context: Context // Add context parameter here
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val cafeContents = listOf(
        context.getString(R.string.starbucks_desc),
        context.getString(R.string.janjijiwa_desc),
        context.getString(R.string.kopikenangan_desc)
    )

    override fun getItemCount(): Int {
        return TABS_FIXED.size
    }

    override fun createFragment(position: Int): Fragment {
        // Pass the corresponding content to the fragment
        return CafeDetailFragment.newInstance(cafeContents[position])
    }
}
