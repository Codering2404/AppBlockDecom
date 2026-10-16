package com.borax12.materialdaterangepicker.date;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.borax12.materialdaterangepicker.date.MonthView;
import java.util.Calendar;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MonthAdapter extends BaseAdapter implements MonthView.OnDayClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f65830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final DatePickerController f65831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CalendarDay f65832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f65833d = -1;

    public MonthAdapter(Context context, DatePickerController datePickerController) {
        this.f65830a = context;
        this.f65831b = datePickerController;
        c();
        g(datePickerController.d());
    }

    private boolean d(int i3, int i4) {
        CalendarDay calendarDay = this.f65832c;
        return calendarDay.f65835b == i3 && calendarDay.f65836c == i4;
    }

    @Override // com.borax12.materialdaterangepicker.date.MonthView.OnDayClickListener
    public void a(MonthView monthView, CalendarDay calendarDay) {
        if (calendarDay != null) {
            e(calendarDay);
        }
    }

    public abstract MonthView b(Context context);

    protected void c() {
        this.f65832c = new CalendarDay(System.currentTimeMillis());
    }

    protected void e(CalendarDay calendarDay) {
        this.f65831b.h();
        this.f65831b.g(calendarDay.f65835b, calendarDay.f65836c, calendarDay.f65837d);
        g(calendarDay);
    }

    public void f(int i3) {
        this.f65833d = i3;
    }

    public void g(CalendarDay calendarDay) {
        this.f65832c = calendarDay;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ((this.f65831b.l() - this.f65831b.m()) + 1) * 12;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        MonthView monthViewB;
        HashMap<String, Integer> map;
        if (view != null) {
            monthViewB = (MonthView) view;
            map = (HashMap) monthViewB.getTag();
        } else {
            monthViewB = b(this.f65830a);
            monthViewB.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            monthViewB.setClickable(true);
            monthViewB.setOnDayClickListener(this);
            int i4 = this.f65833d;
            if (i4 != -1) {
                monthViewB.setAccentColor(i4);
            }
            map = null;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.clear();
        int i5 = i3 % 12;
        int iM = (i3 / 12) + this.f65831b.m();
        int i6 = d(iM, i5) ? this.f65832c.f65837d : -1;
        monthViewB.r();
        map.put("selected_day", Integer.valueOf(i6));
        map.put("year", Integer.valueOf(iM));
        map.put("month", Integer.valueOf(i5));
        map.put("week_start", Integer.valueOf(this.f65831b.e()));
        monthViewB.setMonthParams(map);
        monthViewB.invalidate();
        return monthViewB;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CalendarDay {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Calendar f65834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f65835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f65836c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f65837d;

        public CalendarDay() {
            c(System.currentTimeMillis());
        }

        private void c(long j3) {
            if (this.f65834a == null) {
                this.f65834a = Calendar.getInstance();
            }
            this.f65834a.setTimeInMillis(j3);
            this.f65836c = this.f65834a.get(2);
            this.f65835b = this.f65834a.get(1);
            this.f65837d = this.f65834a.get(5);
        }

        public void a(CalendarDay calendarDay) {
            this.f65835b = calendarDay.f65835b;
            this.f65836c = calendarDay.f65836c;
            this.f65837d = calendarDay.f65837d;
        }

        public void b(int i3, int i4, int i5) {
            this.f65835b = i3;
            this.f65836c = i4;
            this.f65837d = i5;
        }

        public CalendarDay(long j3) {
            c(j3);
        }

        public CalendarDay(Calendar calendar) {
            this.f65835b = calendar.get(1);
            this.f65836c = calendar.get(2);
            this.f65837d = calendar.get(5);
        }

        public CalendarDay(int i3, int i4, int i5) {
            b(i3, i4, i5);
        }
    }
}
