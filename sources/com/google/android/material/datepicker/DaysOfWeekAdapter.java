package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class DaysOfWeekAdapter extends BaseAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f80782d = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Calendar f80783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f80784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f80785c;

    public DaysOfWeekAdapter() {
        Calendar calendarM = UtcDates.m();
        this.f80783a = calendarM;
        this.f80784b = calendarM.getMaximum(7);
        this.f80785c = calendarM.getFirstDayOfWeek();
    }

    private int b(int i3) {
        int i4 = i3 + this.f80785c;
        int i5 = this.f80784b;
        return i4 > i5 ? i4 - i5 : i4;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i3) {
        if (i3 >= this.f80784b) {
            return null;
        }
        return Integer.valueOf(b(i3));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f80784b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f79692w, viewGroup, false);
        }
        this.f80783a.set(7, b(i3));
        textView.setText(this.f80783a.getDisplayName(7, f80782d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.H), this.f80783a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public DaysOfWeekAdapter(int i3) {
        Calendar calendarM = UtcDates.m();
        this.f80783a = calendarM;
        this.f80784b = calendarM.getMaximum(7);
        this.f80785c = i3;
    }
}
