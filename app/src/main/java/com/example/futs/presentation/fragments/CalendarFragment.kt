package com.example.futs.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.widget.ViewPager2
import com.example.futs.R
import com.example.futs.data.cb.CompetitionFixtureRetrieved
import com.example.futs.data.model.Fixtures.Fixture
import com.example.futs.databinding.FragmentCalendarBinding
import com.example.futs.databinding.LayoutWeekViewBinding
import com.example.futs.databinding.LayoutWeekViewDateItemBinding
import com.example.futs.presentation.adapters.CalendarAdapter
import com.example.futs.util.*
import java.util.*


class CalendarFragment : Fragment(), CompetitionFixtureRetrieved, CalendarAdapter.WeeklyCalendarAdapterListener{

    private val _calendarViewModel = MutableLiveData<List<Fixture>?>()
    val calendarLiveData = _calendarViewModel

   private lateinit var binding: FragmentCalendarBinding
   private lateinit var weeklyBinding: LayoutWeekViewBinding

    private var currentPos: Int = 0
    val startDate = Date().time - (DAYS_IN_SINGLE_VIEW * PREVIOUS_WEEK * DAYS_IN_MS)
    val endDate = Date().time + (DAYS_IN_SINGLE_VIEW * UPCOMING_WEEK * DAYS_IN_MS)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCalendarBinding.inflate(layoutInflater)
        weeklyBinding = LayoutWeekViewBinding.bind(binding.root)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addListeners()
        initWeeklyViewPager()
    }

    private fun addListeners() {
        with(binding) {
            ivChevronLeft.setOnClickListener {
                if (currentPos > 0) {
                    vpWeekView.currentItem = (currentPos - 1)
                    currentPos -= 1
                }
            }
            ivChevronRight.setOnClickListener {
                if (currentPos < vpWeekView.adapter?.itemCount?.minus(1) ?: 0) {
                    vpWeekView.currentItem = (currentPos + 1)
                    currentPos += 1
                }
            }
            tvGoToToday.setOnClickListener {
                scrollToCurrentDate(Date(), startDate.toDate())
            }
        }
    }

    private fun initWeeklyViewPager() {
        with(binding.vpWeekView) {
            adapter =
                CalendarAdapter(this@CalendarFragment, startDate.toDate(), endDate.toDate())
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    updateMonth(
                        (binding.vpWeekView.adapter as WeeklyCalendarBaseAdapter).getItem(position)
                    )
                }
            })
        }
        scrollToCurrentDate(Date(), startDate.toDate())
    }

    private fun scrollToCurrentDate (
        targetDate: Date,
        startDate: Date
    ) {
        val startCalendar = Calendar.getInstance(Locale.getDefault())
        startCalendar.time = startDate
        startCalendar.getNearestSunday()

        val targetCalendar = Calendar.getInstance(Locale.getDefault())
        targetCalendar.time = targetDate
        targetCalendar.getNearestSunday()

        val currentDateIndex =
            (targetCalendar.timeInMillis - startCalendar.timeInMillis) / (DAYS_IN_MS * DAYS_IN_SINGLE_VIEW)

        with(binding.vpWeekView) {
            post {
                currentItem = (currentDateIndex.toInt())
                (adapter as CalendarAdapter).targetDate = targetDate
            }
        }
    }

    fun updateMonth(date: WeeklyCalendarBaseAdapter.Companion.DateHolder) {
        binding.tvMonth.text = date.date.format(DATE_FORMAT_MONTH)
    }



    override fun onCompetitionFixtureFetchedSuccess(fixtures: List<Fixture>?) {
        _calendarViewModel.postValue(fixtures)
        Log.d("calendario", "$fixtures")
    }

    override fun onCompetitionFixtureFetchedFailed() {
        _calendarViewModel.postValue(emptyList())
    }

    companion object {
        const val DAYS_IN_MS = (1000 * 60 * 60 * 24).toLong()
        const val DAYS_IN_SINGLE_VIEW = 7
        const val PREVIOUS_WEEK = 4
        const val UPCOMING_WEEK = 8
    }

    override fun onDateSelected(dateMillis: Date) {
    }

}
